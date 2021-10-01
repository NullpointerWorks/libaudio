package com.nullpointerworks.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;

public class ByteAudioSample implements AudioSample 
{
	private final int STOPPED = 0;
	private final int PLAYING = 1;
	private final int PAUSED = 2;
	
    private int status;
	
    public ByteAudioSample(SourceDataLine sdl, AudioFormat audioFormat, byte[] bytes)
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
