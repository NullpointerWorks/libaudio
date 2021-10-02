package test.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ActionCommand extends RunnableCommand, ActionListener 
{
	@Override
	public default void actionPerformed(ActionEvent e)
	{
		Thread t = new Thread(this);
		t.start();
	}
}
