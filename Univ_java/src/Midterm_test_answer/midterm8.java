package Midterm_test_answer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class midterm8 extends JFrame implements ActionListener{
	
	private JRadioButton [][] q = new JRadioButton[3][4];
	private JButton reset = new JButton("Reset");
	private JButton submit = new JButton("Submit");
	public midterm8() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(7,1));
		
		for(int i = 0; i < 3; i++) {
			ButtonGroup g = new ButtonGroup();
			c.add(new JLabel("질문 " + (i + 1) + "번 "));
			JPanel a = new JPanel();
			
			for(int j = 0; j < 4; j++) {
				q[i][j] = new JRadioButton("answer"+j);
				a.add(q[i][j]);
				//g.add(q[i][j]);
			}
			c.add(a);
		}
		
		JPanel aa = new JPanel();
		aa.add(submit);
		aa.add(reset);
		
		submit.addActionListener(this);
		reset.addActionListener(this);
		c.add(aa);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == submit) {
			String ret = "";
			for(int i = 0; i < 3; i++) {
				int cnt = 0;
				
				for(int j = 0; j < 4; j++) {
					if(q[i][j].isSelected()) {
						cnt++;
						ret += (i + 1) + "번 질문 응답 : " + j + "\n";
					}
				}
				
				if(cnt == 0) {
					ret += (i + 1) + "번 응답 없음 \n";
				}
			}
			JOptionPane.showMessageDialog(null, ret , "Message", JOptionPane.PLAIN_MESSAGE);
		}
		else if(btn == reset) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 4; j++) {
					q[i][j].setSelected(false);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new midterm8();
	}

}
