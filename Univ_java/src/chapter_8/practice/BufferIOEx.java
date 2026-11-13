package chapter_8.practice;

import java.io.*;
import java.util.*;

public class BufferIOEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("<USER_HOME>/Dev/Java/test.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5); // <- 바이트 단위로 출력하므로 ANSI코드의 영문만 출력 가능. 따라서 한글은 수정해야함.
			//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 5); <-- 한글 출력용 <-- 추가 '5' 는 버퍼 수임. 
			while((c = fin.read()) != -1) {
				out.write(c);
			}
			// file data가 모두 출력된 상태 
			new Scanner(System.in).nextLine(); // 엔터 키 입력 
			out.flush(); // 버퍼에 남아 있던 문자 모두 출력 
			fin.close();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
