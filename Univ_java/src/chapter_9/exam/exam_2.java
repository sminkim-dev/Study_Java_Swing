package chapter_9.exam;
import javax.swing.*;
import java.awt.*;

public class exam_2 extends JFrame{
	public exam_2() {
		super("BorderLayout 배치 관리자 연습 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(5,7)); // BorderLayout(int hgap, int vgap) 수평 , 수직 
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		c.add(new JButton("Center"), BorderLayout.CENTER);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("East"), BorderLayout.EAST);
		
		setSize(400,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_2();
	}
}
