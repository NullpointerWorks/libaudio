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
	
	private long currentFrame;
	private Clip audioclip;
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
    	
    	FloatControl volume = (FloatControl) audioclip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(0.0f); // Reduce volume by 10 decibels.
    	
    	audioclip.loop(0);
    	
    	status = STOPPED;
    }
    
	@Override
	public void play() 
	{
		audioclip.start();
    	status = PLAYING;
	}
	
	@Override
	public void pause() 
	{
		
	}
	
	@Override
	public void resume() 
	{
		
	}
	
	@Override
	public void jump(long ms) 
	{
		
	}
	
	@Override
	public void restart() 
	{
		
	}
	
	@Override
	public void stop() 
	{
		
	}
}
