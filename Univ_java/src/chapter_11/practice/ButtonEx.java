package chapter_11.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEx extends JFrame{
	public ButtonEx() {
		super("img button sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon(getClass().getResource("/image/buddy1.jpeg"));
		ImageIcon rolloverIcon = new ImageIcon(getClass().getResource("/image/buddy2.jpeg"));
		ImageIcon pressedIcon = new ImageIcon(getClass().getResource("/image/buddy3.jpeg"));
		
		JButton btn = new JButton("Click~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		c.add(btn);
		setSize(600,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonEx();
	}

}
