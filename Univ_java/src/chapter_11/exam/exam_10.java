package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_10 extends JFrame{
	private int count = 0;
	private JLabel [] la = new JLabel[5];
	private String [] text = {"You", "are", "the", "dancing", "queen"};
	private JLabel result = new JLabel(">> ");
	private JPanel center = new JPanel(null);
	private boolean state = false;
	private void logic() {
		if(!state) {
			state = !state;
			for(int i = 0; i < la.length; i++) {
				la[i].setVisible(true);
			}
		}
		else {
			result.setText(">> ");
			for(int i = 0; i < la.length; i++) {
				int x = (int)(Math.random() * 270 + 50);
				int y = (int)(Math.random() * 270 + 50);
				la[i].setForeground(Color.BLACK);
				la[i].setBounds(x, y, 160, 30);
				la[i].setEnabled(true);
			}
		}
		
	}
	
	public exam_10() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		JPanel north = new JPanel(new FlowLayout());
		north.add(new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요."));
		JButton btn = new JButton("new Text");
		btn.addActionListener(e->{
			logic();
		});
		north.add(btn);
		north.setOpaque(true);
		north.setBackground(Color.GRAY);
		c.add(north, BorderLayout.NORTH);
		
		for(int i = 0; i < la.length; i++) {
			int x = (int)(Math.random() * 270 + 10);
			int y = (int)(Math.random() * 270 + 10);
			la[i] = new JLabel(text[i]);
			la[i].setForeground(Color.BLACK);
			la[i].setBounds(x, y, 160, 30);
			la[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JLabel l = (JLabel)e.getSource();
					if(l.isEnabled() == false) {
						return;
					}
					String temp = result.getText() + " " + l.getText();
					l.setForeground(Color.LIGHT_GRAY);
					result.setText(temp);
					count++;
					l.setEnabled(false);
				}
			});
			la[i].setVisible(false);
			center.add(la[i]);
		}
		
		c.add(center , BorderLayout.CENTER);
		
		JPanel south = new JPanel(new FlowLayout());
		south.add(result);
		south.setOpaque(true);
		south.setBackground(Color.YELLOW);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_10();
	}

}
