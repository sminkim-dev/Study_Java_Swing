package prof.finalterm;

import java.util.*;

public class exam_8 {
	
	//private static Scanner sc = new Scanner(System.in);
	private double num[];
	public String exp = "";
	
	public exam_8(String exp) {
		this.exp = exp.replaceAll("\\s+", "");
		StringTokenizer st = new StringTokenizer(this.exp, "()+-*/");
		
		int count = st.countTokens();
		
		num = new double[count];
		for(int i = 0; i < count; i++) {
			num[i] = Double.parseDouble(st.nextToken());
		}
	}
	
	public String transform() {
		String result = "";
		Stack<String> stack = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) == '(') stack.push("(");
			else if(exp.charAt(i) == ')') {
				String t;
				do {
					
					t = stack.pop();
					if(!t.equals("("))result += t + " ";
					
				}
				while(!t.equals("("));
			}
			else if(exp.charAt(i) == '*' || exp.charAt(i) == '/') {
				while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
					result += stack.pop() + " ";
				}
				stack.push(exp.charAt(i) + "");
			}
			else if(exp.charAt(i) == '+' || exp.charAt(i) == '-') {
				while(!stack.isEmpty() && !stack.peek().equals("(")) {
					result += stack.pop() + " ";
				}
				stack.push(exp.charAt(i) + "");
			}
			else if ((exp.charAt(i) >= '0' && exp.charAt(i) <= '9') || exp.charAt(i) == '.') {
				// 여러 자리 숫자와 소수는 하나로 묶고, 끝에 공백을 넣는다.
				result += exp.charAt(i);
				while (i + 1 < exp.length()
						&& ((exp.charAt(i + 1) >= '0' && exp.charAt(i + 1) <= '9')
								|| exp.charAt(i + 1) == '.')) {
					i++;
					result += exp.charAt(i);
				}
				result += " ";
			}
			
		}
		while(!stack.isEmpty()) {
			result += stack.pop() + " ";
		}
		return result.trim();
	}
	
	public double compute(String exp) {
		
		//String value = exp;
		String postfix = transform(); // 원래 식 대신 후위 표기식을 계산한다.
		int j = 0;
		Stack<Double> s = new Stack<>();
		for(int i = 0; i < postfix.length(); i++) {
			if(postfix.charAt(i) == '+') {
				double n1 = s.pop();
				double n2 = s.pop();
				s.push(n2 + n1);
			}
			else if(postfix.charAt(i) == '-') {
				double n1 = s.pop();
				double n2 = s.pop();
				s.push(n2 - n1);
			}
			else if(postfix.charAt(i) == '*') {
				double n1 = s.pop();
				double n2 = s.pop();
				s.push(n2 * n1);
			}
			else if(postfix.charAt(i) == '/') {
				double n1 = s.pop();
				double n2 = s.pop();
				if(n1 == 0.0) {
					System.out.println("0으로 나눌 수 없음.");
					System.exit(0);
				}
				s.push(n2 / n1);
			}
			else if ((postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9')
					|| postfix.charAt(i) == '.') {
				// 후위 변환은 피연산자의 순서를 유지하므로 num을 순서대로 사용한다.
				s.push(num[j++]); // 숫자 하나당 한 번만 증가
				while (i + 1 < postfix.length()
						&& ((postfix.charAt(i + 1) >= '0' && postfix.charAt(i + 1) <= '9')
								|| postfix.charAt(i + 1) == '.')) {
					i++;
				}
				// 다음 공백/연산자로의 이동은 바깥 for문의 i++가 담당한다.
			}
		}
		
		return s.pop();
	}
	public static void main(String[] args) {		
		exam_8 e = new exam_8("(10.10+2.0)*5");
		String exp = e.transform();
		System.out.println(exp);
		//System.out.print("Line : ");
		
		//String line = sc.nextLine();
		System.out.println(e.compute(exp));
	}

}
