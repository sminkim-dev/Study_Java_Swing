package chapter_14.practice;

import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame{
	
	private Container contentPane;
	
	public ToolBarEx() {
		super("make the tooll bar sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		createToolBar();
		setSize(400,300);
		setVisible(true);
	}
	
	private void createToolBar() {
		
		JToolBar toolBar = new JToolBar("Kitae MEnu");
		toolBar.setBackground(Color.GRAY);
		
		// insert using component to tool bar for the menu
		toolBar.add(new JButton("new"));
		toolBar.add(new JButton(new ImageIcon(getClass().getResource("/image/buddy1.jpeg"))));
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon(getClass().getResource("/image/buddy2.jpeg"))));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		
		JComboBox<String> combo = new JComboBox<>();
		combo.addItem("JAVA");
		combo.addItem("C");
		combo.addItem("C#");
		combo.addItem("C++");
		toolBar.add(combo);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		new ToolBarEx();
	}

}
