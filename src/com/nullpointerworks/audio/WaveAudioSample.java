package com.nullpointerworks.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WaveAudioSample implements AudioSample 
{
	private final int STOPPED = 0;
	private final int PLAYING = 1;
	private final int PAUSED = 2;
	
	private Clip audioclip;
	private long frame;
    private int status;
	
    public WaveAudioSample(final String path) 
    		throws UnsupportedAudioFileException, 
		    IOException, 
		    LineUnavailableException
    {
    	File f = new File(path).getAbsoluteFile();
    	AudioInputStream io = AudioSystem.getAudioInputStream(f);
    	
    	audioclip = AudioSystem.getClip();
    	audioclip.open(io);
    	
    	//FloatControl volume = (FloatControl) audioclip.getControl(FloatControl.Type.MASTER_GAIN);
        //volume.setValue(0.0f);
    	
    	audioclip.loop(0);
    	
    	status = STOPPED;
    }
    
	@Override
	public synchronized void play() 
	{
		audioclip.start();
    	status = PLAYING;
	}
	
	@Override
	public synchronized void pause() 
	{
		if (status == PLAYING)
		{
			frame = audioclip.getMicrosecondPosition();
			audioclip.stop();
			status = PAUSED;
		}
	}
	
	@Override
	public synchronized void resume() 
	{
		if (status == PAUSED)
		{
			
			
			
			status = PLAYING;
		}
	}
	
	@Override
	public synchronized void jump(long ms) 
	{
		
	}
	
	@Override
	public synchronized void restart() 
	{
		
	}
	
	@Override
	public synchronized void stop() 
	{
		
	}
}
