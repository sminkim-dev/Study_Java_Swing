package chapter_8.practice;

import java.io.*;

public class FileInputStreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte [] b = new byte[6];
		try {
			// byte b[] = {7,51,3,4,-1,24}; << - 이게 원본 값 
			// 55 32 53 49 32 51 <- 아스키 코드 값이 출력됨 
			FileInputStream fin = new FileInputStream("<USER_HOME>/Dev/Java/test.txt");
			int n = 0, c;
			while(n < b.length &&(c = fin.read()) != -1) {
				b[n++] = (byte)c;
			}
			System.out.println("해당 경로에서 읽은 배열을 출력합니다. ");
			for(int i = 0; i < b.length; i++) {
				System.out.print(b[i] + " ");
			}
			System.out.println();
		}
		catch(IOException e) {
			System.out.println("해당 경로에서 읽지 못했습니다. 경로를 확인해주세요 ");
		}
	}

}
