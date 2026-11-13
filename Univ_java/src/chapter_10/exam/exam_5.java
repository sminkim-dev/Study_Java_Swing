package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_5 extends JFrame{
	private JLabel la = new JLabel("C");
	public exam_5() {
		super("exam_5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);
		la.setBounds(100, 100, 10, 10);
		
		MyMouseListener listener = new MyMouseListener();
		la.addMouseListener(listener);
		la.addMouseMotionListener(listener);
		
		c.add(la);
		setSize(300,300);
		setVisible(true);
		
		la.setFocusable(true);
		la.requestFocus();
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{
		private boolean check = false;

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(check == true) {
				int x = (int)(Math.random()*280 + 10);
				int y = (int)(Math.random()*280 + 10);
				
				la.setLocation(x, y);	
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			check = true;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			check = false;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_5();
	}

}
