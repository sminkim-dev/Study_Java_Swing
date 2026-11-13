package chapter_7.exam;

import java.util.*;

// 8번 (1): 학생 객체를 저장하고, 평균 4.0 이상을 장학생으로 선발한다.
public class exam_8 {
    static class Student {
        final String name, major, id;
        final double average;
        Student(String name, String major, String id, double average) {
            this.name = name; this.major = major; this.id = id; this.average = average;
        }
        public String toString() {
            return "이름:" + name + "\t전공:" + major + "\t학번:" + id + "\t학점평균:" + average;
        }
    }
    public static void main(String[] args) {
        Vector<Student> students = new Vector<>();
        Vector<Student> scholars = new Vector<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("4명 이름, 전공, 학번, 학점 입력(쉼표로 구분)");
            while (students.size() < 4) {
                System.out.print(">>");
                if (!sc.hasNextLine()) return;
                String[] p = sc.nextLine().split(",", -1);
                try {
                    if (p.length != 4) throw new IllegalArgumentException();
                    for (int i = 0; i < p.length; i++) {
                        p[i] = p[i].trim();
                        if (p[i].isEmpty()) throw new IllegalArgumentException();
                    }
                    double avg = Double.parseDouble(p[3]);
                    if (!Double.isFinite(avg) || avg < 0 || avg > 4.5) throw new IllegalArgumentException();
                    Student student = new Student(p[0], p[1], p[2], avg);
                    students.add(student);
                } catch (IllegalArgumentException e) {
                    System.out.println("이름, 전공, 학번, 학점(0~4.5)을 확인하세요. 맵에서는 이름이 중복되면 안 됩니다.");
                }
            }
            System.out.println("--------------------------------------------------");
            for (Student student : students) {
                System.out.println(student);
                if (student.average >= 4.0) scholars.add(student);
            }
            System.out.print("장학생: ");
            for (Student student : scholars) System.out.print(student.name + " ");
            System.out.println();
            while (true) {
                System.out.print("학생 이름 >>");
                if (!sc.hasNextLine()) break;
                String name = sc.nextLine().trim();
                if (name.equals("그만")) break;
                Student found = null;
                for (Student student : students)
                    if (student.name.equals(name)) { found = student; break; }
                System.out.println(found == null ? name + " 학생이 없습니다." : found);
            }
        }
    }
}
