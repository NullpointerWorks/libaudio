package test.mvc;

import com.nullpointerworks.audio.AudioSample;

public class PlaySoundCommand implements ActionCommand
{
	private AudioSample sound;
	
	public PlaySoundCommand(AudioSample snd)
	{
		sound = snd;
	}
	
	
	@Override
	public void onCommand() 
	{
		sound.play();
	}
	
}
