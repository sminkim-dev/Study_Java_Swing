package chapter_10.exam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_7 extends JFrame{
	private int [] save = new int[5];
	private JButton [] btn = new JButton[5];
	public exam_7() {
		super("exam_7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(1,5,3,3));
		for(int i = 0; i < 5; i++) {
			save[i] = 0;
		}
		for(int i = 0; i < 5; i++) {
			btn[i] = new JButton(Integer.toString(save[i]));
			final int index = i;
			btn[i].addActionListener(e->{
				JButton b = (JButton)e.getSource();
				save[index] += 1;
				b.setText(Integer.toString(save[index]));
			});
			c.add(btn[i]);
		}
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_7();
	}

}
