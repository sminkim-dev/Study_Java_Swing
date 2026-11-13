package chapter_13.practice;

import javax.swing.*;
import java.awt.*;

public class RunnableTimerEx extends JFrame{
	class TimerRunnable implements Runnable{
		private JLabel timerLabel;
		
		public TimerRunnable(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		
		@Override
		public void run() {
			for(int i = 0; i <= 30; i++) {
				timerLabel.setText(String.valueOf(i));
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	public RunnableTimerEx() {
		super("Runnable을 구현한 타이머 스레드 예제 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable);
		
		setSize(250,150);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunnableTimerEx();
	}

}
