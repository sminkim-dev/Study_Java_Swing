package chapter_8.exam;

import java.io.*;

public class exam_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("<USER_HOME>/Dev/Java/test.txt");
		FileReader fr = null;
		
		try {
			fr = new FileReader(src);
			int c;
			System.out.println(src.getPath() + "를 출력 ");
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			fr.close();
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
