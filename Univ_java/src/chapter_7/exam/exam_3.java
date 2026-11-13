package chapter_7.exam;

import java.util.HashMap;
import java.util.Scanner;

// 3번: 종목을 키, 주가를 값으로 저장하여 이름으로 바로 검색한다.
public class exam_3 {
    public static void main(String[] args) {
        HashMap<String, Integer> stocks = new HashMap<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("주식 종목과 주가를 입력하세요(예: 삼성전자 75000)");
            while (true) {
                System.out.print("종목, 주가>>");
                if (!sc.hasNextLine()) return;
                String line = sc.nextLine().trim();
                if (line.equals("그만")) break;
                String[] p = line.split("\\s+");
                try {
                    if (p.length != 2) throw new IllegalArgumentException(); // 강제 예외 발생 값이 2개가 아닐 경우 에러 
                    int price = Integer.parseInt(p[1]);
                    if (price < 0) throw new IllegalArgumentException(); // 강제 예외 발생, 정수 값이 음수일 때 .
                    stocks.put(p[0], price);
                } catch (IllegalArgumentException e) {
                    System.out.println("종목과 0 이상의 정수 주가를 입력하세요.");
                }
            }
            System.out.println("주가를 검색합니다.");
            while (true) {
                System.out.print("종목>>");
                if (!sc.hasNextLine()) break;
                String name = sc.nextLine().trim();
                if (name.equals("그만")) break;
                Integer price = stocks.get(name);
                System.out.println(price == null ? name + "는 없는 종목입니다." : name + "의 주가는 " + price + "원");
            }
        }
    }
}
