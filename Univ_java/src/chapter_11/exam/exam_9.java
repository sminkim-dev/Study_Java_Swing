package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_9 extends JFrame{
	private int count = 0;
	private JLabel [] la = new JLabel[10];
	private void logic() {
		if(count == 10) {
			for(int i = 0; i < la.length; i++) {
				int x = (int)(Math.random() * 280 + 10);
				int y = (int)(Math.random() * 280 + 10);
				
				la[i].setBounds(x,y,15,15);
				la[i].setVisible(true);
			}
			count = 0;
		}
	}
	public exam_9() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);
		
		for(int i = 0; i < la.length; i++) {
			int x = (int)(Math.random() * 280 + 10);
			int y = (int)(Math.random() * 280 + 10);
			
			la[i] = new JLabel(Integer.toString(i));
			la[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					JLabel l = (JLabel)e.getSource();
					int text = Integer.parseInt(l.getText());
					if(text == count) {
						l.setVisible(false);
						count++;
					}
					logic();
				}				
			});
			la[i].setBounds(x, y, 15, 15);
			c.add(la[i]);
		}
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_9();
	}

}
