package chapter_12.practice;

import javax.swing.*;
import java.awt.*;

public class paintComponentEx extends JFrame{

	public paintComponentEx() {
		super("make the new button");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		MyButton b = new MyButton("new Button");
		b.setOpaque(true);
		b.setBackground(Color.CYAN);
		c.add(b);
		setSize(300,200);
		setVisible(true);
	}
	class MyButton extends JButton{
		public MyButton(String s) {
			super(s);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new paintComponentEx();
	}

}
