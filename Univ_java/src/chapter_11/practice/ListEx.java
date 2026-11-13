package chapter_11.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListEx extends JFrame{
	private String [] text = {"apple", "banana", "pear", "mango", "kiwi", "peach", "berry", "strawberry", "blackberry"};
	private ImageIcon [] image = {
			new ImageIcon(getClass().getResource("/image/buddy1.jpeg")),
			new ImageIcon(getClass().getResource("/image/buddy2.jpeg")),
			new ImageIcon(getClass().getResource("/image/buddy3.jpeg"))
	};
	public ListEx() {
		super("make the list sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JList<String> strList = new JList<>(text);
		c.add(strList);
		
		JList<ImageIcon> imageList = new JList<>(image);
		imageList.setListData(image);
		c.add(imageList);
		
		JList<String> scrollList = new JList<>(text);
		c.add(new JScrollPane(scrollList));
		
		setSize(800,800);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListEx();
	}

}
