package chapter_10.exam;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class exam_1 extends JFrame{
	private JLabel la = new JLabel("Love Java");
	public exam_1() {
		super("exam_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		MyMouseListener listener = new MyMouseListener();
		la.addMouseListener(listener);
		la.addMouseMotionListener(listener);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
	}
	class MyMouseListener implements MouseListener, MouseMotionListener{
		@Override
		public void mouseExited(MouseEvent e) {
			la.setText("사랑해 자바 ");
		}

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
			la.setText("Love Java");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_1();
	}

}
