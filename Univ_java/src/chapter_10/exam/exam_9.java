package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_9 extends JFrame{
	private JLabel la = new JLabel("Love Java");
	public exam_9() {
		super("exam_9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener();
		la.addMouseWheelListener(listener);
		
		c.add(la);
		
		setSize(200,100);
		setVisible(true);
		
		la.setFocusable(true);
		la.requestFocus();
	}
	class MyMouseListener implements MouseWheelListener{

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			int rotation = e.getWheelRotation();
			
			JLabel l = (JLabel)e.getSource();
			float size = l.getFont().getSize2D();
			if(rotation < 0) {
				// up
				size += 5;
			}
			else {
				// down
				if(size > 9) {
					size -= 5;
				}
			}
			l.setFont(l.getFont().deriveFont(size));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_9();
	}

}
