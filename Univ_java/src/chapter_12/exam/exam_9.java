package chapter_12.exam;

import java.awt.*;
import javax.swing.*;

// 9번: 외부에서 어떤 색을 요청해도 파란 배경을 유지하는 JLabel.
public class exam_9 {
    public static class BlueLabel extends JLabel {
        public BlueLabel(String text) { super(text); setOpaque(true); setBackground(Color.BLUE); }
        @Override public void setBackground(Color color) {
            super.setBackground(Color.BLUE); // 요청 색을 무시하고 파랑으로 통일한다.
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel(new FlowLayout());
            BlueLabel small = new BlueLabel("hello");
            small.setFont(new Font("Dialog", Font.PLAIN, 10));
            small.setForeground(Color.YELLOW);
            BlueLabel big = new BlueLabel("Big Hello");
            big.setFont(new Font("Dialog", Font.ITALIC, 50));
            big.setForeground(Color.MAGENTA);
            big.setBackground(Color.RED); // 호출해도 파랑이어야 한다.
            panel.add(small); panel.add(big);
            JFrame frame = new JFrame("Blue Label 만들기");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
