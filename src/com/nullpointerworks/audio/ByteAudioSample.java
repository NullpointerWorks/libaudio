package com.nullpointerworks.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ByteAudioSample implements AudioSample 
{
	private final int STOPPED = 0;
	private final int PLAYING = 1;
	private final int PAUSED = 2;
	
	private Clip audioclip;
	private long frame;
    private int status;
	
    public ByteAudioSample(byte[] bytes)
    {
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	status = STOPPED;
    }
    
	@Override
	public synchronized void play() 
	{
		
		
		
    	status = PLAYING;
	}
	
	@Override
	public synchronized void pause() 
	{
		if (status == PLAYING)
		{
			
			
			
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
		
		
		status = PLAYING;
	}
	
	@Override
	public synchronized void restart() 
	{
		
		status = PLAYING;
	}
	
	@Override
	public synchronized void stop() 
	{
		
		status = STOPPED;
	}
}
