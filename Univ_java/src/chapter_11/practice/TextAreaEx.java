package chapter_11.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaEx extends JFrame{
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7,20);
	
	public TextAreaEx() {
		super("make the TextArea sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("입력 후 <enter> 키를 입력하세요 "));
		c.add(tf);
		c.add(new JScrollPane(ta));
		
//		tf.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JTextField t = (JTextField)e.getSource();
//				ta.append(t.getText() + "\n");
//				
//				t.setText("");
//			}
//		});
		// 추상클래스 메소드가 1개인 경우는 람다식을 이용할 수 있음. actionListener 외에도 ItemListen 또한 메소드가 하나라 람다식 가능.
		tf.addActionListener(e->{
			ta.append(tf.getText() + "\n");
			
			tf.setText("");
		});
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextAreaEx();
	}

}
