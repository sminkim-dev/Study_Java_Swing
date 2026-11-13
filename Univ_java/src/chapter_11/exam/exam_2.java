package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_2 extends JFrame{
	private JTextField tf = new JTextField(12);
	private JComboBox <String> cb = new JComboBox<>();
	public exam_2() {
		super("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		tf.addActionListener(e->{
			cb.addItem(tf.getText());
			tf.setText("");
		});
		c.add(tf);
		c.add(cb);
		
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_2();
	}

}
