package chapter_11.exam;

import javax.swing.*;
import java.awt.*;

public class exam_3 extends JFrame {

    private JTextField tf = new JTextField(10);
    private JLabel[] la = new JLabel[8];

    private String[] names = {
        "5만원", "만원", "천원", "500원",
        "100원", "50원", "10원", "1원"
    };

    private int[] money = {
        50000, 10000, 1000, 500,
        100, 50, 10, 1
    };

    public exam_3() {
        super("Money Changer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(Color.YELLOW);
        c.setLayout(new BorderLayout());

        // 1. 상단 패널 - FlowLayout
        JPanel north = new JPanel();
        north.setBackground(Color.YELLOW);
        north.setLayout(new FlowLayout(FlowLayout.CENTER));

        north.add(new JLabel("금액"));
        north.add(tf);

        JButton btn = new JButton("cal");

        btn.addActionListener(e -> {
            try {
                int price = Integer.parseInt(tf.getText());

                if(price < 0) {
                    JOptionPane.showMessageDialog(this, "0 이상의 금액을 입력하세요.");
                    return;
                }

                for(int i = 0; i < money.length; i++) {
                    int count = price / money[i];
                    price = price % money[i];

                    la[i].setText(Integer.toString(count));
                }

            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "정수를 입력하세요.");
            }
        });

        north.add(btn);
        c.add(north, BorderLayout.NORTH);


        // 2. 결과 패널 - GridLayout
        JPanel center = new JPanel();
        center.setBackground(Color.YELLOW);
        center.setLayout(new GridLayout(8, 2, 5, 3));

        // GridLayout 전체의 선호 크기
        center.setPreferredSize(new Dimension(180, 200));

        for(int i = 0; i < money.length; i++) {

            // 왼쪽: 화폐 단위
            JLabel l = new JLabel(names[i], SwingConstants.RIGHT);

            // 오른쪽: 계산 결과
            la[i] = new JLabel("0", SwingConstants.CENTER);
            la[i].setOpaque(true);
            la[i].setBackground(Color.WHITE);
            la[i].setForeground(Color.BLACK);

            // 테두리 설정
            la[i].setBorder(
                BorderFactory.createLineBorder(Color.GRAY)
            );

            center.add(l);
            center.add(la[i]);
        }


        // 3. GridLayout을 감싸는 FlowLayout 패널 // 여기 부분 이해하기 
        JPanel wrapper = new JPanel();
        wrapper.setBackground(Color.YELLOW);
        wrapper.setLayout(new FlowLayout(FlowLayout.CENTER));

        wrapper.add(center);

        // BorderLayout의 CENTER에 wrapper 추가
        c.add(wrapper, BorderLayout.CENTER);


        // 4. 프레임 설정
        setSize(300, 330);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new exam_3();
    }
}