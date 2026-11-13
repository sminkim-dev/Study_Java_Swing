package chapter_8.practice;

import java.io.*;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("<PROJECT_ROOT>/src/image/games.jpeg");
		File dest = new File("<PROJECT_ROOT>/src/image/copy_buddy1.jpeg");
		
		long start = System.currentTimeMillis();
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			byte [] buf = new byte [1024*10];
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0,n);
				if(n < buf.length) {
					break;
				}
				fi.close();
				fo.close();
				long end = System.currentTimeMillis();
				double seconds = (end - start)/1000.0;
				System.out.println(src.getPath() + " -> " + dest.getPath() + "copy done");
				System.out.println("time : " + seconds + "/s");
			}
		}
		catch(IOException e) {
			System.out.println("error");
		}
	}

}
