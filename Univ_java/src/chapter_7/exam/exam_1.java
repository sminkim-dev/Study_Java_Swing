package chapter_7.exam;

import java.util.Scanner;
import java.util.Vector;

// 1번: 입력한 양의 정수를 Vector에 저장하고 최솟값을 찾는다.
public class exam_1 {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("정수 입력(-1이면 입력 끝)>>");
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n == -1) break;
                if (n > 0) numbers.add(n);
                else System.out.println("양의 정수를 입력하세요.");
            }
        }
        // 첫 원소를 최솟값으로 쓰므로 빈 벡터부터 검사한다.
        if (numbers.isEmpty()) {
            System.out.println("입력한 양의 정수가 없습니다.");
            return;
        }
        int min = numbers.get(0);
        for (int n : numbers) if (n < min) min = n;
        System.out.println("제일 작은 수는 " + min);
    }
}
