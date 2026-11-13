package chapter_11.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SliderEx extends JFrame{
	public SliderEx() {
		super("make the slider sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100); // range 0 ~ 200 , 현재 선택된 값 100
		slider.setPaintLabels(true); // 슬라이더 라벨을 보이게 
		slider.setPaintTicks(true); // 눈금을 보이게 
		slider.setPaintTrack(true); // 트랙을 보이게 
		slider.setMajorTickSpacing(50); // 큰 눈금 간격 
		slider.setMinorTickSpacing(10); // 작은 눈 간격 
		c.add(slider);
		
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SliderEx();
	}

}
