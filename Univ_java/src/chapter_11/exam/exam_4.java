package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_4 extends JFrame{
	private JTextField tf = new JTextField(10);
	private JLabel [] la = new JLabel[8];
	private String [] names = {"5만원 ", "만원 ", "천원 ", "500원 ", "100원 ", "50원 ", "10원 ", "1원 "};
	private int [] money = {50000,10000,1000,500,100,50,10,1};
	private JCheckBox [] ckb = new JCheckBox[7];
	private int price;
	private boolean [] check = new boolean [7];
	
	public exam_4() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new FlowLayout(FlowLayout.CENTER));
		north.setBackground(Color.YELLOW);
		north.add(new JLabel("금액 "));
		north.add(tf);
		
		JButton btn = new JButton("cal ");
		
		btn.addActionListener(e-> {
			price = Integer.parseInt(tf.getText());
			
			for(int i = 0; i < names.length; i++) {
				if(i < 7 && !check[i]) {
					la[i].setText("0");
					
					continue;
				}
				else {
					int cnt = price / money[i];
					price = price % money[i];
					
					la[i].setText(Integer.toString(cnt));
				}
			}
		});
		north.add(btn);
		
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
		wrapper.setBackground(Color.YELLOW);
		
		JPanel grid = new JPanel(new GridLayout(8,2,3,3));
		grid.setBackground(Color.YELLOW);
		grid.setPreferredSize(new Dimension(300,300));
		
		for(int i = 0; i < names.length; i++) {
			grid.add(new JLabel(names[i], SwingConstants.RIGHT));
			la[i] = new JLabel("0", SwingConstants.CENTER);
			la[i].setOpaque(true);
			la[i].setBackground(Color.WHITE);
			
			grid.add(la[i]);
			
			if(i < 7) {
				final int index = i;
				ckb[i] = new JCheckBox();
				ckb[index].addItemListener(e->{
					if(ckb[index].isSelected()) {
						check[index] = true;
					}
					else {
						check[index] = false;
					}
				});
				grid.add(ckb[index]);
			}
		}
		wrapper.add(grid);
		c.add(wrapper, BorderLayout.CENTER);
		c.add(north, BorderLayout.NORTH);
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_4();
	}

}
