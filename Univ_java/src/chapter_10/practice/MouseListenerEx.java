package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerEx extends JFrame{
	private JLabel la = new JLabel("Hello");
	public MouseListenerEx() {
		setTitle("Mouse Event sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.addMouseListener(new MyMouseListener());
		c.setLayout(null);
		
		la.setSize(50,20);
		la.setLocation(30, 30);
		c.add(la);
		
		setSize(250,250);
		setVisible(true);
	}
	class MyMouseListener implements MouseListener{ // MouseListenr가 interface여서 해당 메소드 5개를 전부 구현해야함. 따라서 기능이 없어도 빈칸은 적어줘야함.
	// 아니면 필요한 부분만 @Override 하는 식으로 할 수도 있음.
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerEx();
	}

}
