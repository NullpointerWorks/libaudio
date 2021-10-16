package test.mvc;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppView
{
	
	private JFrame wnd;
	private JButton jbPlay;
	private JButton jbPause;
	private JButton jbResume;
	private JButton jbStop;
	
	public AppView()
	{
		
		jbPlay = new JButton();
		jbPlay.setLocation(10,10);
		jbPlay.setSize(100, 25);
		jbPlay.setPreferredSize(jbPlay.getSize());
		jbPlay.setText("Play");
		
		jbPause = new JButton();
		jbPause.setLocation(10, 40);
		jbPause.setSize(100, 25);
		jbPause.setPreferredSize(jbPause.getSize());
		jbPause.setText("Pause");
		
		jbResume = new JButton();
		jbResume.setLocation(10, 70);
		jbResume.setSize(100, 25);
		jbResume.setPreferredSize(jbResume.getSize());
		jbResume.setText("Resume");
		
		jbStop = new JButton();
		jbStop.setLocation(10, 100);
		jbStop.setSize(100, 25);
		jbStop.setPreferredSize(jbStop.getSize());
		jbStop.setText("Stop");
		
		
		
		JPanel jpControls = new JPanel();
		jpControls.setLayout(new AbsoluteLayout());
		jpControls.setSize(640,480);
		jpControls.setPreferredSize(jpControls.getSize());
		jpControls.add(jbPlay);
		jpControls.add(jbPause);
		jpControls.add(jbResume);
		jpControls.add(jbStop);
		
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
	
	public void setPlayCommandAction(ActionListener l) {jbPlay.addActionListener(l);}
	public void setPauseCommandAction(ActionListener l) {jbPause.addActionListener(l);}
	public void setResumeCommandAction(ActionListener l) {jbResume.addActionListener(l);}
	public void setStopCommandAction(ActionListener l) {jbStop.addActionListener(l);}
}
