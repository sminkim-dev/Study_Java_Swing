package prof.finalterm;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class exam_10 extends JFrame{
	private JTextField tf = new JTextField(10);
	private JTextField re = new JTextField(10);
	private String line = "";
	
	private String [] text = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "←",".", "+", "-", "x", "/", "(", ")"};
	private JButton [] r_btn = new JButton[text.length];
	
	private void cal() {
		line = tf.getText(); // 키보드로 직접 입력한 수식도 반영한다.
		if(line.trim().isEmpty()) {
			re.setText("");
			return;
		}

		try {
			String postfix = transform(line); // 중위 표기식 → 후위 표기식
			tf.setText(postfix); // 입력창에 변환된 후위 표기식을 표시한다.
			double result = compute(postfix); // 후위 표기식 계산
			re.setText(String.valueOf(result));
		}
		catch(ArithmeticException e) {
			re.setText("0으로 나눌 수 없음");
		}
		catch(IllegalArgumentException e) {
			re.setText("잘못된 수식 또는 괄호");
		}
	}

	// 연산 우선순위: 곱셈·나눗셈을 덧셈·뺄셈보다 먼저 처리한다.
	private static int priority(char operator) {
		if(operator == '*' || operator == '/') return 2;
		if(operator == '+' || operator == '-') return 1;
		return 0;
	}

	private static String transform(String exp) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		boolean needNumber = true;

		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if(Character.isWhitespace(ch)) continue;

			if((ch >= '0' && ch <= '9') || ch == '.') {
				if(!needNumber) throw new IllegalArgumentException();
				String number = "";
				do {
					number += exp.charAt(i++);
				} while(i < exp.length()
						&& ((exp.charAt(i) >= '0' && exp.charAt(i) <= '9')
								|| exp.charAt(i) == '.'));
				i--; // 바깥 for문의 i++가 다음 문자로 이동한다.
				Double.parseDouble(number); // 잘못된 소수 입력을 확인한다.
				result += number + " "; // 여러 자리 숫자를 공백으로 구분한다.
				needNumber = false;
			}
			else if(ch == '(') {
				if(!needNumber) throw new IllegalArgumentException();
				stack.push(ch);
			}
			else if(ch == ')') {
				if(needNumber) throw new IllegalArgumentException();
				while(!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop() + " ";
				}
				if(stack.isEmpty()) throw new IllegalArgumentException();
				stack.pop(); // 여는 괄호는 결과에 넣지 않는다.
			}
			else if(ch == '+' || ch == '-' || ch == 'x' || ch == '*' || ch == '/') {
				if(needNumber) throw new IllegalArgumentException();
				if(ch == 'x') ch = '*';
				while(!stack.isEmpty() && stack.peek() != '('
						&& priority(stack.peek()) >= priority(ch)) {
					result += stack.pop() + " ";
				}
				stack.push(ch);
				needNumber = true;
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		if(needNumber) throw new IllegalArgumentException();
		while(!stack.isEmpty()) {
			if(stack.peek() == '(') throw new IllegalArgumentException();
			result += stack.pop() + " ";
		}
		return result.trim();
	}

	private static double compute(String postfix) {
		Stack<Double> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(postfix);

		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("+") || token.equals("-")
					|| token.equals("*") || token.equals("/")) {
				if(stack.size() < 2) throw new IllegalArgumentException();
				double n1 = stack.pop();
				double n2 = stack.pop();
				switch(token) {
				case "+": stack.push(n2 + n1); break;
				case "-": stack.push(n2 - n1); break;
				case "*": stack.push(n2 * n1); break;
				case "/":
					if(n1 == 0) throw new ArithmeticException();
					stack.push(n2 / n1);
					break;
				}
			}
			else {
				stack.push(Double.parseDouble(token));
			}
		}
		if(stack.size() != 1) throw new IllegalArgumentException();
		return stack.pop();
	}

	public exam_10() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new FlowLayout());
		north.setOpaque(true);
		north.setBackground(Color.GRAY);
		north.add(new JLabel("수식 "));
		north.add(tf);
		tf.addActionListener(e -> cal()); // 키보드 Enter로도 계산한다.
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
		JPanel center = new JPanel(new GridLayout(0,4,3,3));
		for(int i = 0; i < text.length; i++) {
			r_btn[i] = new JButton(text[i]);
			r_btn[i].setOpaque(true);
			r_btn[i].setBackground(Color.WHITE);
			
			final int index = i;
			r_btn[i].addActionListener(e->{
				line = tf.getText();
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
		re.setEditable(false);
		south.add(re);
		
		JButton r = new JButton("Enter");
		r.addActionListener(e->{
			cal();
		});
		south.add(r);
		
		c.add(south, BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(exam_10::new);
	}

}