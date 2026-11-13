package chapter_8.practice;

import java.io.*;

public class FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() + "의 서브 서브리스트입니다. -----");
		
		File [] subFiles = dir.listFiles(); // 디렉토리에 포함된 파일과 디렉토리 이름의 리스트 얻기
		
		if (subFiles == null) {
	        System.out.println("존재하지 않거나 디렉토리가 아닙니다.");
	        return;
	    }
		
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified(); // 마지막으로 수정된 시간
			System.out.print(f.getName());
			System.out.print("\t 파일 크기: " + f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t,t,t,t); // format 출력 
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("<USER_HOME>/Dev/Java/test.txt");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		
		String res = "";
		if(f1.isFile()) {
			res = "파일 ";
		}
		else if(f1.isDirectory()) {
			res = "디렉토리 ";
		}
		System.out.println(f1.getPath() + "은 " + res + "입니다. ");
		
		File f2 = new File("<USER_HOME>/Dev/Java/test_dir");
		if(!f2.isDirectory()) {
			f2.mkdir();
		}
		listDirectory(new File("<USER_HOME>/Dev"));
		f2.renameTo(new File("<USER_HOME>/Dev/Java/rename_test_dir"));
		
		listDirectory(new File("<USER_HOME>/Dev"));
		
	}

}
