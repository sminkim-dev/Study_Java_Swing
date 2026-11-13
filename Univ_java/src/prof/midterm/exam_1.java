package prof.midterm;

import java.util.*;
public class exam_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("input : ");
		String line = scanner.nextLine();
		String [] tokens = line.split(" ");
		ArrayList<String> a = new ArrayList<>();
		// 교수님은 hashmap, treeset , set 등의 예시도 같이 보여줌.
		
		
		for(int i = 0; i < tokens.length; i++) {
			boolean isAlready = false;
			for(int j = 0; j < a.size(); j++) {
				if(a.get(j).equals(tokens[i])) {
					isAlready = true;
					break;
				}
			}
			if(isAlready) continue;
			else a.add(tokens[i]);
		}
		System.out.print("result : ");
		for(int i = 0; i < a.size(); i++) {
			System.out.print(i == 0 ? a.get(i) : " " + a.get(i));
		}
		System.out.println();
		scanner.close();
	}

}
