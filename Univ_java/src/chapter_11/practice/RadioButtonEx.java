package chapter_11.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonEx extends JFrame{
	public RadioButtonEx() {
		super("make the radio button sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon buddy1 = new ImageIcon(getClass().getResource("/image/buddy1.jpeg"));
		ImageIcon buddy2 = new ImageIcon(getClass().getResource("/image/buddy2.jpeg"));
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton apple = new JRadioButton("apple");
		JRadioButton pear = new JRadioButton("pear");
		JRadioButton buddy = new JRadioButton("buddy", buddy1);
		buddy.setBorderPainted(true);
		buddy.setSelectedIcon(buddy2);
		
		g.add(apple);
		g.add(pear);
		g.add(buddy);
		
		c.add(apple);
		c.add(pear);
		c.add(buddy);
		
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RadioButtonEx();
	}

}
