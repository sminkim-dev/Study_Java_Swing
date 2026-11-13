package chapter_12.practice;

import javax.swing.*;
import java.awt.*;

public class GraphicsClipEx extends JFrame{
	private MyPanel panel = new MyPanel();
	public GraphicsClipEx() {
		super("using Clip sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(400,400);
		setVisible(true);
	}
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon(getClass().getResource("/image/buddy3.jpeg"));
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setClip(100,20,150,150);
			g.drawImage(img,  0, 0, getWidth(),  getHeight(),  this);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Arial", Font.ITALIC, 40));
			g.drawString("GO Gator!", 10, 150);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsClipEx();
	}

}
