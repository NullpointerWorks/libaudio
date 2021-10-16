package test.mvc;

import com.nullpointerworks.audio.AudioSample;

public class StopSoundCommand implements ActionCommand
{
	private AudioSample sound;
	
	public StopSoundCommand(AudioSample snd)
	{
		sound = snd;
	}
	
	
	@Override
	public void onCommand() 
	{
		sound.stop();
	}
	
}
