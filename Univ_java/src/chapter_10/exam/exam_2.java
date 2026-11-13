package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_2 extends JFrame{
	public exam_2() {
		super("exam_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.GREEN);
		
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		
		setSize(300,300);
		setVisible(true);
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			Component com = (Component)e.getSource();
			com.setBackground(Color.YELLOW);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			Component com = (Component)e.getSource();
			com.setBackground(Color.GREEN);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_2();
	}

}
