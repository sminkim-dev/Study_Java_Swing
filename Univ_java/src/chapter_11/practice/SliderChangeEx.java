package chapter_11.practice;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class SliderChangeEx extends JFrame{
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider [3];
	public SliderChangeEx() {
		super("slider and changeEvent sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		colorLabel = new JLabel("          SLider Example          ");
		
		// create three slider and control shape
		for(int i = 0; i < sl.length; i ++) {
			// 0 ~ 255 사이의 값을 선택할 수 있는 슬라이더 초기값은 128 
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			sl[i].addChangeListener(new MyChangeListener());
			c.add(sl[i]);
		}
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r,g,b));
		
		c.add(colorLabel);
		setSize(300,230);
		setVisible(true);
	}
	class MyChangeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r,g,b));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderChangeEx();
	}

}
