package chapter_8.exam;

import java.io.*;
import java.util.Scanner;

// 6번: 첫 파일 뒤에 두 번째 파일 내용을 붙여 appended.txt를 만든다.
public class exam_6 {
    private static void copy(Reader reader, Writer writer) throws IOException {
        char[] buffer = new char[4096];
        int count;
        while ((count = reader.read(buffer)) != -1) writer.write(buffer, 0, count);
        // readLine()을 쓰면 줄바꿈을 다시 만들어야 하므로 문자 그대로 복사한다.
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("첫번째 파일 이름을 입력하세요>>");
            if (!sc.hasNextLine()) return;
            File first = new File(sc.nextLine());
            System.out.print("두번째 파일 이름을 입력하세요>>");
            if (!sc.hasNextLine()) return;
            File second = new File(sc.nextLine());
            File output = new File("appended.txt");
            // 출력 스트림을 먼저 열면 원본이 잘릴 수 있으므로 같은 경로를 거부한다.
            if (output.getCanonicalFile().equals(first.getCanonicalFile()) ||
                    output.getCanonicalFile().equals(second.getCanonicalFile())) {
                System.out.println("입력 파일과 출력 파일은 달라야 합니다.");
                return;
            }
            try (FileReader r1 = new FileReader(first);
                 FileReader r2 = new FileReader(second);
                 FileWriter writer = new FileWriter(output)) {
                copy(r1, writer);
                copy(r2, writer);
            }
            System.out.println(output.getAbsolutePath() + " 파일에 저장하였습니다.");
        } catch (IOException e) { System.out.println("파일 입출력 오류: " + e.getMessage()); }
    }
}
