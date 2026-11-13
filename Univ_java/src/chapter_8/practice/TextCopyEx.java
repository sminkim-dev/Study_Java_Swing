package chapter_8.practice;

import java.io.*;

public class TextCopyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("<USER_HOME>/Dev/Java/test.txt");
		File dest = new File("<USER_HOME>/Dev/Java/copy_test.txt");
		
		int c;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			while((c = fr.read()) != -1) {
				fw.write((char)c);
				
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였음 ");
		}
		catch(IOException e) {
			System.out.println("File Copy error");
		}
	}

}
