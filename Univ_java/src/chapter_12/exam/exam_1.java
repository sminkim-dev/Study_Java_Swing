package chapter_12.exam;

import java.awt.*;
import javax.swing.*;

// 1번 (1): FlowLayout 패널의 크기에 맞춘 배경 이미지와 Hide/Show 버튼.
public class exam_1 {
    static class ImagePanel extends JPanel {
        private final Image image;
        private boolean imageVisible = true;
        ImagePanel(ImageIcon icon) {
            image = icon.getImage();
            setLayout(new FlowLayout());
            JButton button = new JButton("Hide/Show");
            add(button);
            // (1)은 이미지와 버튼 배치만 구현하며, 토글 동작은 exam_1_2에서 구현한다.
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g); // 이전 그림을 지운 뒤 현재 상태를 그린다.
            if (imageVisible) g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 교재 이미지 대신 기존 buddy1.jpeg를 아래 절대 경로에서 직접 읽는다.
            ImageIcon icon = new ImageIcon("<PROJECT_ROOT>/src/image/buddy1.jpeg");
            ImagePanel panel = new ImagePanel(icon);
            JFrame frame = new JFrame("이미지 그리기 연습");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
