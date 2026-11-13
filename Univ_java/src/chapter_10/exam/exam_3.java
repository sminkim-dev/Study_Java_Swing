package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_3 extends JFrame{
	private String temp = "Love Java";
	private JLabel la = new JLabel(temp);
	public exam_3() {
		super("exam_3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		la.addKeyListener(new MyKeyListener());
		c.add(la);
		
		setSize(300,200);
		setVisible(true);
		
		la.setFocusable(true);
		la.requestFocus();
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char [] arr = temp.toCharArray();
			char f_tmp;
			switch(keyCode) {
			case KeyEvent.VK_LEFT:
//				f_tmp = temp.charAt(0);
//				for(int i = 0; i < temp.length() - 1; i++) {
//					arr[i] = arr[i+1];
//				}
//				arr[temp.length() - 1] = f_tmp;
				temp = temp.substring(1) + temp.charAt(0); 
			}
//			temp = "";
//			for(int i = 0; i < arr.length; i++) {
//				temp += arr[i];
//			}
			//temp = new String(arr);
			la.setText(temp);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_3();
	}

}
