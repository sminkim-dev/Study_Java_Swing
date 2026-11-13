package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_1 extends JFrame{
	public exam_1() {
		super("Make a Window using Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setBackground(Color.YELLOW);
		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_1();
	}

}
