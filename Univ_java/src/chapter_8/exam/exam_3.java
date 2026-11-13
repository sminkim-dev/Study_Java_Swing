package chapter_8.exam;

import java.io.*;
public class exam_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("<USER_HOME>/Dev/Java/test.txt");
		FileReader fin = null;
		
		try {
			//fin = new FileReader(src);
			BufferedReader bf = new BufferedReader(new FileReader(src));
			
			//int c;
			String line;
//			while((c = fin.read())!= -1) {
//				c = Character.toUpperCase(c);
//				System.out.print((char)c);
//			}
			while((line = bf.readLine()) != null) {
				System.out.println(line.toUpperCase());
			}
			//fin.close();
			bf.close();
		}
		catch (IOException e) {
			
		}
	}

}
