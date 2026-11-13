package chapter_7.exam;

import java.util.Scanner;
import java.util.Vector;

// 2번: 입력, 음수 변경, 출력, 합계를 메서드별로 나눈다.
public class exam_2 {
    private final Vector<Integer> v = new Vector<>();

    public void read() {
        System.out.print("0이 입력될 때까지 정수 입력>>");
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n == 0) break;
                v.add(n);
            }
        }
    }
    public void changeToZero() {
        for (int i = 0; i < v.size(); i++)
            if (v.get(i) < 0) v.set(i, 0); // 삭제 대신 교체하여 원래 위치를 유지한다.
    }
    public void showAll() {
        for (int n : v) System.out.print(n + " ");
        System.out.println();
    }
    public long add() {
        long sum = 0;
        for (int n : v) sum += n;
        return sum;
    }
    public static void main(String[] args) {
        exam_2 sp = new exam_2();
        sp.read();
        sp.changeToZero();
        System.out.print("음수를 0으로 바꾸면 ");
        sp.showAll();
        System.out.println("양수들의 합은 " + sp.add());
    }
}
