package chapter_13.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThreadFinishFlagEx extends JFrame{
	class RandomThread extends Thread{
		private Container contentPane;
		private volatile boolean flag=false; // flag의 종료 명령을 표시하는 플래그 true : 종료 지시 
		
		public RandomThread(Container contentPane) {
			this.contentPane = contentPane;
		}
		public void finish() {
			flag=true;
		}
		@Override
		public void run() {
			while(true) {
				int x = (int)(Math.random() * contentPane.getWidth());
				int y = (int)(Math.random() * contentPane.getHeight());
				JLabel label = new JLabel("java");
				label.setSize(80,30);
				label.setLocation(x, y);
				SwingUtilities.invokeLater(() -> {
				    contentPane.add(label);
				    contentPane.revalidate();
				    contentPane.repaint();
				});
				
				try {
					Thread.sleep(300);
					if(flag==true) {
						SwingUtilities.invokeLater(() -> {
					        contentPane.removeAll();

					        JLabel finishLabel = new JLabel("Finish");
					        finishLabel.setSize(80, 30);
					        finishLabel.setLocation(x, y);
					        finishLabel.setForeground(Color.RED);

					        contentPane.add(finishLabel);
					        contentPane.revalidate();
					        contentPane.repaint();
					    });
						return;
					}
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	private RandomThread th;
	public ThreadFinishFlagEx() {
		super("Thread Finished sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		setSize(500,500);
		setVisible(true);
		
		th = new RandomThread(c);
		th.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadFinishFlagEx();
	}

}
