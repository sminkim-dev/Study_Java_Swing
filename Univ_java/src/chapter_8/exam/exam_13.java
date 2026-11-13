package chapter_8.exam;

import java.io.*;
import java.util.*;

// 13번: '..' 또는 하위 디렉터리명으로 이동. 그만을 입력하면 종료한다.
public class exam_13 {
    private static void list(File current) {
        System.out.println("[" + current.getAbsolutePath() + "]");
        File[] files = current.listFiles();
        if (files == null) { System.out.println("디렉터리를 읽을 수 없습니다."); return; }
        Arrays.sort(files, Comparator.comparing(File::getName));
        for (File file : files)
            System.out.printf("%-5s %12d바이트  %s%n", file.isDirectory() ? "dir" : "file", file.length(), file.getName());
    }
    public static void main(String[] args) {
        // Windows의 c:/ 대신 Mac에서도 존재하는 홈 디렉터리를 기본 시작점으로 사용한다.
        File current = new File(args.length > 0 ? args[0] : System.getProperty("user.home")).getAbsoluteFile();
        if (!current.isDirectory()) { System.out.println("시작 경로가 디렉터리가 아닙니다."); return; }
        System.out.println("***** 파일 탐색기입니다. *****");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                list(current);
                System.out.print(">>");
                if (!sc.hasNextLine()) break;
                String command = sc.nextLine().trim();
                if (command.equals("그만")) break;
                if (command.isEmpty()) continue;
                
                // 루트의 부모는 null이므로 존재 여부를 검사한 뒤 이동한다.
                File next = command.equals("..") ? current.getParentFile() : new File(current, command);
                if (next == null || !next.isDirectory()) System.out.println("이동할 디렉터리가 없습니다.");
                else current = next;
            }
        }
    }
}
