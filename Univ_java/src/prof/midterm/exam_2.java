package prof.midterm;

import java.util.*;
import java.io.*;
public class exam_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//String dir = "C:\\";
		String dir = "/Users/";
		String p_dir="";
		while(true) {
			try {
				File f1 = new File(dir);
				System.out.println("-----" + f1.getPath() +  "의 서브 리스트 입니다.-----");
				File[] subFiles = f1.listFiles(); 
				for(int i=0; i<subFiles.length; i++) {
					System.out.print(subFiles[i].getName());
					
					if(subFiles[i].isFile()) {
						System.out.println("\t파일 크기: " + subFiles[i].length());
						
					}
					else {
						System.out.println("\t디렉토리 크기: " + subFiles[i].length());
						
					}
				}
				String input = scanner.nextLine();
				if(input.equals("exit")) {
					System.exit(0);
				}
				p_dir = dir;
				if(input.equals("..")) {
//					if(!dir.equals("C:\\")) {
//						dir = f1.getParent();
//					}
					if(!dir.equals("/Users/")) {
						dir = f1.getParent();
					}
				}
				else {
					//dir = dir + "\\" + input;
					dir = dir + "/" + input;
				}
			}
			catch(Exception e ) {
				dir = p_dir;
			}
			
		}
		
		//scanner.close();
	}

}