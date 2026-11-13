package chapter_8.exam;

import java.io.*;
import java.util.*;

// 11번: 한 줄에 단어 하나가 있는 words.txt를 한 번 읽고 접두어로 반복 검색한다.
public class exam_11 {
    public static void main(String[] args) {
        Vector<String> words = new Vector<>();
        File file = new File(args.length > 0 ? args[0] : "words.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) words.add(line.trim());
            }
        } catch (IOException e) { System.out.println("파일 읽기 오류: " + e.getMessage()); return; }
        System.out.println(file + " 파일을 읽었습니다...");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("단어>>");
                if (!sc.hasNextLine()) break;
                String prefix = sc.nextLine().trim();
                if (prefix.equals("그만")) break;
                boolean found = false;
                for (String word : words) {
                    if (word.startsWith(prefix)) { System.out.println(word); found = true; }
                }
                if (!found) System.out.println("발견할 수 없음");
            }
        }
        System.out.println("종료합니다...");
    }
}
