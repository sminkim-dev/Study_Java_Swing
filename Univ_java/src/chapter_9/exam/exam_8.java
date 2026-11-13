package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_8 extends JFrame{
	public exam_8() {
		super("16장의 카드 뒷면 숨겨진 이미지 찾기 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setOpaque(true);
		north.setBackground(Color.YELLOW);
		north.setLayout(new FlowLayout());
		JLabel la1 = new JLabel("숨겨진 이미지 찾기 ");
		north.add(la1);
		
		JPanel south = new JPanel();
		south.setOpaque(true);
		south.setBackground(Color.YELLOW);
		south.setLayout(new FlowLayout());
		JButton b = new JButton("실행 시작 ");
		south.add(b);
		
		JLabel west = new JLabel("                             ");
		
		JLabel east = new JLabel("                             ");
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,4,10,10));
		
		for(int i = 0; i < 16; i++) {
			JLabel l = new JLabel(Integer.toString(i));
			l.setOpaque(true);
			l.setBackground(Color.GREEN);
			center.add(l);
		}
		
		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(east, BorderLayout.EAST);
		c.add(west, BorderLayout.WEST);
		c.add(south, BorderLayout.SOUTH);
		
		setSize(400,400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_8();
	}

}
