package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_7 extends JFrame{
	public exam_7() {
		super("Java Swing Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		JLabel la1 = new JLabel("수식 ");
		north.add(la1);
		
		JTextField tf = new JTextField(15);
		
		north.add(tf);
		
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,5, 5, 5));
		
		String [] oper = {"C", "UN", "BK", "/", "7", "8", "9", "x", "4", "5", "6", "-",
				"1", "2", "3", "+", "0", ".", "=", "%"};
		
		for(int i = 0; i < 20; i++) {
			JButton b = new JButton(oper[i]);
			center.add(b);
		}
		
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		
		JLabel la2 = new JLabel("계산 결과 ");
		JTextField tf2 = new JTextField(15);
		south.add(la2);
		south.add(tf2);
		
		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_7();
	}

}
