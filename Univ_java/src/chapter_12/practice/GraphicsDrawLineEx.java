package chapter_12.practice;

import javax.swing.*;
import java.awt.*;

public class GraphicsDrawLineEx extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawLineEx() {
		super("using drawLine sample ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,300);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(20, 20, 100, 100); //(20,20) -> (100,100) draw line point to point
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawLineEx();
	}

}
