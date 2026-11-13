package chapter_9.practice;
import javax.swing.*;
import java.awt.*;
public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("ContentPane and JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // frame window를 닫으면 프로그램을 종료하도록 설정
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300,150);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContentPaneEx pane = new ContentPaneEx();
	}

}
