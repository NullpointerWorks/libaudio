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
	
	public AudioMain() throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		// load file
		String audioPath = "D:\\Development\\Audio\\Workspace\\Skiffy\\skiffy.wav";
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
		byte[] audiodata = audioStream.readAllBytes();
		
		// get data line
		Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		SourceDataLine sdl = (SourceDataLine) AudioSystem.getLine(info);
		
		// play the sound
		sdl.open(audioFormat);
		sdl.start();
		
        sdl.write(audiodata, 0, audiodata.length);
        
        sdl.drain();
        sdl.stop();
        sdl.close();
		
		
	}
	
    
    
    
}
