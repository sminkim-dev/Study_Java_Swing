package prof.midterm;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class exam_5 extends JFrame {
    private JTextArea ta = new JTextArea(15, 20);
    private JSlider sl = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
    private boolean isAdjusting = false; // 이벤트 충돌 방지용 플래그

    public exam_5() {
        super("텍스트 & 슬라이더 연동 실습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        ta.setLineWrap(true); // 줄바꿈 자동
        c.add(new JScrollPane(ta), BorderLayout.CENTER);

        // 1. 텍스트가 바뀔 때마다 슬라이더와 글자 수 제어 (DocumentListener 사용)
        ta.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                if (isAdjusting) return; // 슬라이더에 의해 변경된 경우 무시
                
                int length = ta.getText().length();
                
                // 100자 초과 시 100자로 잘라내기
                if (length > 100) {
                    SwingUtilities.invokeLater(() -> {
                        ta.setText(ta.getText().substring(0, 100));
                        ta.setCaretPosition(100);
                    });
                    length = 100;
                }
                
                // 슬라이더 값 동기화
                sl.setValue(length);
            }

            @Override
            public void insertUpdate(DocumentEvent e) { update(); }
            @Override
            public void removeUpdate(DocumentEvent e) { update(); }
            @Override
            public void changedUpdate(DocumentEvent e) { update(); }
        });

        // 2. 슬라이더를 움직였을 때 텍스트 길이 조절
        sl.addChangeListener(e -> {
            if (sl.getValueIsAdjusting() || isAdjusting) return;
            
            int targetLength = sl.getValue();
            int currentLength = ta.getText().length();

            if (currentLength != targetLength) {
                isAdjusting = true; // 리스너 충돌 방지 잠금
                if (currentLength > targetLength) {
                    // 슬라이더를 줄였을 때 뒤에서부터 자르기
                    ta.setText(ta.getText().substring(0, targetLength));
                } else {
                    // 슬라이더를 늘렸을 때 공백 추가
                    StringBuilder sb = new StringBuilder(ta.getText());
                    while (sb.length() < targetLength) {
                        sb.append(" ");
                    }
                    ta.setText(sb.toString());
                }
                isAdjusting = false; // 잠금 해제
            }
        });

        sl.setPaintLabels(true);
        sl.setPaintTicks(true);
        sl.setMajorTickSpacing(20);
        sl.setMinorTickSpacing(5);
        c.add(sl, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new exam_5());
    }
}