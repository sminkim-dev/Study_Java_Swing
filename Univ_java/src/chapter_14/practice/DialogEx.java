package chapter_14.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogEx extends JFrame{

	private static class MyDialog extends JDialog{
		private JTextField tf = new JTextField(10);
		private JButton okButton = new JButton("ok");
		
		public MyDialog(JFrame frame, String title) {
			super(frame, title);
			setLayout(new FlowLayout());
			add(tf);
			add(okButton);
			setSize(200,100);
			
			okButton.addActionListener(e->{
				setVisible(false);
			});
		}
	}
	private MyDialog dialog;
	
	public DialogEx() {
		super("make the dialog sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("show dialog");
		
		dialog = new MyDialog(this, "Tese Dialog");
		
		btn.addActionListener(e->{
			dialog.setVisible(true);
		});
		getContentPane().add(btn);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DialogEx();
	}

}
