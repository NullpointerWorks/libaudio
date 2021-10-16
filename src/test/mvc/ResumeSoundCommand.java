package test.mvc;

import com.nullpointerworks.audio.AudioSample;

public class ResumeSoundCommand implements ActionCommand
{
	private AudioSample sound;
	
	public ResumeSoundCommand(AudioSample snd)
	{
		sound = snd;
	}
	
	
	@Override
	public void onCommand() 
	{
		sound.resume();
	}
	
}
