package test.mvc;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppView
{
	
	private JFrame wnd;
	private JButton jbPlay;
	
	public AppView()
	{
		
		jbPlay = new JButton();
		jbPlay.setLocation(10,10);
		jbPlay.setSize(100, 25);
		jbPlay.setPreferredSize(jbPlay.getSize());
		jbPlay.setText("Play");
		
		JPanel jpControls = new JPanel();
		jpControls.setLayout(new AbsoluteLayout());
		jpControls.setSize(800,600);
		jpControls.setPreferredSize(jpControls.getSize());
		jpControls.add(jbPlay);
		
		wnd = new JFrame();
		wnd.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		wnd.setTitle("libaudio");
		wnd.add(jpControls);
		wnd.pack();
		wnd.setLocationRelativeTo(null);
	}
	
	public void setVisible(boolean b)
	{
		wnd.setVisible(b);
	}
	
	public void setPlayCommandAction(ActionListener l)
	{
		jbPlay.addActionListener(l);
	}
}
