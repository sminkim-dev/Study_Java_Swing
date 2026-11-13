package chapter_8.exam;

import java.io.*;
import java.util.*;

// 12번: 원문 줄을 Vector에 보관하고 검색어가 포함된 줄과 줄 번호를 출력한다.
public class exam_12 {
    public static void main(String[] args) {
        Vector<String> lines = new Vector<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("대상 파일명 입력>> ");
            if (!sc.hasNextLine()) return;
            File file = new File(sc.nextLine());
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) lines.add(line); // 빈 줄도 저장해야 줄 번호가 맞는다.
            } catch (IOException e) { System.out.println("파일 읽기 오류: " + e.getMessage()); return; }
            while (true) {
                System.out.print("검색할 단어나 문장>> ");
                if (!sc.hasNextLine()) break;
                String query = sc.nextLine();
                if (query.equals("그만")) break;
                boolean found = false;
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).contains(query)) {
                        System.out.println((i + 1) + ": " + lines.get(i));
                        found = true;
                    }
                }
                if (!found) System.out.println("찾는 내용이 없습니다.");
            }
        }
    }
}
