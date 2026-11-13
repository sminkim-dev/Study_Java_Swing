package chapter_12.exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 2번: 배경 위에서 드래그하는 위치를 중심으로 반지름 20의 초록 원을 그린다.
public class exam_2 {
    static class DrawingPanel extends JPanel {
        private final Image image;
        private Point center = new Point(100, 100);
        DrawingPanel(ImageIcon icon) {
            image = icon.getImage();
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override public void mouseDragged(MouseEvent e) {
                    center = e.getPoint();
                    repaint();
                }
            });
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            g.setColor(Color.GREEN);
            g.fillOval(center.x - 20, center.y - 20, 40, 40); // drawOval의 좌표는 중심이 아닌 왼쪽 위이다.
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 교재 이미지 대신 기존 buddy1.jpeg를 아래 절대 경로에서 직접 읽는다.
            ImageIcon icon = new ImageIcon("<PROJECT_ROOT>/src/image/buddy1.jpeg");
            DrawingPanel panel = new DrawingPanel(icon);
            JFrame frame = new JFrame("이미지 위에 원 드래깅 연습");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
