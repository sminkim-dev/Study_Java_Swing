package chapter_8.practice;

import java.io.*;

public class BinaryCopyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("<PROJECT_ROOT>/src/image/games.jpeg");
		File dest = new File("<PROJECT_ROOT>/src/image/copy_buddy1.jpeg");
		
		long start = System.currentTimeMillis(); // 현재 시간
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			byte [] buf = new byte [1024*10]; // 10kb buf
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0,n);
				if(n < buf.length) break;
			}
			fi.close();
			fo.close();
			long end = System.currentTimeMillis(); // copy 완료 시간 
			double seconds = (end - start)/1000.0; // 복사에 걸린 시간
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였음. ");
			System.out.println("복사 시간은 " + seconds + "초 입니다. ");
			
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
