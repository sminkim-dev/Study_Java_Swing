package Midterm_test_answer;

import java.io.*;
import java.util.*;

public class midterm3 {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("<USER_HOME>/Dev/words.txt"); // 실습 환경이 mac os라서 경로 지정 방식이 다름..
			in = new InputStreamReader(fin, "UTF-8");
			
			String input = "";
			int line_cnt = 0;
			int c;
			
			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while((c = in.read()) != -1) {
				char t = (char)c;
				input += (char)c;
				if(t == '\n')line_cnt++;
			}
			in.close();
			fin.close();
			
			System.out.println("line : " + line_cnt);
			
			StringTokenizer st = new StringTokenizer(input);
			System.out.println("word : " + st.countTokens());
		}
		catch(IOException e) {
			System.out.println("error");
		}

	}

}
