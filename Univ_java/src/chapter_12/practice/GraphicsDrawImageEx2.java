package chapter_12.practice;

import java.awt.*;
import javax.swing.*;

public class GraphicsDrawImageEx2 extends JFrame{
	private MyPanel panel = new MyPanel();
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon(getClass().getResource("/image/buddy1.jpeg"));
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}
	public GraphicsDrawImageEx2() {
		super("draw Image ex2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawImageEx2();
	}

}
