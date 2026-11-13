package chapter_7.exam;

import java.util.*;

// 12번: 입력 명령(Vector)과 변수 저장소(HashMap)를 분리한 간단한 가상 기계.
public class exam_12 {
    private final Vector<String> program = new Vector<>();
    private final HashMap<String, Integer> variables = new HashMap<>();

    private int value(String operand) {
        if (operand.matches("[+-]?[0-9]+")) return Integer.parseInt(operand);
        Integer value = variables.get(operand);
        if (value == null) throw new IllegalArgumentException("초기화하지 않은 변수: " + operand);
        return value;
    }
    public void execute() {
        variables.clear();
        int pc = 0;
        long steps = 0;
        try {
            while (pc < program.size()) {
                if (++steps > 1_000_000) throw new IllegalArgumentException("반복 실행 한도 초과(무한 루프를 확인하세요).");
                String instruction = program.get(pc);
                String[] p = instruction.split("\\s+");
                String op = p[0];
                int expected = op.equals("exi") ? 1 : op.equals("prt") ? 2 : 3;
                if (p.length != expected) throw new IllegalArgumentException("명령 인수 개수 오류: " + instruction);
                if (op.equals("exi")) break;
                if (op.equals("prt")) {
                    System.out.println("[" + instruction + "]에 의해 출력된 " + p[1] + "변수 값:" + value(p[1]));
                } else {
                    if (!p[1].matches("[a-zA-Z_][a-zA-Z_0-9]*"))
                        throw new IllegalArgumentException("잘못된 변수 이름: " + p[1]);
                    int right = value(p[2]);
                    switch (op) {
                        case "mov": variables.put(p[1], right); break;
                        case "add": variables.put(p[1], Math.addExact(value(p[1]), right)); break;
                        case "sub": variables.put(p[1], Math.subtractExact(value(p[1]), right)); break;
                        case "jn0":
                            if (value(p[1]) != 0) {
                                if (right < 0 || right >= program.size()) throw new IllegalArgumentException("점프 주소 범위 오류");
                                pc = right;
                                continue; // 점프한 뒤 pc++까지 하면 목적지 다음 명령부터 실행되므로 건너뛴다.
                            }
                            break;
                        default: throw new IllegalArgumentException("알 수 없는 명령: " + op);
                    }
                }
                pc++;
            }
            System.out.println("프로그램 실행 종료. 변수들의 최종 값을 출력합니다.");
            for (Map.Entry<String, Integer> e : variables.entrySet()) System.out.print(e.getKey() + ":" + e.getValue() + " ");
            System.out.println();
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(pc + "번 명령 실행 오류: " + e.getMessage());
        }
    }
    public void run() {
        System.out.println("나의 가상 컴퓨터가 작동합니다. 프로그램을 입력해주세요. go를 입력하면 작동합니다. (그만: 종료)");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print(program.size() + ">> ");
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine().trim();
                if (line.equals("그만")) break;
                if (line.equals("go")) { execute(); program.clear(); }
                else if (!line.isEmpty()) program.add(line);
            }
        }
    }
    public static void main(String[] args) { new exam_12().run(); }
}
