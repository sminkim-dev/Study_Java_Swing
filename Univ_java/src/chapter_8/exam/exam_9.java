package chapter_8.exam;

import java.io.File;

// 9번: 기본 프로젝트의 temp 폴더에서 .txt 일반 파일만 삭제한다. 실행 인수로 폴더 지정 가능.
public class exam_9 {
    public static void main(String[] args) {
        File directory = new File(args.length > 0 ? args[0] : "temp");
        File[] files = directory.listFiles();
        if (files == null) { System.out.println("읽을 수 없는 디렉터리입니다: " + directory); return; }
        System.out.println(directory.getAbsolutePath() + " 디렉터리의 .txt 파일을 모두 삭제합니다...");
        int deleted = 0;
        for (File file : files) {
            // 확장자가 같은 디렉터리를 지우지 않도록 일반 파일인지도 검사한다.
            if (file.isFile() && file.getName().endsWith(".txt")) {
                if (file.delete()) { System.out.println(file + " 삭제"); deleted++; }
                else System.out.println(file + " 삭제 실패");
            }
        }
        System.out.println("총 " + deleted + "개의 .txt 파일을 삭제하였습니다.");
    }
}
