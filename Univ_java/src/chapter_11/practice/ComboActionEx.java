package chapter_11.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboActionEx extends JFrame{
	private String [] items = {"buddy1", "buddy2", "buddy3"};
	private ImageIcon [] image = {
			new ImageIcon(getClass().getResource("/image/buddy1.jpeg")),
			new ImageIcon(getClass().getResource("/image/buddy2.jpeg")),
			new ImageIcon(getClass().getResource("/image/buddy3.jpeg"))
	};
	
	private JLabel imageLabel = new JLabel(image[0]);
	private JComboBox <String> strCombo = new JComboBox<>(items);
	
	public ComboActionEx() {
		super("make the ComboBox Action Listener sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		c.add(strCombo);
		c.add(imageLabel);
		
		strCombo.addActionListener(e->{
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
			int index = cb.getSelectedIndex();
			imageLabel.setIcon(image[index]);
		});
		//strCombo.setSelectedIndex(2);
		setSize(1000,1000);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboActionEx();
	}

}
