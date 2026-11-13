package chapter_7.exam;

import java.util.*;

// 6번: 입금 시 새 계좌를 만들고, 출금 시 계좌와 잔액을 먼저 검사한다.
public class exam_6 {
    private final HashMap<String, Integer> accounts = new HashMap<>();

    private void show(String name) {
        Integer balance = accounts.get(name);
        System.out.println(balance == null ? "없는 계좌입니다." : "(" + name + ":" + balance + "원)");
    }
    public void run() {
        System.out.println("*** 명품 은행에 오신 것을 환영합니다. ***");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5>>");
                if (!sc.hasNextLine()) break;
                String menu = sc.nextLine().trim();
                if (menu.equals("5")) break;
                if (menu.equals("4")) {
                    for (String name : accounts.keySet()) show(name);
                    continue;
                }
                if (!menu.equals("1") && !menu.equals("2") && !menu.equals("3")) {
                    System.out.println("메뉴는 1~5입니다.");
                    continue;
                }
                System.out.print(menu.equals("3") ? "계좌명>>" : "계좌명과 액수>>");
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine().trim();
                if (menu.equals("3")) { show(line); continue; }
                String[] p = line.split("\\s+");
                try {
                    if (p.length != 2) throw new IllegalArgumentException();
                    int amount = Integer.parseInt(p[1]);
                    if (amount < 0) throw new IllegalArgumentException();
                    if (menu.equals("1")) {
                        accounts.put(p[0], Math.addExact(accounts.getOrDefault(p[0], 0), amount));
                    } else if (!accounts.containsKey(p[0])) {
                        System.out.println("없는 계좌입니다.");
                    } else if (accounts.get(p[0]) < amount) {
                        System.out.println("잔액이 부족하여 출금할 수 없음!!");
                    } else {
                        // 검사를 모두 통과한 뒤 갱신해야 실패한 출금이 잔액을 바꾸지 않는다.
                        accounts.put(p[0], accounts.get(p[0]) - amount);
                    }
                } catch (IllegalArgumentException | ArithmeticException e) {
                    System.out.println("계좌명과 처리 가능한 0 이상의 정수 액수를 입력하세요.");
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
    public static void main(String[] args) { new exam_6().run(); }
}
