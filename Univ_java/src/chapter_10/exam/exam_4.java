package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_4 extends JFrame{
	private JLabel [] l = new JLabel [25];
	private int index = 12;
	private void moving() {
		for(int i = 0; i < 25; i++) {
			if(i == index) {
				l[i].setOpaque(true);
				l[i].setBackground(Color.BLUE);
			}
			else {
				l[i].setBackground(Color.white);
			}
		}
	}
	public exam_4() {
		super("exam_4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		JLabel la = new JLabel("상하좌우 키로 블록을 이동시킬 수 있음 ");
		north.add(la);
		c.add(north, BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5,5,1,1));
		center.setBackground(Color.PINK);
		
		for(int i = 0; i < 25; i++) {
			l[i] = new JLabel();
			if(i == 12) {
				l[i].setOpaque(true);
				l[i].setBackground(Color.BLUE);
			}
			else {
				l[i].setOpaque(true);
				l[i].setBackground(Color.WHITE);
			}
			center.add(l[i]);
		}
		
		center.addKeyListener(new MyKeyListener());
		
		c.add(center, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
		
		center.setFocusable(true);
		center.requestFocus();
		
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				if(index >= 5) {
					index -= 5;
					moving();
				}
				break;
			case KeyEvent.VK_DOWN:
				if(index < 20) {
					index += 5;
					moving();
				}
				break;
			case KeyEvent.VK_LEFT:
				if(index % 5 != 0) {
					index -= 1;
					moving();
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(index % 5 != 4) {
					index += 1;
					moving();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_4();
	}

}
