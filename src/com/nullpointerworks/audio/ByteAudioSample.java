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
	private byte[] raw;
	
	private int frame;
	private int frameSize;
    
    public ByteAudioSample(SourceDataLine sdl, AudioFormat af, byte[] bytes)
    {
    	dataLine = sdl;
    	audioFormat = af;
    	raw = bytes;
    	status = STOPPED;
    	
    	frame = 0;
    	frameSize = audioFormat.getFrameSize();
    	
    	System.out.println("frameSize: "+frameSize);
    }
    
	@Override
	public void play() 
	{
		if (status == PLAYING) return;
		
		try 
		{
			dataLine.open(audioFormat);
		} 
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
			return;
		}
		
    	status = PLAYING;
		dataLine.start();
    	dataLine.write(raw, 0, raw.length);
        dataLine.drain();
        dataLine.stop();
        dataLine.close();
        status = STOPPED;
	}
	
	@Override
	public void stop() 
	{
		frame = 0;
		status = STOPPED;
	}
	
	@Override
	public void pause() 
	{
		if (status == PLAYING)
		{
	        dataLine.stop();
			dataLine.flush();
			frame += (int)dataLine.getFramePosition();
			
			//float micro = (float)dataLine.getMicrosecondPosition();
			//float sec = micro * 0.000001f;
			//float currFrame = sec * audioFormat.getSampleRate();
			//frame += (int)(currFrame + 0.5f);

	    	System.out.println("frame: "+frame);
			
			status = PAUSED;
		}
	}
	
	@Override
	public void resume() 
	{
		if (status == PAUSED)
		{
			int fr = frame * frameSize;
			
			status = PLAYING;
			dataLine.start();
	    	dataLine.write(raw, fr, raw.length - fr);
	        dataLine.drain();
	        dataLine.stop();
	        dataLine.close();
	        status = STOPPED;
	        
	        
		}
	}
	
	@Override
	public void jump(long ms) 
	{
		
		
		status = PLAYING;
	}
}
