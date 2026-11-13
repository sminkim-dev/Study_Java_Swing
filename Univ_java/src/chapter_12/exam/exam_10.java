package chapter_12.exam;

import java.awt.*;
import javax.swing.*;

// 10번: 이미지는 한 번만 읽고, 원본 사각형 4개를 10px 간격으로 그린다.
public class exam_10 {
    static class SplitPanel extends JPanel {
        private final Image image;
        private final int imageWidth, imageHeight;
        SplitPanel(ImageIcon icon) {
            image = icon.getImage(); imageWidth = icon.getIconWidth(); imageHeight = icon.getIconHeight();
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int gap = 10;
            int w = getWidth(), h = getHeight();
            if (w <= gap || h <= gap) return;
            int leftWidth = (w - gap) / 2, topHeight = (h - gap) / 2;
            for (int row = 0; row < 2; row++) {
                for (int col = 0; col < 2; col++) {
                    int sx1 = imageWidth * col / 2, sy1 = imageHeight * row / 2;
                    int sx2 = imageWidth * (col + 1) / 2, sy2 = imageHeight * (row + 1) / 2;
                    int dx1 = col == 0 ? 0 : leftWidth + gap;
                    int dy1 = row == 0 ? 0 : topHeight + gap;
                    int dx2 = col == 0 ? leftWidth : w;
                    int dy2 = row == 0 ? topHeight : h;
                    // 앞 사각형은 패널의 목적지, 뒤 사각형은 원본 이미지에서 잘라낼 영역이다.
                    g.drawImage(image, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, this);
                }
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 교재 이미지 대신 기존 buddy1.jpeg를 아래 절대 경로에서 직접 읽는다.
            ImageIcon icon = new ImageIcon("<PROJECT_ROOT>/src/image/buddy1.jpeg");
            SplitPanel panel = new SplitPanel(icon);
            JFrame frame = new JFrame("그래픽 이미지 4등분");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
