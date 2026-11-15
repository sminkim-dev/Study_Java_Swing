package chapter_14.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabbedPaneEx extends JFrame{

	public TabbedPaneEx() {
		super("example make the tabbed pane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane();
		c.add(pane, BorderLayout.CENTER);
		setSize(250,200);
		setVisible(true);
	}
	
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("tab1", new JLabel(new ImageIcon(getClass().getResource("/image/buddy1.jpeg"))));
		pane.addTab("tab2", new JLabel(new ImageIcon(getClass().getResource("/image/buddy2.jpeg"))));
		pane.addTab("tab3", new MyPanel());
		return pane;
	}
	
	class MyPanel extends JPanel{
		
		public MyPanel() {
			this.setBackground(Color.YELLOW);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.BLACK);
			g.drawString("tab 3에 들어가는 JPanel 입니다 ", 30, 50);
		}
	}
	public static void main(String[] args) {
		new TabbedPaneEx();
	}

}
