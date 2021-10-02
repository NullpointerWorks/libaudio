/**
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package test;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import com.nullpointerworks.audio.AudioSample;
import com.nullpointerworks.audio.ByteAudioSample;
import com.nullpointerworks.audio.StreamedAudioSample;

import test.mvc.ActionCommand;
import test.mvc.AppView;
import test.mvc.PlaySoundCommand;

public class AudioMain 
{
	public static void main(String[] args) 
	{
		try 
		{
			new AudioMain();
		} 
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) 
		{
			e.printStackTrace();
		}
	}
	
	private final float SAMPLERATE_44100HZ = 44100.0f;
	private final float SAMPLERATE_22050HZ = 22050.0f;
	private final float SAMPLERATE_11025HZ = 11025.0f;
	
	public AudioMain() throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		// load file
		//String audioPath = "D:\\Development\\Audio\\Workspace\\Skiffy\\skiffy.wav";
		String audioPath = "D:\\Development\\Audio\\Workspace\\Skiffy\\oxp.wav";
		
		/*
		File f = new File(audioPath).getAbsoluteFile();
    	AudioInputStream io = AudioSystem.getAudioInputStream(f);
    	
    	// convert audio info
    	AudioFormat baseFormat = io.getFormat();
        AudioFormat audioFormat = new AudioFormat(	AudioFormat.Encoding.PCM_SIGNED, 
        											baseFormat.getSampleRate(), 
									        		16, 
									        		baseFormat.getChannels(), 
									        		baseFormat.getChannels() * 2, 
									        		baseFormat.getSampleRate(), 
									        		false);
        
        // extract byte data
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFormat, io);
		byte[] audioData = audioStream.readAllBytes();
		
		// get data line
		Info info = new Info(SourceDataLine.class, audioFormat);
		SourceDataLine sdl = (SourceDataLine) AudioSystem.getLine(info);
		//*/
		
		//AudioSample skiffy = new ByteAudioSample(sdl, audioFormat, audioData);
		AudioSample skiffy = new StreamedAudioSample(audioPath);
		
		
		ActionCommand acPlay = new PlaySoundCommand(skiffy);
		
		AppView view = new AppView();
		
		view.setPlayCommandAction(acPlay);
		view.setVisible(true);
	}
	
    
}
