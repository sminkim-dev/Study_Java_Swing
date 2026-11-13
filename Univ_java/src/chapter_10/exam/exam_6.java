package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_6 extends JFrame{
	private JButton [] btn = new JButton [5];
	private JLabel [] la = new JLabel [10];
	
	static class Point{
		private int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private Point [] p = new Point [10];
	public exam_6() {
		super("exam_6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(5,1));
		Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};
		
		for(int i = 0; i < 5; i++) {
			btn[i] = new JButton();
			btn[i].setOpaque(true);
			btn[i].setBackground(color[i]);
			
//			final int index = i;
//			btn[i].addActionListener(e->{
//				for(int j = 0; j < la.length; j++) {
//					la[j].setBackground(color[index]);
//				}
//			});
			
			btn[i].addActionListener(e->{
				JButton selected = (JButton)e.getSource();
				Color selectedColor = selected.getBackground();
				for(int j = 0; j < la.length; j++) {
					la[j].setBackground(selectedColor);
				}
			});
			west.add(btn[i]);
		}
		c.add(west, BorderLayout.WEST);
		
		JPanel center = new JPanel();
		center.setLayout(null);
		
		for(int i = 0; i < 10; i++) {
			int x = (int)(Math.random()*150 + 50);
			int y = (int)(Math.random()*150 + 50);
			p[i] = new Point(x,y);
			la[i] = new JLabel();
			
			la[i].setBounds(x, y, 10, 10);
			la[i].setOpaque(true);
			la[i].setBackground(Color.BLACK);
			center.add(la[i]);
		}
		
		c.add(center, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_6();
	}

}
