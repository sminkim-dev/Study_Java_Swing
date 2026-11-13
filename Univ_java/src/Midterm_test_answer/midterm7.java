package Midterm_test_answer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class midterm7 extends JFrame implements ActionListener{
	
	private JTextField name , id;
	private JRadioButton gender1, gender2;
	private JCheckBox [] interest;
	private JComboBox grade;
	private JButton submit;
	
	public midterm7() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(7,2);
		grid.setVgap(5);
		
		name = new JTextField();
		id = new JTextField();
		ButtonGroup g = new ButtonGroup();
		gender1 = new JRadioButton("남성 ");
		gender2 = new JRadioButton("여성 ", true);
		
		g.add(gender1);
		g.add(gender2);
		
		interest = new JCheckBox[3];
		for(int i = 0; i < 3; i++) {
			interest[i] = new JCheckBox("흥미 " + i);
		}
		
		grade = new JComboBox<String>();
		for(int i = 1; i <= 4; i++) {
			grade.addItem(i + " 학년 ");
		}
		submit = new JButton("제출 ");
		
		JPanel jj1 = new JPanel();
		jj1.add(gender1);
		jj1.add(gender2);
		
		JPanel jj2 = new JPanel();
		jj2.add(interest[0]);
		jj2.add(interest[1]);
		jj2.add(interest[2]);
		Container c = getContentPane();
		c.setLayout(grid);
		
		c.add(new JLabel("이름 : "));
		c.add(name);
		c.add(new JLabel("학번 : "));
		c.add(id);
		c.add(new JLabel("성별 : "));
		c.add(jj1);
		c.add(new JLabel("흥미 : "));
		c.add(jj2);
		c.add(new JLabel("학년 : "));
		c.add(grade);
		
		c.add(submit);
		submit.addActionListener(this);
		//setSize(300,200);
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Container c = new Container();
		String str = "";
		str += "이름 : " + name.getText() + "\n";
		str += "학번 : " + id.getText() + "\n";
		if(gender1.isSelected()) str += "성별 : 남성 " + "\n";
		else str += "성별 : 여성 " + "\n";
		
		str += "흥미 : ";
		if(interest[0].isSelected()) str += "흥미1 \n";
		if(interest[1].isSelected()) str += "흥미2 \n";
		if(interest[2].isSelected()) str += "흥미3 \n";
		
		str += "학년 : " + (grade.getSelectedIndex() + 1) + "\n";
		
		getContentPane().removeAll();
		System.out.println(str);
		JTextArea a = new JTextArea(7, 20);
		a.append(str);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(a);
		
		revalidate();
		repaint();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new midterm7();
	}

}
