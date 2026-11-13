package chapter_8.practice;

import java.io.*;
public class FileReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fin = null;
		try {
			fin = new FileReader("<USER_HOME>/Downloads/memo-2.txt");
			int c;
			while((c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			fin.close();
		}
		catch (IOException e){
			System.out.println("error");
		}
	}

}
