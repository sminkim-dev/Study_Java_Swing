package chapter_8.exam;

import java.io.*;

public class exam_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File first = new File("<USER_HOME>/Dev/Java/system.ini");
		//File second = new File("<USER_HOME>/Dev/Java/test.txt");
		File second = new File("<USER_HOME>/Dev/Java/system.ini");
		
		try(FileInputStream fi1 = new FileInputStream(first);
				FileInputStream fi2 = new FileInputStream(second)){
			boolean is_same = true;
			while(true) {
				int b1 = fi1.read();
				int b2 = fi2.read();
				if(b1 != b2) {
					is_same = false;
					break;
				}
				if(b1 == -1 || b2 == -1) {
					break;
				}
			}
			if(is_same) {
				System.out.println("File is same");
			}
			else System.out.println("File isn't same");
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
