package chapter_13.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel{
	private int barSize = 0;
	private int maxBarSize;
	
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width==0)return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized public void fill() {
		if(barSize == maxBarSize) {
	        try {
	            wait();
	        } catch(InterruptedException e) {
	            return;
	        }
	    }

	    barSize++;
	    repaint();
	    notify();
	}
	synchronized public void consume() {
		if(barSize == 0) {
			try {
				wait(); // 바의 크기가 0이면 바의 크기가 0보다 커질때 까지 대기 
			}
			catch(InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint(); // 바의 크기가 변했으니 다시 그리기 
		notify(); // 기다리는 이벤트 스레드 깨우기 
	}
}

class ConsumerThread extends Thread{
	private MyLabel bar;
	public ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume(); // 0.2초마다 바를 1씩 줄인다. 
			}
			catch(InterruptedException e) {
				return;
			}
			
		}
	}
}

public class TaabAndThreadEx extends JFrame{
	private MyLabel bar = new MyLabel(100);
	
	public TaabAndThreadEx(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300,20);
		c.add(bar);
		
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				bar.fill();
			}
		});
		setSize(350,200);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocusInWindow();
		ConsumerThread th = new ConsumerThread(bar);
		th.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TaabAndThreadEx("아무키나 빨리 눌러 바 채우기 ");
	}

}
