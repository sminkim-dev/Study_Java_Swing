package chapter_13.practice;

import javax.swing.*;
import java.awt.*;

public class ToolTipEx extends JFrame{
	private Container contentPane;
	
	public ToolTipEx() {
		super("example ToolTip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400,200);
		setVisible(true);
	}
	private void createToolBar() {
		JToolBar bar = new JToolBar("Kitae Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		
		JButton newBtn = new JButton("new");
		newBtn.setToolTipText("파일을 생성합니다. ");
		bar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon(getClass().getResource("/image/buddy1.jpeg")));
		openBtn.setToolTipText("파일을 엽니다. ");
		bar.add(openBtn);
		bar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon(getClass().getResource("/image/buddy3.jpeg")));
		saveBtn.setToolTipText("파일을 저장합니다. ");
		bar.add(saveBtn);
		bar.add(new JLabel("search"));
		
		JTextField tf = new JTextField("text field");
		tf.setToolTipText("찾고자 하는 문자열을 입력하세요. ");
		bar.add(tf);
		contentPane.add(bar, BorderLayout.NORTH);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ToolTipEx();
	}

}
