package test.mvc;

import com.nullpointerworks.audio.AudioSample;

public class PauseSoundCommand implements ActionCommand
{
	private AudioSample sound;
	
	public PauseSoundCommand(AudioSample snd)
	{
		sound = snd;
	}
	
	
	@Override
	public void onCommand() 
	{
		sound.pause();
	}
	
}
