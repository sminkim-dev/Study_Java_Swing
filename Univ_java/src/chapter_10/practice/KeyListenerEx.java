package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerEx extends JFrame{
	private JLabel [] keyMessage; // 3개의 메시지를 출력할 레이블 컴포넌트 배
	public KeyListenerEx() {
		setTitle("KeyListener sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener());
		
		keyMessage = new JLabel [3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		for(int i = 0; i < 3; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setSize(300,150);
		setVisible(true);
		
		// 까먹지 말 것, 컨텐트 팬에 키 입력을 받을 수 있도록 포커스 강제 지
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
			
			System.out.println("keyPressed");
		}
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased");
		}
		public void keyTypeed(KeyEvent e) {
			System.out.println("keyTyped");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyListenerEx();
	}

}
