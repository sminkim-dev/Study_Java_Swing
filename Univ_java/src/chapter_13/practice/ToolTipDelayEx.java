package chapter_13.practice;

import javax.swing.*;
import java.awt.*;

public class ToolTipDelayEx extends JFrame{
	public ToolTipDelayEx() {
		super("툴팁 지연 시간 제어 예제 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel buddy_Label1 = new JLabel(new ImageIcon(getClass().getResource("/image/buddy1.jpeg")));
		buddy_Label1.setToolTipText("you think how looking buddy1 image");
		
		JLabel buddy_Label2 = new JLabel(new ImageIcon(getClass().getResource("/image/buddy2.jpeg")));
		buddy_Label2.setToolTipText("you think how looking buddy2 image");
		
		c.add(buddy_Label1);
		c.add(buddy_Label2);
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0); // 초기 툴집 지연 시간을 0초로 설정 
		m.setDismissDelay(10000); // 툴집 지속 시간을 10초로 설정
		
		setSize(400,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ToolTipDelayEx();
	}

}
