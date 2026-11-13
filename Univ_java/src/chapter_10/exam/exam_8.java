package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_8 extends JFrame{
	private JLabel [] la = new JLabel [12];
	public exam_8() {
		super("exam_8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(3,4,5,5));
		
		MyMouseListener listener = new MyMouseListener();
		for(int i = 0; i < 12; i++) {
			la[i] = new JLabel(Integer.toString(i + 1));
			la[i].setOpaque(true);
			la[i].setBackground(Color.YELLOW);
			la[i].addMouseListener(listener);
			
			c.add(la[i]);
		}
		setSize(300,300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyMouseListener extends MouseAdapter{
		private int check = 0;
		private JLabel [] tmp = new JLabel[2];
		public void mouseClicked(MouseEvent e) {
			JLabel l = (JLabel)e.getSource();
			l.setBackground(Color.PINK);
			
			tmp[check++] = l;
			if(check == 2) {
				String temp = tmp[0].getText();
				tmp[0].setText(tmp[1].getText());
				tmp[1].setText(temp);
				
				tmp[0].setBackground(Color.YELLOW);
				tmp[1].setBackground(Color.YELLOW);
				
				check = 0;
			}
		}
	}
	public static void main(String [] args) {
		new exam_8();
	}
}
