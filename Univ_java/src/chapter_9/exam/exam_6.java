package chapter_9.exam;
import javax.swing.*;
import java.awt.*;

public class exam_6 extends JFrame{
	public exam_6() {
		super("배치관리자가 없는 컨테이너 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);
		
//		Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.DARK_GRAY
//				, Color.GRAY, Color.CYAN, Color.MAGENTA};
		
		for(int i = 0; i < 20; i++) {
			JLabel la = new JLabel("");
			la.setOpaque(true);
			//la.setBackground(color[i % color.length]);
			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);
			la.setBackground(new Color(r,g,b));
			
			int x = (int)(Math.random()*240 + 10);
			int y = (int)(Math.random()*240 + 10);
			la.setSize(10,10);
			la.setLocation(x, y);
			c.add(la);
		}
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_6();
	}

}
