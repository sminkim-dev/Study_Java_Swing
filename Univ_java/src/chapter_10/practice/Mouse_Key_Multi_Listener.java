package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Mouse_Key_Multi_Listener extends JFrame{
	private JLabel la = new JLabel("Hello");
	private final int val = 10;
	public Mouse_Key_Multi_Listener () {
		super("sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		la.setBounds(50, 50, 100, 20);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				la.setLocation(x, y);
				
				c.requestFocusInWindow();
			}
		});
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(), la.getY() - val);break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),  la.getY() + val);break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX() + val,  la.getY());break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX() - val, la.getY()); break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mouse_Key_Multi_Listener();
	}

}
