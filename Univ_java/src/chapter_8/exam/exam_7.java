package chapter_8.exam;

import java.io.*;

// 7번: 작성 중이던 games.jpeg 복사를 완성. 실행 인수로 원본 경로, 복사 경로 지정 가능.
public class exam_7 {
    public static void copy(File source, File target) throws IOException {
        if (source.getCanonicalFile().equals(target.getCanonicalFile()))
            throw new IOException("원본과 복사 경로는 달라야 합니다.");
        long total = source.length();
        long copied = 0;
        int stars = 0;
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(target)) {
            byte[] buffer = new byte[4096];
            int count;
            while ((count = in.read(buffer)) != -1) {
                out.write(buffer, 0, count);
                copied += count;
                // 작은 파일은 한 번 읽어도 여러 10% 경계를 넘으므로 while로 모두 출력한다.
                while (stars < 10 && copied >= Math.ceil(total * ((stars + 1) / 10.0))) {
                    System.out.print('*');
                    System.out.flush();
                    stars++;
                }
            }
        }
        if (total == 0) System.out.print("빈 파일 복사 완료");
        System.out.println();
    }
    public static void main(String[] args) {
        File source = new File(args.length > 0 ? args[0] : "src/image/games.jpeg");
        File target = new File(args.length > 1 ? args[1] : "games-copy.jpeg");
        System.out.println(source + "를 " + target + "로 복사합니다. 10%마다 *를 출력합니다.");
        try { copy(source, target); }
        catch (IOException e) { System.out.println("파일 복사 오류: " + e.getMessage()); }
    }
}
