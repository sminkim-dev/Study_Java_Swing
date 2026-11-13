package Midterm_test_answer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class midterm6 extends JFrame{
	
	
	private CenterPanel cp = new CenterPanel();
	private JButton b1,b2,b3;
	private JLabel jl = new JLabel("0");
	
	public midterm6(){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(cp, BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
		
	}
	
	
	class NorthPanel extends JPanel implements ActionListener{
		
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			
			b1 = new JButton("start");
			b2 = new JButton("fin");
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			add(b1);
			add(b2);
			add(jl);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if((JButton)e.getSource() == b1) {
				b3.setVisible(true);
				jl.setText("0");
			}
			else if((JButton)e.getSource() == b2) {
				b3.setVisible(false);
				jl.setText("0");
			}
		}
	}
	
	
	class CenterPanel extends JPanel implements ActionListener{
		
		public CenterPanel() {
			setLayout(null);
			int x = (int)(Math.random() * 200);
			int y = (int)(Math.random() * 200);
			b3 = new JButton("ClickHere");
			b3.setLocation(x,y);
			b3.setVisible(false);
			b3.setSize(100,20);
			add(b3);
			b3.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int x = (int)(Math.random() * 200);
			int y = (int)(Math.random() * 200);
			b3.setLocation(x,y);
			b3.setSize(100,20);
			jl.setText((Integer.parseInt(jl.getText()) + 1) + "");
			revalidate();
			repaint();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new midterm6();
	}

}
