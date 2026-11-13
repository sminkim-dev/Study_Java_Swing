package chapter_11.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ListChangeEx extends JFrame{
	private JTextField tf = new JTextField(20);
	private Vector<String> v = new Vector<String>();
	private JList<String> nameList = new JList<>(v);
	
	public ListChangeEx() {
		super("change list sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름을 입력 후 <enter> 키 "));
		c.add(tf);
		
		v.add("황기태");
		v.add("이재문");
		nameList.setVisibleRowCount(5); // list가 보여주는 행의 수
		nameList.setFixedCellWidth(100); // list의 폭
		c.add(new JScrollPane(nameList));
		
		setSize(300,300);
		setVisible(true);
		
		// jtextfield에 actionlistener 등록, 엔터 키 처리
		tf.addActionListener(e->{
			v.add(tf.getText());
			tf.setText("");
			nameList.setListData(v);
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListChangeEx();
	}

}
