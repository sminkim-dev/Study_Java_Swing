package chapter_8.practice;

import java.io.*;
import java.util.*;

public class FileWriterEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("<USER_HOME>/Dev/Java/test.txt");
			while(true) {
				String line = sc.nextLine(); // 빈칸을 포함하여 한 줄 읽기 
				if(line.length() == 0) { //한줄에 enter 키만 입력한 경
					break;
				}
				fout.write(line, 0, line.length()); // 읽은 문자열을 파일에 저장 
				fout.write("\r\n", 0,2);  // 한줄 띄기 위해 \r\n을 파일에 저
			}
			fout.close();
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
