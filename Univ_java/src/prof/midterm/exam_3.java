package prof.midterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class exam_3 extends JFrame{
	private JTextField tf = new JTextField(10);
	private JTextField re = new JTextField(10);
	private String line = "";
	
	private String [] text = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "←",".", "+", "-", "x", "/"};
	private JButton [] r_btn = new JButton[text.length];
	private double first_value;
	private double second_value;
	
	private void cal() {
		if(tf.getText().length() < 0 || tf.getText() == null) return;
		int opIdx = -1;
		double result = 0;
		
		try {
			char operator = ' ';
			char [] operation = line.toCharArray();
			for(int i = 0; i < line.length(); i++) {
				if(operation[i] == '+' || operation[i] == '-' || operation[i] == 'x' || operation[i] == '/') {
					opIdx = i;
					operator = operation[i];
					break;
				}
			}
			
			first_value = Double.parseDouble(line.substring(0,opIdx));
			second_value = Double.parseDouble(line.substring(opIdx + 1));
			switch(operator) {
			case 'x':
				result = first_value * second_value;
				re.setText(String.valueOf(result));
				break;
			case '/':
				if(second_value == 0) {
					re.setText("0으로 나눌 수 없음 ");
					break;
				}
				result = first_value / second_value;
				re.setText(String.valueOf(result));
				break;
			case '+':
				result = first_value + second_value;
				re.setText(String.valueOf(result));
				break;
			case '-':
				result = first_value - second_value;
				re.setText(String.valueOf(result));
				break;
			}
		}
		catch(NumberFormatException e) {
			re.setText("한 개의 연산만 할 수 있음  ");
		}
		catch(StringIndexOutOfBoundsException e) {
			re.setText("연산자를 넣지 않았음. ");
		}
	}
	
	public exam_3() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new FlowLayout());
		north.setOpaque(true);
		north.setBackground(Color.GRAY);
		north.add(new JLabel("수식 "));
		north.add(tf);
		JButton btn = new JButton("CE");
		btn.addActionListener(e->{
			line = "";
			tf.setText(line);
			re.setText(line);
		});
		north.add(btn);
		c.add(north, BorderLayout.NORTH);
		
		JPanel wrapper = new JPanel(new FlowLayout());
		wrapper.setOpaque(true);
		wrapper.setBackground(Color.LIGHT_GRAY);
		JPanel center = new JPanel(new GridLayout(4,4,3,3));
		for(int i = 0; i < text.length; i++) {
			r_btn[i] = new JButton(text[i]);
			r_btn[i].setOpaque(true);
			r_btn[i].setBackground(Color.WHITE);
			
			final int index = i;
			r_btn[i].addActionListener(e->{
				if(index >= 0 && index <= 9) {
					line += index;
					tf.setText(line);
				}
				else if(index == 10) {
					if(line.length() > 0) {
						line = line.substring(0, line.length() - 1);
						tf.setText(line);
					}
				}
				else {
					line += r_btn[index].getText();
					tf.setText(line);
				}
			});
			center.add(r_btn[i]);
		}
		wrapper.add(center);
		c.add(wrapper, BorderLayout.CENTER);
		
		JPanel south = new JPanel(new FlowLayout());
		south.setOpaque(true);
		south.setBackground(Color.YELLOW);
		south.add(new JLabel("결과 "));
		south.add(re);
		
		JButton r = new JButton("cal");
		r.addActionListener(e->{
			cal();
		});
		south.add(r);
		
		c.add(south, BorderLayout.SOUTH);
		
		setSize(300,260);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_3();
	}

}
