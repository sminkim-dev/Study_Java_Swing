package chapter_8.exam;

import java.io.File;

// 8번: 지정한 디렉터리 바로 아래의 일반 파일 중 가장 큰 파일을 찾는다(재귀 탐색 아님).
public class exam_8 {
    public static void main(String[] args) {
        // 교재의 c:/는 Mac에 없으므로 기본값을 사용자 홈으로 하고 실행 인수로 변경한다.
        File directory = new File(args.length > 0 ? args[0] : System.getProperty("user.home"));
        File[] files = directory.listFiles();
        if (files == null) { System.out.println("읽을 수 없는 디렉터리입니다: " + directory); return; }
        File largest = null;
        for (File file : files) {
            if (file.isFile() && (largest == null || file.length() > largest.length())) largest = file;
        }
        if (largest == null) System.out.println("일반 파일이 없습니다.");
        else System.out.println("가장 큰 파일은 " + largest.getAbsolutePath() + " " + largest.length() + "바이트");
    }
}
