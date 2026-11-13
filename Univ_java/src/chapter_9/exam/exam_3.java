package chapter_9.exam;
import javax.swing.*;
import java.awt.*;

public class exam_3 extends JFrame{
	public exam_3() {
		super("GridLayou로 10개의 버튼을 배치한 프레임 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridLayout grid = new GridLayout(1,10);
		c.setLayout(grid);
		
		for(int i = 0; i <= 9; i++) {
			JButton b = new JButton(Integer.toString(i));
			c.add(b);
		}
		setSize(500,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_3();
	}

}
