package chapter_8.practice;

import java.io.*;
public class FileReadHangulSuccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("<USER_HOME>/Dev/Java/test.txt");
			in = new InputStreamReader(fin, "UTF-8"); //책 예제는 MS949인데 일단 Mac OS에서는 깨짐.
			// 인 줄 알았는데 더 알아보니 터미널에서 .txt 파일을 생성할 때 UTF-8로 작성되었기에 MS949로 작성하면 인코딩 방식이 달라 깨지게 됨. 
			int c;
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		}
		catch(IOException e) {
			System.out.print("error");
		}
	}

}
