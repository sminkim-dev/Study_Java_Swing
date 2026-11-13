package chapter_12.exam;

import java.awt.*;
import javax.swing.*;

// 6번 (2): 패널 크기로 좌표를 다시 계산하여 창을 늘려도 도형의 비율이 유지된다.
public class exam_6_2 {
    static class DrawingPanel extends JPanel {
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth(), h = getHeight();
            if (w <= 0 || h <= 0) return;
            g.setColor(Color.BLACK);
            for (int i = 0; i < 10; i++) {
                double ratio = 1.0 - i * 0.07;
                int rx = (int) ((w - 1) * ratio / 2);
                int ry = (int) ((h - 1) * ratio / 2);
                int cx = (w - 1) / 2, cy = (h - 1) / 2;
                g.drawPolygon(new int[] {cx, cx + rx, cx, cx - rx},
                        new int[] {cy - ry, cy, cy + ry, cy}, 4);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingPanel panel = new DrawingPanel();
            JFrame frame = new JFrame("마름모 10개 그리기");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
