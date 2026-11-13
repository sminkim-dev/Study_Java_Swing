package chapter_13.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ThreadInterruptEx extends JFrame{

	class TimerRunnable implements Runnable{
		private JLabel timerLabel;
		
		public TimerRunnable(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		
		@Override
		public void run() {
			int n = 0;
			while(true) {
				timerLabel.setText(String.valueOf(n));
				n++;
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	private Thread th;
	private boolean state = true;
	public ThreadInterruptEx() {
		super("thread interrupt sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable);
		c.add(timerLabel);
		
		
		JButton btn = new JButton("Kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
			}
		});
		c.add(btn);
		
		setSize(300,200);
		setVisible(true);
		
		th.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadInterruptEx();
	}

}
