package chapter_7.exam;

import java.util.*;

// 10번: 이중 while로 중복 문자열을 제거하고 첫 등장 순서를 보존한다.
public class exam_10 {
    private final ArrayList<String> arraylist = new ArrayList<>();
    private void searchAndRemove(String src, int j) {
        while (j < arraylist.size()) {
            if (src.equals(arraylist.get(j))) arraylist.remove(j);
            // 삭제하면 다음 원소가 j로 당겨지므로, 삭제하지 않은 경우에만 증가시킨다.
            else j++;
        }
    }
    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("문자열들을 입력하세요>>");
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine().trim();
                if (line.equals("그만")) break;
                arraylist.clear();
                if (!line.isEmpty()) Collections.addAll(arraylist, line.split("\\s+"));
                int i = 0;
                while (i < arraylist.size()) {
                    searchAndRemove(arraylist.get(i), i + 1);
                    i++;
                }
                System.out.println(String.join(" ", arraylist));
            }
        }
    }
    public static void main(String[] args) { new exam_10().run(); }
}
