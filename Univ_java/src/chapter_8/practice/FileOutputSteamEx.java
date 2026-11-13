package chapter_8.practice;

import java.io.*;

public class FileOutputSteamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//실행 과정만 본 코드 
		byte b[] = {7,51,3,4,-1,24};
		
		try {
			FileOutputStream fout = new FileOutputStream("<USER_HOME>/Dev/Java/test.txt");
			for(int i = 0; i < b.length; i++) {
				fout.write(b[i]);
			}
			fout.close();
		}
		catch(IOException e) {
			System.out.println("해당 경로에 저장할 수 없었습니다. 다시 확인해주십시오.");
			return;
		}
		System.out.println("해당 경로에 저장하였습니다.");
	}

}
