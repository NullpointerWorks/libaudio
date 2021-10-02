/**
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package com.nullpointerworks.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class ByteAudioSample implements AudioSample 
{
	private final int STOPPED = 0;
	private final int PLAYING = 1;
	private final int PAUSED = 2;
	private int status;
	
	private SourceDataLine dataLine;
	private AudioFormat audioFormat;
	private byte[] data;
    
    public ByteAudioSample(SourceDataLine sdl, AudioFormat af, byte[] bytes)
    {
    	dataLine = sdl;
    	audioFormat = af;
    	data = bytes;
    	
    	status = STOPPED;
    }
    
	@Override
	public synchronized void play() 
	{
		try 
		{
			dataLine.open(audioFormat);
		} 
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
			return;
		}
		
		dataLine.start();

    	status = PLAYING;
    	dataLine.write(data, 0, data.length);
        dataLine.drain();
        
        dataLine.stop();
        dataLine.close();
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
