package chapter_13.practice;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogEx extends JFrame{
	static class MyDialog extends JDialog{
		private JTextField tf = new JTextField(10);
		private JButton okButton = new JButton("OK");
		
		public MyDialog(JFrame frame, String title) {
			super(frame, title);
			setLayout(new FlowLayout());
			add(tf);
			add(okButton);
			setSize(200,100);
			
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
		}
	}
	private MyDialog dialog;
	
	public DialogEx() {
		super("example frame the dialogEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Dialog");
		
		// create dialog
		dialog = new MyDialog(this, "Test Dialog");
		
		// if clicking the show dialog button, working the dialog
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btn);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DialogEx();
	}

}
