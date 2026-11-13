package chapter_11.practice;

import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame{
	public LabelEx() {
		super("Label sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("사랑합니다.");
		
		ImageIcon beauty = new ImageIcon(getClass().getResource("/image/beauty.jpeg"));
		JLabel imageLabel = new JLabel(beauty);
		
		ImageIcon call = new ImageIcon(getClass().getResource("/image/call.jpeg"));
		JLabel label = new JLabel("보고 싶으면, 전화하세요.", call, SwingConstants.CENTER);
		
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);
		
		setSize(400,600);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LabelEx();
	}

}
