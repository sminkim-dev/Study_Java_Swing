package chapter_7.exam;

import java.util.Scanner;
import java.util.Vector;

// 9번: 상속과 다형성을 이용한 콘솔 그래픽 편집기.
public class exam_9 {
    static abstract class Shape { public abstract void draw(); }
    static class Line extends Shape { public void draw() { System.out.println("Line"); } }
    static class Rect extends Shape { public void draw() { System.out.println("Rect"); } }
    static class Circle extends Shape { public void draw() { System.out.println("Circle"); } }

    public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<>();
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
                if (!sc.hasNextLine()) break;
                String menu = sc.nextLine().trim();
                if (menu.equals("4")) break;
                if (menu.equals("3")) {
                    // 실제 객체 종류에 맞는 draw()가 호출되므로 타입별 분기가 필요 없다.
                    for (Shape shape : shapes) shape.draw();
                } else if (menu.equals("1")) {
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    if (!sc.hasNextLine()) break;
                    switch (sc.nextLine().trim()) {
                        case "1": shapes.add(new Line()); break;
                        case "2": shapes.add(new Rect()); break;
                        case "3": shapes.add(new Circle()); break;
                        default: System.out.println("도형 번호는 1~3입니다.");
                    }
                } else if (menu.equals("2")) {
                    System.out.print("삭제할 도형의 위치(0부터 시작)>>");
                    if (!sc.hasNextLine()) break;
                    try {
                        int index = Integer.parseInt(sc.nextLine().trim());
                        if (index < 0 || index >= shapes.size()) throw new IllegalArgumentException();
                        shapes.remove(index);
                    } catch (IllegalArgumentException e) { System.out.println("삭제할 수 없습니다."); }
                } else System.out.println("메뉴는 1~4입니다.");
            }
        }
        System.out.println("Beauty Graphic Editor를 종료합니다.");
    }
}
