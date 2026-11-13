package chapter_13.practice;

import java.awt.*;
import javax.swing.*;

public class ThreadTimerEx extends JFrame{
	class TimerThread extends Thread{
		private JLabel timerLabel;
		
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		@Override
		public void run() {
			for(int i = 0; i <= 30; i++) {
				timerLabel.setText(String.valueOf(i));
				try {
					sleep(1000);
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}

	public ThreadTimerEx() {
		super("Thread Timer sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel);
		
		setSize(300,170);
		setVisible(true);
		
		th.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTimerEx();
	}

}
