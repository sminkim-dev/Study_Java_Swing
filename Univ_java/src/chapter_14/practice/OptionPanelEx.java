package chapter_14.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionPanelEx extends JFrame{
	
	public OptionPanelEx() {
		super("example option panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setSize(500,200);
		c.add(new MyPanel(), BorderLayout.NORTH);
		setVisible(true);
	}
	
	class MyPanel extends Panel{
		private JButton inputBtn = new JButton("Input Name");
		private JTextField tf = new JTextField(10);
		private JButton confirmBtn = new JButton("Confirm");
		private JButton messageBtn = new JButton("Mesaage");
		
		public MyPanel() {
			setBackground(Color.LIGHT_GRAY);
			add(inputBtn);
			add(confirmBtn);
			add(messageBtn);
			add(tf);
			
			inputBtn.addActionListener(e->{
				String name = JOptionPane.showInputDialog(this, "이름을 입력하세요 ", "Input", JOptionPane.YES_NO_OPTION);
				if(name != null) {
					tf.setText(name);
				}
			});
			confirmBtn.addActionListener(e->{
				int result = JOptionPane.showConfirmDialog(OptionPanelEx.this, "계속할 것입니까? ", "Confirm", 
						JOptionPane.YES_NO_CANCEL_OPTION);
				
				// 사용자가 선택한 버튼에 따라 문자열을 텍스트 필드 창에 출력
				if(result == JOptionPane.CLOSED_OPTION) {
					tf.setText("Just Closed without Selection");
				}
				else if(result == JOptionPane.YES_OPTION) {
					tf.setText("Yes");
				}
				else if(result == JOptionPane.NO_OPTION) {
					tf.setText("No");
				}
				else if(result == JOptionPane.CANCEL_OPTION) {
					tf.setText("Cancel");
				}
			});
			messageBtn.addActionListener(e->{
				JOptionPane.showMessageDialog(this,  "조심하세요 ", "Message", JOptionPane.ERROR_MESSAGE);
			});
		}
	}
	public static void main(String[] args) {
		new OptionPanelEx();
	}

}
