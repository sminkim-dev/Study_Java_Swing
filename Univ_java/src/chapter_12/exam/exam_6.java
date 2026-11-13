package chapter_12.exam;

import java.awt.*;
import javax.swing.*;

// 6번 (1): 패널 크기로 좌표를 다시 계산하여 창을 늘려도 도형의 비율이 유지된다.
public class exam_6 {
    static class DrawingPanel extends JPanel {
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth(), h = getHeight();
            if (w <= 0 || h <= 0) return;
            g.setColor(Color.BLACK);
            for (int i = 1; i < 10; i++) {
                int x = (int) ((long) w * i / 10);
                int y = (int) ((long) h * i / 10);
                g.drawLine(x, 0, x, h - 1);
                g.drawLine(0, y, w - 1, y);
            }
            g.drawRect(0, 0, w - 1, h - 1);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingPanel panel = new DrawingPanel();
            JFrame frame = new JFrame("10 x 10 격자 그리기");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
