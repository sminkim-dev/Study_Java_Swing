package chapter_12.exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 5번: +는 현재 크기의 1.1배, -는 0.9배. 원본 이미지는 (10, 10)에 표시한다.
public class exam_5 {
    static class ZoomPanel extends JPanel {
        private final Image image;
        private final int originalWidth, originalHeight;
        private double scale = 1.0;
        ZoomPanel(ImageIcon icon) {
            image = icon.getImage();
            originalWidth = icon.getIconWidth();
            originalHeight = icon.getIconHeight();
            setFocusable(true);
            addKeyListener(new KeyAdapter() {
                @Override public void keyTyped(KeyEvent e) {
                    double next = scale;
                    if (e.getKeyChar() == '+') next *= 1.1; // scale *= 1.1; 로 해도 동작함. 아래 코드 복잡한 계산 안해도 가능. 
                    else if (e.getKeyChar() == '-') next *= 0.9;
                    else return;
                    // 크기가 0이나 int 범위를 벗어나면 정상적으로 그릴 수 없으므로 제한한다.
                    double maxScale = 100000.0 / Math.max(originalWidth, originalHeight);
                    scale = Math.max(1.0 / Math.min(originalWidth, originalHeight), Math.min(maxScale, next));
                    repaint();
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override public void mousePressed(MouseEvent e) { requestFocusInWindow(); }
            });
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = Math.max(1, (int) Math.round(originalWidth * scale));
            int height = Math.max(1, (int) Math.round(originalHeight * scale));
            g.drawImage(image, 10, 10, width, height, this);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 교재 이미지 대신 기존 buddy1.jpeg를 아래 절대 경로에서 직접 읽는다.
            ImageIcon icon = new ImageIcon("<PROJECT_ROOT>/src/image/buddy1.jpeg");
            ZoomPanel panel = new ZoomPanel(icon);
            JFrame frame = new JFrame("그래픽 이미지 확대 축소 연습 (+ / -)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            // 키 입력을 받는 패널이므로 창을 표시한 뒤 포커스를 요청한다.
            panel.requestFocusInWindow();
        });
    }
}
