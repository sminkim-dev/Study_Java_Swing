package chapter_10.practice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IndepClassListener extends JFrame{
	public IndepClassListener() {
		super("Action event Listener sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Aciton");
		btn.addActionListener(new MyActionListener()); // action event listenr 달기 
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IndepClassListener();
	}

}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); // event source button 알애내
		if(b.getText().equals("Action")) {
			b.setText("액션 ");
		}
		else {
			b.setText("Action");
		}
	}
}
