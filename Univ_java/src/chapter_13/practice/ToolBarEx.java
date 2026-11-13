package chapter_13.practice;

import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame{
	private Container contentPane;
	
	public ToolBarEx() {
		super("make the Tool Bar sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		pack();
		//setSize(400,200);
		setVisible(true);
	}
	private void createToolBar() {
		JToolBar toolbar = new JToolBar("Kitae Menu");
		toolbar.setBackground(Color.LIGHT_GRAY);
		
		toolbar.add(new JButton("new"));
		toolbar.add(new JButton(new ImageIcon(getClass().getResource("/image/buddy2.jpeg"))));
		toolbar.addSeparator();
		toolbar.add(new JButton(new ImageIcon(getClass().getResource("/image/buddy3.jpeg"))));
		toolbar.add(new JLabel("search"));
		toolbar.add(new JTextField("text field"));
		
		JComboBox<String>combo = new JComboBox<String>();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolbar.add(combo);
		
		contentPane.add(toolbar, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ToolBarEx();
	}

}
