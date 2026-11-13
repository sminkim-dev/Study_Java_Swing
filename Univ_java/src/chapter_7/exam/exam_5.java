package chapter_7.exam;

import java.util.*;

// 5번: 같은 고객이 다시 입력되면 이전 마일리지에 더한다.
public class exam_5 {
    public static void main(String[] args) {
        HashMap<String, Integer> mileage = new HashMap<>();
        System.out.println("*** 마일리지 관리 프로그램입니다. ***");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("이름과 마일리지>>");
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine().trim();
                if (line.equals("그만")) break;
                String[] p = line.split("\\s+");
                try {
                    if (p.length != 2) throw new IllegalArgumentException();
                    int amount = Integer.parseInt(p[1]);
                    if (amount < 0) throw new IllegalArgumentException();
                    mileage.put(p[0], Math.addExact(mileage.getOrDefault(p[0], 0), amount)); // getOrDefault hashmap에 없으면 0을, 기존에 있다면 amount를 합산.
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("이름과 누적 가능한 0 이상의 정수를 입력하세요.");
                }
            }
        }
        String best = null;
        for (Map.Entry<String, Integer> e : mileage.entrySet()) {
            System.out.print("(" + e.getKey() + ":" + e.getValue() + ")");
            if (best == null || e.getValue() > mileage.get(best)) best = e.getKey();
        }
        System.out.println();
        if (best != null) System.out.println("가장 마일리지가 높은 고객은 " + best + "입니다.");
        System.out.println("프로그램을 종료합니다.");
    }
}
