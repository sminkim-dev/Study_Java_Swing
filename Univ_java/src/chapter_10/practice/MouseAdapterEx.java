package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseAdapterEx extends JFrame{
	private JLabel la = new JLabel("Hello");
	public MouseAdapterEx() {
		setTitle("Mouse adapter sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
		c.setLayout(null);
		
		la.setBounds(30, 30, 50, 20);
		c.add(la);
		setSize(250,250);
		setVisible(true);
	}
	class MyMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseAdapterEx();
	}

}
