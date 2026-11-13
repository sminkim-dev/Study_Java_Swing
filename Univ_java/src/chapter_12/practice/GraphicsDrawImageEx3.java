package chapter_12.practice;

import javax.swing.*;
import java.awt.*;
public class GraphicsDrawImageEx3 extends JFrame{
	private MyPanel panel = new MyPanel();
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon(getClass().getResource("/image/buddy2.jpeg"));
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 이미지 (100,50)에서 (200,200)의 영역을 패널 상의 (20,20)에서 (250,100)의 영역으로 확장하여 그린다.
			g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this);
		}
	}
	public GraphicsDrawImageEx3() {
		super("draw image ex3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawImageEx3();
	}

}
