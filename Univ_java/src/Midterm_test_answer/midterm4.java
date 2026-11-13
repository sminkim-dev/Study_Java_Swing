package Midterm_test_answer;

import java.io.*;

public class midterm4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// image 폴더 주소로 경로를 잡을 시에는...
		// File src = new File(getClass().getResource("/image/buddy1.jpeg").toURL());로 하면 상대 경로로 동작.
		// toURL을 하는 이유 -> getResource()가 URL로 반환하기 때문에. File로 변환해야해서. 
		File src = new File("<PROJECT_ROOT>/src/image/buddy1.jpeg");
		File dest = new File("<PROJECT_ROOT>/src/image/desert.jpeg");
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			byte[]buf = new byte[1024 * 10];
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0, n);
				if(n<buf.length)break;
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다. ");
		}
		catch(IOException e) {
			System.out.println("파일 복사 오류 ");
		}
		
	}

}
