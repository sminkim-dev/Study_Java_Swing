package chapter_8.exam;

import java.io.*;
import java.util.*;

public class exam_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("<USER_HOME>/Dev/Java/system.ini");
		
		//FileReader fin = null;
		
		try {
//			BufferedReader bfrd = new BufferedReader(new FileReader(src));
//			String line;
//			int cnt = 1;
//			System.out.println(src.getPath() + "파일을 읽어 출력합니다. ");
//			while((line = bfrd.readLine()) != null) {
//				System.out.println(cnt++ + ": " + line);
//			}
//			bfrd.close();
			Scanner fscanner = new Scanner(new FileReader(src));
			int c = 1;
			while(fscanner.hasNext()) {
				String line = fscanner.nextLine();
				System.out.printf("%4d: ", c++);
				System.out.println(line);
			}
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
