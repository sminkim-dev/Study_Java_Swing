package chapter_11.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxEx extends JFrame{
	public CheckBoxEx() {
		super("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// image checkbox에 사용할 2개의 이미지 객체 생성
		ImageIcon buddy1 = new ImageIcon(getClass().getResource("/image/buddy1.jpeg"));
		ImageIcon buddy2 = new ImageIcon(getClass().getResource("/image/buddy2.jpeg"));
		
		// create check box
		JCheckBox apple = new JCheckBox("Apple");
		JCheckBox pear = new JCheckBox("Pear");
		JCheckBox buddy = new JCheckBox("buddy", buddy1);
		
		buddy.setBorderPainted(true); // 체크 박스 외곽선이 보이도록 설정
		buddy.setSelectedIcon(buddy2);
		
		c.add(apple);
		c.add(pear);
		c.add(buddy);
		
		setSize(600,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxEx();
	}

}
