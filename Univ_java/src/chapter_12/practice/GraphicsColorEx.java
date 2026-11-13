package chapter_12.practice;

import javax.swing.*;
import java.awt.*;

public class GraphicsColorEx extends JFrame{
	private MyPanel panel = new MyPanel();
	public GraphicsColorEx() {
		super("Color, Font use sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawString("I love Java", 30, 30);
			g.setColor(new Color(255,0,0));
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("how much?", 30, 60);
			g.setColor(new Color(0x00ff00ff));
			for(int i = 1; i <=5; i++) {
				g.setFont(new Font("Jokerman", Font.ITALIC, i*10));
				g.drawString("This much?", 30, 60 + i * 20);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		new GraphicsColorEx();
	}

}
