package chapter_9.practice;
import javax.swing.*;
import java.awt.*;
public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(4,2);
		grid.setVgap(5); // 격자 사이의 수직 간격을 5 픽셀로 설정
		
		Container c = getContentPane();
		c.setLayout(grid);
		c.add(new JLabel("name "));
		c.add(new JTextField(""));
		c.add(new JLabel("학번 "));
		c.add(new JTextField(" "));
		c.add(new JLabel("학과 "));
		c.add(new JTextField(""));
		c.add(new JLabel("과목 "));
		c.add(new JTextField(""));
		
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutEx();
	}

}
