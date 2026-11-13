package chapter_12.practice;

import javax.swing.*;
import java.awt.*;

public class GraphicsDrawStringEx extends JFrame{
	private MyPanel panel = new MyPanel();
	public GraphicsDrawStringEx() {
		super("sample using drawString");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,200);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			g.drawString("java is funny ", 30, 30);
			g.drawString("how much? To the ends of the Earth", 60, 60);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawStringEx();
	}

}
