package Midterm_test_answer;

import java.util.*;

public class midterm2{

	static class Element implements Comparable{
		public String key="";
		public int freq = 0;
		
		public Element() {
			
		}
		@Override
		public int compareTo(Object o) {
			return (int)(((Element)o).freq - this.freq);
		}
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		
		//String lines = "";
		System.out.println("-----".repeat(10));
		String lines = "Vim is a text editor made by Bram Moolenaar. Moolenaar publicly released Vim on November 2, 1991 for the Commodore Amiga.\n"
				+ "Vim stands for Vi IMproved. Vim is an improved version of the vi text editor, an editor created by Bill Joy in 1976. Vim is free, and the source code is publicly available on GitHub. It is available in multiple languages, and it works on multiple operating systems, including Windows, Linux, and macOS. Vim can be used from either a command-line interface or a graphical user interface.\n"
				+ "While Vim can be hard to use, there are built-in commands new users can learn from reading the Vim user manual, running the :help command in Vim, or using the vimtutor command in a terminal.\n"
				+ "Vim is widely popular because it allows users to perform many functions on a document (save, search, scroll, etc.) by pressing as few keys as possible. However, many critics argue that these keystrokes are confusing.\n"
				+ "One can customize Vim using a .vimrc file. To add new features like keyboard shortcuts, one can use Vim script, Vim’s built-in programming language. Many Vim plugins and extensions are also available online for free.\n"
				+ "There is an Internet turf war between programmers that prefer Vim and programmers that prefer Emacs, another common text editor.";
//		while(sc.hasNextLine()) {
//			String temp = sc.nextLine();
//			lines = lines + " " + temp;
//		}
		String trim = lines.replaceAll("[.,?!]", "");
		String up = trim.toUpperCase(); // 소문자 -> 대문자 변
		
		System.out.println(up);
		
		StringTokenizer st = new StringTokenizer(up);
		int n = st.countTokens();
		
		String [] words = new String[st.countTokens()];
		
		int [] cnt = new int[n];
		
		for(int i = 0; i < n; i++) {
			words[i] = st.nextToken();
			cnt[i] = 1;
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(words[i].equals(words[j])) {
					cnt[i]++;
				}
			}
		}
		HashMap<String, Integer> h = new HashMap<>();
		for(int i = 0; i < n; i++) {
			// put 덮어씀.
			if(h.containsKey(words[i]));
			else h.put(words[i], cnt[i]);	
		}
		Set<String> key = h.keySet();
		Iterator it = key.iterator();
		ArrayList<Element> result = new ArrayList<>();
		
		while(it.hasNext()) {
			Element temp = new Element(); // class 안에 class를 넣어서, 외부로 빼거나 static class
			temp.key = (String)it.next();
			temp.freq = h.get(temp.key);
			result.add(temp);
		}
		Collections.sort(result);
		System.out.println("-----".repeat(10));
		for(int i = 0; i < result.size(); i++) {
			System.out.println("(" + result.get(i).key + "," + result.get(i).freq + ")"); // 키와 값의 쌍 출력
		}
	}

}
