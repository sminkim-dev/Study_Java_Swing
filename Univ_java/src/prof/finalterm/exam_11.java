package prof.finalterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_11 extends JFrame{
	
	private Container c;
	private JLabel l = new JLabel();
	
	
	public exam_11() {
		super("Mini game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setLayout(null);
		
		l.setSize(100,100);
		l.setLocation(150,300);
		l.setOpaque(true);
		l.setBackground(Color.black);
		c.add(l);
		
		Monster mm = new Monster(c);
		mm.start();
		
		c.setFocusable(true);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Bullet bb = new Bullet(c);
					bb.start();
				}
			}
		});
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new exam_11();
	}

}
class Monster extends Thread{

	public JLabel m = new JLabel();
	Point m_position;
	Container c;
	public  Point m_start = new Point(0,0);
	
	public Monster(Container c) {
		this.c = c;
		m_position = m_start;
		m.setSize(50,50);
		m.setOpaque(true);
		m.setBackground(Color.CYAN);
		m.setLocation(m_start);
		c.add(m);
	}
	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(20);
				m_position.x = (m_position.x + 5) % 350;
				m.setLocation(m_position);
				c.repaint();
			}
		}
		catch(Exception e) {
			
		}
	}
}

 class Bullet extends Thread{

	public JLabel b = new JLabel();
	Point b_position;
	Container c;
	public  Point b_start = new Point(200,300);
	
	public Bullet(Container c) {
		this.c = c;
		b_position = b_start;
		b.setSize(10,10);
		b.setOpaque(true);
		b.setBackground(Color.RED);
		b.setLocation(b_start);
		c.add(b);
	}
	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(20);
				b_position.y = ((b_position.y - 5) % 400 ) % 400;
				b.setLocation(b_position);
				c.repaint();
			}
		}
		catch(Exception e) {
			
		}
	}
}
