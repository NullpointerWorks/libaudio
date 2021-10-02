package test.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppView
{
	private JFrame wnd;
	
	
	public AppView()
	{
		
		
		
		
		
		
		
		
		
		
		
		wnd = new JFrame();
		wnd.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		wnd.setSize(800,600);
		wnd.setPreferredSize(wnd.getSize());
		wnd.setTitle("Audio Lib Test");
		wnd.setLocationRelativeTo(null);
		wnd.pack();
	}
	
	
	public void setVisible(boolean b)
	{
		wnd.setVisible(b);
	}
	
	
}
