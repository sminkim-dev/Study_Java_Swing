package chapter_7.exam;

import java.util.*;

// 4번 (1): 품목과 개수를 쌍으로 읽고 전체 구입 비용을 계산한다.
public class exam_4 {
    public static void main(String[] args) {
        String[] names = {"고추장", "만두", "새우깡", "콜라", "참치캔", "치약", "연어", "삼겹살"};
        int[] costs = {3000, 500, 1500, 600, 2000, 1000, 2500, 2500};
        HashMap<String, Integer> prices = new HashMap<>();
        for (int i = 0; i < names.length; i++) prices.put(names[i], costs[i]);
        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능한 물건과 가격은 다음과 같습니다.");
        for (int i = 0; i < names.length; i++) System.out.print("[" + names[i] + "," + costs[i] + "] ");
        System.out.println();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("물건과 개수를 입력하세요>>");
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine().trim();
                if (line.equals("그만")) break;
                StringTokenizer st = new StringTokenizer(line);
                if (st.countTokens() == 0 || st.countTokens() % 2 != 0) {
                    System.out.println("입력에 문제가 있습니다!");
                    continue;
                }
                try {
                    long total = 0;
                    while (st.hasMoreTokens()) {
                        String item = st.nextToken();
                        Integer price = prices.get(item);
                        if (price == null) throw new IllegalArgumentException(item + "은 없는 상품입니다!");
                        int count = Integer.parseInt(st.nextToken());
                        if (count < 0) throw new IllegalArgumentException("개수는 0 이상이어야 합니다.");
                        total += (long) price * count;
                    }
                    System.out.println("전체 비용은 " + total + "원입니다.");
                } catch (NumberFormatException e) {
                    System.out.println("개수는 정수로 입력하세요.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
