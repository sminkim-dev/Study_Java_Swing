package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_1 extends JFrame{
	private JButton btn = new JButton("test button");
	public exam_1() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox b1 = new JCheckBox("버튼 비활성화 ");
//		b1.addActionListener(e->{
//			JCheckBox cb = (JCheckBox)e.getSource();
//			if(cb.isSelected()) {
//				btn.setEnabled(false);
//			}
//			else {
//				btn.setEnabled(true);
//			}
//		});
		b1.addActionListener(e->{
			btn.setEnabled(!b1.isSelected());
		});
		
		c.add(b1);
		
		JCheckBox b2 = new JCheckBox("버튼 감추기 ");
//		b2.addActionListener(e->{
//			if(b2.isSelected()) {
//				btn.setVisible(false);
//			}
//			else {
//				btn.setVisible(true);
//			}
//		});
		b2.addActionListener(e->{
			btn.setVisible(!b2.isSelected()); // 논리 부정 연산자로 if-else 과정 생략 가능. 
		});
		
		c.add(b2);
		c.add(btn);
		
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_1();
	}

}
