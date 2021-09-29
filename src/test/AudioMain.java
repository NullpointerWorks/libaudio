package test;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

import com.nullpointerworks.audio.AudioSample;
import com.nullpointerworks.audio.WaveAudioSample;

public class AudioMain 
{
	public static void main(String[] args) 
	{
		new AudioMain();
	}
	
	public AudioMain()
	{
		String audioPath = "D:\\Development\\Audio\\Workspace\\Skiffy\\skiffy.wav";
		AudioSample skiffy = null;
		
		try 
		{
			skiffy = new WaveAudioSample(audioPath);
		} 
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
		{
			e.printStackTrace();
			return;
		}
		
		skiffy.play();
		
		
		
		
        // A GUI element to prevent the Clip's daemon Thread
        // from terminating at the end of the main()
		SwingUtilities.invokeLater(new Runnable() 
		{
            public void run()
            {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
    
    
    
}
