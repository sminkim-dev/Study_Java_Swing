package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_5 extends JFrame{
	public exam_5() {
		super("4x4 COlor Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		GridLayout grid = new GridLayout(4,4);
		c.setLayout(grid);
		Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.DARK_GRAY
				, Color.GRAY, Color.CYAN, Color.MAGENTA};
		
		for(int i = 0; i < 16; i++) {
			JLabel la = new JLabel(Integer.toString(i));
			la.setOpaque(true);
			la.setBackground(color[i % color.length]);
			c.add(la);
		}
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_5();
	}

}
