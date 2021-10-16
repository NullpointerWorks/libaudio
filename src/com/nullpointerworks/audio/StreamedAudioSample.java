/**
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package com.nullpointerworks.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class StreamedAudioSample implements AudioSample
{
	private final int STOPPED = 0;
	private final int PLAYING = 1;
	private final int PAUSED = 2;
	
	private final String path;
	private LineListener ll;
	private Clip audioclip;
	private long usec;
    private int status;
	
    
    public StreamedAudioSample(final String path) 
    {
    	ll = new LineListener() 
    	{
    		@Override
    		public void update(LineEvent event) 
    		{
    			if (event.getType() == Type.STOP)
    			{
    				status = STOPPED;
    			}
    		}
    	};
    	
    	this.path = path;
    	usec = 0l;
    	status = STOPPED;
    	reset(path);
    	
    	//FloatControl volume = (FloatControl) audioclip.getControl(FloatControl.Type.MASTER_GAIN);
        //volume.setValue(0.0f);
    }
	
	private boolean reset(final String path) 
	{
    	try 
    	{
			File f = new File(path).getAbsoluteFile();
	    	AudioInputStream io = AudioSystem.getAudioInputStream(f);
	    	audioclip = AudioSystem.getClip();
	    	audioclip.addLineListener(ll);
	    	audioclip.loop(0);
	    	audioclip.open(io);
		} 
		catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) 
		{
			e.printStackTrace();
			return false;
		}
    	return true;
	}
    
	@Override
	public synchronized void play() 
	{
		if (status != STOPPED)
		{
			stop();
	    	status = STOPPED;
			if (!reset(path)) return;
		}
		
		audioclip.setMicrosecondPosition(0);
		audioclip.start();
    	status = PLAYING;
	}
	
	@Override
	public synchronized void stop() 
	{
		usec = 0l;
		audioclip.stop();
		audioclip.close();
	}
	
	@Override
	public synchronized void pause() 
	{
		if (status == PLAYING)
		{
			usec = audioclip.getMicrosecondPosition();
			audioclip.stop();
			status = PAUSED;
		}
	}
	
	@Override
	public synchronized void resume() 
	{
		if (status == PAUSED)
		{
			audioclip.stop();
			audioclip.close();
			if (!reset(path)) 
			{
		    	status = STOPPED;
				return;
			}
			audioclip.setMicrosecondPosition(usec);
			audioclip.start();
	    	status = PLAYING;
		}
	}
	
	@Override
	public synchronized void jump(long off) 
	{
		if (off < 0) off = 0l;
		if (off > audioclip.getMicrosecondLength()) off = audioclip.getMicrosecondLength();
		status = PAUSED;
		resume();
	}
}
