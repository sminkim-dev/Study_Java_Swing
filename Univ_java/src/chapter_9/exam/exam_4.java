package chapter_9.exam;
import javax.swing.*;
import java.awt.*;
public class exam_4 extends JFrame{
	public exam_4() {
		super("배경색을 가진 10개의 버튼 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));
		Color [] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.DARK_GRAY
				, Color.GRAY, Color.CYAN, Color.MAGENTA};
		
		for (int i = 0; i < 10; i++) {
		    JButton b = new JButton(Integer.toString(i));
		    b.setOpaque(true);
		    b.setBackground(color[i]);
		    c.add(b);
		}
		setSize(500,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// mac os 에서는 swing 색상이 제대로 표현안될 수 있음. 때문에 코드를 수정하면 기존 의도대로 색을 칠해주긴 함.
//		try {
//	        UIManager.setLookAndFeel(
//	            UIManager.getCrossPlatformLookAndFeelClassName()
//	        );
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
		new exam_4();
	}

}
