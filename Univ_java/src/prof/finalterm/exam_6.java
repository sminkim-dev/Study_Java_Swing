package prof.finalterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// random circle
public class exam_6 extends JFrame{
	
	static class MyPanel extends JPanel{
		public int x , y;
		public int size;
		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            if (x >= 0 && y >= 0) {
                g.fillOval(x, y, size, size); // 지정된 좌표에 원 그리기
            }
        }
	}
	
	static class RandomC extends Thread{
		
		private MyPanel mp;
		private Container contentPane;
		public boolean flag = false;
		
		
		public RandomC(MyPanel mp) {
			this.mp = mp;
		}
		
		void finish() {
			flag = true;
		}
		
		public void run() {
			while(true) {
				mp.x = (int)(Math.random() * (mp.getWidth() - mp.size));
				mp.y = (int)(Math.random() * (mp.getHeight() - mp.size));
				System.out.println("thread start" + " " + mp.x + " , " + mp.y);
				
				mp.repaint();
				try {
					Thread.sleep(500); // 0.5seconds 간격으로 동작.
					
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}
	
	private RandomC th;
	
	public exam_6() {
		super("실습 6번 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		MyPanel mp = new MyPanel();
		mp.size = 30;
		mp.x = mp.size;
		mp.y = mp.size;
		
		mp.setBounds(0, 0, 300, 300);
		c.add(mp);
		mp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th = new RandomC(mp);
				th.start();
			}
			
		});
		setSize(300,300);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new exam_6();
	}

}
