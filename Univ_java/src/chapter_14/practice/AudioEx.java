package chapter_14.practice;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

public class AudioEx extends JFrame{
	
	private JButton btns[] = {
			new JButton("Play"),
			new JButton("Stop"),
			new JButton("Play again")
	};
	
	private Clip clip;
	private JLabel label = new JLabel();
	private String song = "retro_arcade";
	
	public AudioEx() {
		super("audio control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,150);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyActionListener al = new MyActionListener();
		for(int i = 0; i < btns.length; i++) {
			c.add(btns[i]);
			btns[i].addActionListener(al);
		}
		c.add(label);
		setVisible(true);
		loadAudio(getClass().getResource("/audio/retro_arcade.wav"));
	}
	
	private void loadAudio(URL pathName) {
		try {
			clip = AudioSystem.getClip(); // 비어있는 오디오 클립 만들
			//File audioFile = new File(pathName);
			//AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // 오디오 파일로 부
			//clip.open(audioStream); // 재생할 오디오 스트림 열기
			clip.addLineListener(new LineListener() {
				public void update(LineEvent e) {
					if(e.getType() == LineEvent.Type.STOP) {
						getContentPane().setBackground(Color.ORANGE);
						label.setText(song + " 연주 끝 !");
					}
				}
			});
			clip.open(AudioSystem.getAudioInputStream(pathName));
		}
		catch(LineUnavailableException e) { e.printStackTrace(); }
		catch(UnsupportedAudioFileException e) { e.printStackTrace(); }
		catch(IOException e) {e.printStackTrace();}
	}
	
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Play":clip.start(); break;
			case "Stop":clip.stop(); break;
			case "Play again":
				clip.setFramePosition(0);
				clip.start();
				break;
			}
		}
	}
		
	public static void main(String[] args) {
		new AudioEx();
	}

}
