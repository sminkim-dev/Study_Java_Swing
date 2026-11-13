package chapter_8.practice;

import java.io.*;
public class FileReaderHangulFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("<USER_HOME>/Dev/Java/test.txt");
			in = new InputStreamReader(fin, "US-ASCII"); // 일부러 틀린 문자 집합 지정 // UTF-8로 작성되서 깨지는 것 확인 완료 
			int c;
			
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
