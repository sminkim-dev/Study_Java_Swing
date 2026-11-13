package chapter_7.exam;

import java.util.*;

// 7번 (2): 도시 4개를 저장하고 도시 이름으로 검색한다.
public class exam_7_2 {
    static class Location {
        final String name;
        final double longitude, latitude;
        Location(String name, double longitude, double latitude) {
            this.name = name;
            this.longitude = longitude;
            this.latitude = latitude;
        }
        public String toString() { return name + "\t" + longitude + "\t" + latitude; }
    }
    public static void main(String[] args) {
        ArrayList<Location> cities = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            // 원문의 표제와 좌표 예시에 일부 혼동이 있어 입력 순서는 도시, 경도, 위도로 통일한다.
            System.out.println("도시, 경도, 위도를 입력하세요(쉼표로 구분, 4개).");
            while (cities.size() < 4) {
                System.out.print(">> ");
                if (!sc.hasNextLine()) return;
                String[] p = sc.nextLine().split(",", -1);
                try {
                    if (p.length != 3 || p[0].trim().isEmpty()) throw new IllegalArgumentException();
                    Location city = new Location(p[0].trim(), Double.parseDouble(p[1].trim()), Double.parseDouble(p[2].trim()));
                    if (!Double.isFinite(city.longitude) || !Double.isFinite(city.latitude)) throw new IllegalArgumentException();
                    for (Location saved : cities)
                        if (saved.name.equals(city.name)) throw new IllegalArgumentException("이미 저장된 도시입니다.");
                    cities.add(city);
                } catch (IllegalArgumentException e) {
                    System.out.println("중복되지 않는 도시 이름, 경도, 위도를 입력하세요.");
                }
            }
            System.out.println("------------------------------");
            for (Location city : cities) System.out.println(city);
            while (true) {
                System.out.print("도시 이름 >> ");
                if (!sc.hasNextLine()) break;
                String query = sc.nextLine().trim();
                if (query.equals("그만")) break;
                Location found = null;
                for (Location city : cities)
                    if (city.name.equals(query)) { found = city; break; }
                System.out.println(found == null ? query + "는 없습니다." : found);
            }
        }
    }
}
