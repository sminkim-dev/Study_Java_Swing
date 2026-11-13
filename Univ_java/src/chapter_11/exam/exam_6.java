package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_6 extends JFrame{
	private JTextArea ta = new JTextArea(5,30);
	private int cnt = 0;
	private JSlider sl = new JSlider(0,100,0);
	
	public exam_6() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new FlowLayout());
		ta.addKeyListener(new MyKeyListener());
		north.add(ta);
		ta.setFocusable(true);
		ta.requestFocus();
		
		c.add(north, BorderLayout.NORTH);
		
		JPanel south = new JPanel(new FlowLayout());
		
		sl.setPaintLabels(true);
		sl.setPaintTicks(true);
		sl.setPaintTrack(true);
		sl.setMajorTickSpacing(20);
		sl.setMinorTickSpacing(5);
		sl.addChangeListener(e->{
			int val = sl.getValue();

		    if(val < cnt) {
		        String text = ta.getText();
		        ta.setText(text.substring(0, val));
		    }

		    cnt = val;
		});
		south.add(sl);
		
		c.add(south, BorderLayout.SOUTH);
		setSize(500,500);
		setVisible(true);
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			if(keyCode == KeyEvent.VK_BACK_SPACE) {
				cnt--;
				JTextArea t = (JTextArea)e.getSource();
				String text = t.getText();
				ta.setText(text.substring(0, cnt));
				sl.setValue(cnt);
			}
			else {
				if(cnt < 100) {
					cnt++;
					sl.setValue(cnt);
				}
				else {
					JTextArea t = (JTextArea)e.getSource();
					String text = t.getText();
					ta.setText(text.substring(0, cnt));
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_6();
	}

}
