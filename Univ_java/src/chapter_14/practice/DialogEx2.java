package chapter_14.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogEx2 extends JFrame{

	public static class MyModalDialog extends JDialog{
		private JTextField tf = new JTextField(10);
		private JButton okbutton = new JButton("OK");
		
		public MyModalDialog(JFrame frame, String title) {
			super(frame, title, true);
			setLayout(new FlowLayout());
			add(tf);
			add(okbutton);
			setSize(200,100);
			
			okbutton.addActionListener(e->{
				setVisible(false);
			});
		}
		
		public String getInput() {
			if(tf.getText().length() == 0) return null;
			else return tf.getText();
		}
	}
	
	private MyModalDialog dialog;
	
	public DialogEx2() {
		super("DialogEx2 example frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Modal Dialog");
		
		// create modal dialog
		dialog = new MyModalDialog(this, "Test Modal Dialog");
		
		btn.addActionListener(e->{
			dialog.setVisible(true);
			String text = dialog.getInput();
			
			if(text == null) return;
			btn.setText(text);
		});
		getContentPane().add(btn);
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DialogEx2();
	}

}
