package chapter_14.practice;

import javax.swing.*;
import java.awt.*;

public class ToolTipEx extends JFrame{
	
	private Container contentPane;
	
	public ToolTipEx() {
		super("make the tooltip smaple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		createToolTip();
		setSize(500,500);
		setVisible(true);
	}
	
	private void createToolTip() {
		JToolBar bar = new JToolBar("kitae menu");
		bar.setBackground(Color.LIGHT_GRAY);
		
		JButton newBtn = new JButton("new");
		newBtn.setToolTipText("create the file");
		bar.add(newBtn);
		
		JButton openBtn = new JButton("open");
		openBtn.setToolTipText("open the file");
		bar.add(openBtn);
		
		bar.addSeparator();
		
		JButton saveBtn = new JButton("save");
		saveBtn.setToolTipText("save the file");
		bar.add(saveBtn);
		
		JTextField tf = new JTextField("text field");
		tf.setToolTipText("want to find the line");
		bar.add(tf);
		
		contentPane.add(bar, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new ToolTipEx();
	}

}
