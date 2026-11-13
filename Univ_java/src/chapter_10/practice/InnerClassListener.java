package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame{
	public InnerClassListener() {
		setTitle("Aciton event Listenr sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 아래 코드처럼 내부 클래스가 아닌 익명클래스로 클래스 작성과 인스턴스 생성 동시에 가능. 익명 클래스를 사용하려면 인터페이스 이름을 작성하면 됨 
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action")) {
					b.setText("액션 ");
				}
				else {
					b.setText("Action");
				}
				InnerClassListener.this.setTitle(b.getText());
			}
		});
		c.add(btn);
		
		setSize(350,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InnerClassListener();
	}

//	private class MyActionListener2 implements ActionListener{ // 이 클래스는 내부 클래스로 자신을 둘러싼 외부 클래스인 inner, jframe의 모든 멤버에 접근가능 
//		public void actionPerformed(ActionEvent e) {
//			JButton b = (JButton)e.getSource();
//			if(b.getText().equals("Action")) {
//				b.setText("액션 ");
//			}
//			else {
//				b.setText("Action");
//			}
//			
//			InnerClassListener.this.setTitle(b.getText()); // frame의 title에 버튼 문자열을 출력함.
//		}
//	}
}