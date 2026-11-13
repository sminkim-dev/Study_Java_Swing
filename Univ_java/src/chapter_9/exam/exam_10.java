package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_10 extends JFrame{
	public exam_10() {
		super("West Grid");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(10,1));
		
		for(int i = 0; i < 10; i++) {
			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);
			
			JButton btn = new JButton();
			btn.setOpaque(true);
			btn.setBackground(new Color(r,g,b));
			
			west.add(btn);
		}
		
		JPanel east = new JPanel();
		east.setLayout(null);
		
		for(int i = 0; i < 10; i++) {
			JLabel l = new JLabel(Integer.toString(i));
			l.setOpaque(true);
			l.setForeground(Color.RED);
			
			int x = (int)(Math.random()*150 + 50);
			int y = (int)(Math.random()*150 + 50);
			
			l.setBounds(x,y,10,10);
			east.add(l);
		}
		
		c.add(east, BorderLayout.CENTER);
		c.add(west, BorderLayout.WEST);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_10();
	}

}
