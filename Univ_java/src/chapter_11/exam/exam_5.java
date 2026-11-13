package chapter_11.exam;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class exam_5 extends JFrame{
	private JLabel la = new JLabel("150");
	public exam_5() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JSlider sl = new JSlider(100,200,150);
		sl.setMajorTickSpacing(20);
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		sl.setPaintTrack(true);
		
		sl.addChangeListener(e -> {
			int loc = sl.getValue();
			
			la.setText(Integer.toString(loc));
			la.setBackground(new Color(0,loc, 0));
		});
		la.setOpaque(true);
		la.setBackground(new Color(0,150,0));
		
		c.add(sl);
		c.add(la);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        UIManager.setLookAndFeel(
	            "javax.swing.plaf.metal.MetalLookAndFeel"
	        );
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    new exam_5();
	}

}
