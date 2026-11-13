package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymousClassListener extends JFrame{
	public AnonymousClassListener() {
		setTitle("write Aciton event listener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action")) {
					b.setText("액션 ");
				}
				else {
					b.setText("Action");
				}
				AnonymousClassListener.this.setTitle(b.getText());
			}
		});
		c.add(btn);
		setSize(350,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AnonymousClassListener();
	}

}
