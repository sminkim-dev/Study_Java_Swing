package chapter_8.exam;

import java.util.*;
import java.io.*;

public class exam_1 {
    // static 메서드에서 접근할 수 있도록 파일 경로 객체도 static으로 선언
    private static File file = new File("<USER_HOME>/Dev/Java/test.txt");

    // 파일을 열어서 한 줄씩 이어 쓰는 메서드
    private static void save(String line) {
        try {
            // 두 번째 인자에 true를 주어야 기존 내용이 지워지지 않고 이어써집니다(Append).
            FileWriter fw = new FileWriter(file, true);
            fw.write(line + "\n"); // 입력받은 문자열과 줄바꿈 문자 기록
            fw.close();            // 스트림 닫기
        } catch (IOException e) {
            System.out.println("파일 저장 중 에러 발생: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("전화번호 입력 프로그램");
        
        while (true) {
            System.out.print("이름, 전화번호 >> ");
            String line = sc.nextLine();
            
            // 문자열 비교는 반드시 .equals() 사용!
            if (line.equals("stop")) {
                break;
            }
            
            save(line); // 입력받은 텍스트 저장 메서드 호출
        }
        
        sc.close(); // 사용이 끝난 Scanner 닫기
        System.out.println("저장 완료!");
    }
}