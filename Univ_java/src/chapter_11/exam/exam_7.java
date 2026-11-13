package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_7 extends JFrame{
	private JLabel la = new JLabel("Love Java");
	private JLabel num = new JLabel("50");
	private int size = 50;
	public exam_7() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JSlider sl = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		sl.setPaintTrack(true);
		sl.setMajorTickSpacing(20);
		sl.setMinorTickSpacing(5);
		
		sl.addChangeListener(e-> {
			size = sl.getValue();
			
			la.setFont(la.getFont().deriveFont((float)size));
			num.setText(Integer.toString(size));
		});
		
		c.add(num);
		c.add(sl);
		la.setFont(la.getFont().deriveFont((50f)));
		c.add(la);
		
		setSize(200,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_7();
	}

}
