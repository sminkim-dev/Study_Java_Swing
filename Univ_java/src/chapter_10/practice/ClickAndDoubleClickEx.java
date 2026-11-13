package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickAndDoubleClickEx extends JFrame{
	public ClickAndDoubleClickEx() {
		super("Click and Double Click Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		setSize(300,200);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				
				Component com = (Component)e.getSource();
				com.setBackground(new Color(r,g,b));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClickAndDoubleClickEx();
	}

}
