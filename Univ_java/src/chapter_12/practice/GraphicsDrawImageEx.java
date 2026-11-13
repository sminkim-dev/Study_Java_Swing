package chapter_12.practice;

import javax.swing.*;
import java.awt.*;

public class GraphicsDrawImageEx extends JFrame{
	private MyPanel panel = new MyPanel();
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon(getClass().getResource("/image/buddy1.jpeg"));
		private Image img = icon.getImage(); // object image
		public void paintComponent(Graphics g) {
			g.drawImage(img, 20,20,this);
		}
	}
	public GraphicsDrawImageEx() {
		super("draw image sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawImageEx();
	}

}
