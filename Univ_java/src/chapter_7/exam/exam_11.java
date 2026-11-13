package chapter_7.exam;

import java.util.*;

// 11번: 이름별 리스트에 매일 걸음수를 계속 추가한다.
public class exam_11 {
    private static long sum(ArrayList<Integer> steps) {
        long total = 0;
        for (int step : steps) total += step;
        return total;
    }
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> records = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("이름과 걸음수>>");
                if (!sc.hasNextLine()) return;
                String line = sc.nextLine().trim();
                if (line.equals("그만")) break;
                String[] p = line.split("\\s+");
                try {
                    if (p.length < 2) throw new IllegalArgumentException();
                    ArrayList<Integer> added = new ArrayList<>();
                    for (int i = 1; i < p.length; i++) {
                        int n = Integer.parseInt(p[i]);
                        if (n < 0) throw new IllegalArgumentException();
                        added.add(n);
                    }
                    // 입력 전체를 검사한 뒤 추가하여, 잘못된 줄이 일부만 저장되는 일을 막는다.
                    records.computeIfAbsent(p[0], k -> new ArrayList<>()).addAll(added);
                } catch (IllegalArgumentException e) { System.out.println("이름과 0 이상의 정수 걸음수를 입력하세요."); }
            }
            String best = null;
            long max = -1;
            for (Map.Entry<String, ArrayList<Integer>> e : records.entrySet()) {
                long total = sum(e.getValue());
                if (total > max) { max = total; best = e.getKey(); }
            }
            if (best != null) System.out.println("걸음수가 가장 많은 사람은 " + best + " " + max + "보");
            while (true) {
                System.out.print("검색할 이름>>");
                if (!sc.hasNextLine()) break;
                String name = sc.nextLine().trim();
                if (name.equals("그만")) break;
                ArrayList<Integer> steps = records.get(name);
                if (steps == null) { System.out.println(name + "는 없는 학생입니다."); continue; }
                for (int step : steps) System.out.print(step + " ");
                System.out.println("평균 " + sum(steps) / steps.size()); // 교재 예시처럼 정수 평균 사용.
            }
        }
    }
}
