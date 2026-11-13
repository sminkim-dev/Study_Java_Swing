package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class exam_8 extends JFrame{
	private Vector<ImageIcon> vec_img = new Vector<>();
	private ImageIcon [] img = {
			new ImageIcon(getClass().getResource("/image/buddy1.jpeg")),
			new ImageIcon(getClass().getResource("/image/buddy2.jpeg")),
			new ImageIcon(getClass().getResource("/image/buddy3.jpeg"))
	};
	private JRadioButton [] r_btn = new JRadioButton[2];
	private JLabel la = new JLabel(img[0]);
	private String [] text = {"left", "right"}; 
	private int loc;
	
	public exam_8() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		// add imageicon to vec
		for(int i = 0; i < img.length; i++) {
			vec_img.add(img[i]);
		}
		
		c.setLayout(new FlowLayout());
		
		MymouseListener listener = new MymouseListener();
		c.addMouseListener(listener);
		
		c.setFocusable(true);
		c.requestFocus();
		ButtonGroup g = new ButtonGroup();
		for(int i = 0; i < r_btn.length; i++) {
			r_btn[i] = new JRadioButton(text[i]);
			
			final int index = i;
			r_btn[i].addActionListener(e->{
				if(index == 0) {
					// <- shift
					loc = index;
				}
				else if(index == 1) {
					// -> shift
					loc = index;
				}
			});
			
			
			c.add(r_btn[i]);
			g.add(r_btn[i]);
		}
		c.add(la);
		
		setSize(500,500);
		setVisible(true);
	}
	class MymouseListener implements MouseListener{
		private int count = 0;
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(loc == 0) {
				// <- shift
				if(count == 0) {
					count = vec_img.size() - 1;
				}
				else {
					count--;
				}
			}
			else if(loc == 1) {
				// shift ->
				if(count == 2) {
					count = 0;
				}
				else {
					count++;
				}
			}
			la.setIcon(vec_img.get(count));
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
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_8();
	}

}
