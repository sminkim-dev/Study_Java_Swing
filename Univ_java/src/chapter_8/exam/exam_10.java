package chapter_8.exam;

import java.io.*;
import java.util.*;

// 10번: phone.txt의 각 줄을 '이름 전화번호' 형식으로 읽고 이름으로 검색한다.
public class exam_10 {
    public static void main(String[] args) {
        File file = new File(args.length > 0 ? args[0] : "phone.txt");
        HashMap<String, String> phones = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.trim().isEmpty()) continue;
                String[] p = line.trim().split("\\s+", 2);
                if (p.length != 2) { System.out.println(lineNumber + "행 형식 오류: 건너뜁니다."); continue; }
                phones.put(p[0], p[1]); // 전화번호를 String으로 저장하여 앞자리 0과 '-'를 보존한다.
            }
        } catch (IOException e) { System.out.println("파일 읽기 오류: " + e.getMessage()); return; }
        System.out.println("총 " + phones.size() + "개의 전화번호를 읽었습니다.");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("이름>> ");
                if (!sc.hasNextLine()) break;
                String name = sc.nextLine().trim();
                if (name.equals("그만")) break;
                System.out.println(phones.getOrDefault(name, "찾는 이름이 없습니다."));
            }
        }
    }
}
