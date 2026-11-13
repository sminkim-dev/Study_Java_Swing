package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_9 extends JFrame{
	public exam_9() {
		super("랜덤한 별을 가진 프로그램 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setOpaque(true);
		north.setBackground(Color.LIGHT_GRAY);
		north.setLayout(new FlowLayout());
		JLabel la = new JLabel("별 개수 ");
		JTextField tf = new JTextField(8);
		JButton btn = new JButton("별 만들기 ");
		
		north.add(la);
		north.add(tf);
		north.add(btn);
		
		JPanel south = new JPanel();
		south.setOpaque(true);
		south.setBackground(Color.YELLOW);
		JButton btn2 = new JButton("exit ");
		south.add(btn2);
		
		JPanel center = new JPanel();
		center.setLayout(null);
		
		JButton rf = new JButton("Refresh");
		rf.setBounds(10,10,100,30);
		center.add(rf);
		
		for(int i = 0; i < 15; i++) {
			JLabel star = new JLabel("*");
			star.setOpaque(true);
			star.setForeground(Color.RED);
			
			int x = (int)(Math.random()*280);
			int y = (int)(Math.random()*180);
			
			star.setBounds(x,y,10,10);
			center.add(star);
		}
		
		c.add(north, BorderLayout.NORTH);
		c.add(south, BorderLayout.SOUTH);
		c.add(center, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_9();
	}

}
