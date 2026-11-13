package chapter_12.exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 4번: 컴포넌트 대신 paintComponent()로 그린 이미지를 드래그한다.
public class exam_4 {
    static class DragPanel extends JPanel {
        private final Image image;
        private final int width, height;
        private int x = 100, y = 100;
        private Point offset;
        DragPanel(ImageIcon icon) {
            image = icon.getImage();
            width = icon.getIconWidth();
            height = icon.getIconHeight();
            MouseAdapter drag = new MouseAdapter() {
                @Override public void mousePressed(MouseEvent e) {
                    if (new Rectangle(x, y, width, height).contains(e.getPoint()))
                        offset = new Point(e.getX() - x, e.getY() - y);
                    else offset = null; // 이미지 밖에서 시작한 드래그는 무시한다.
                }
                @Override public void mouseDragged(MouseEvent e) {
                    if (offset == null) return;
                    x = e.getX() - offset.x;
                    y = e.getY() - offset.y;
                    repaint();
                }
                @Override public void mouseReleased(MouseEvent e) { offset = null; }
            };
            addMouseListener(drag);
            addMouseMotionListener(drag);
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, x, y, this);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 교재 이미지 대신 기존 buddy1.jpeg를 아래 절대 경로에서 직접 읽는다.
            ImageIcon icon = new ImageIcon("<PROJECT_ROOT>/src/image/buddy1.jpeg");
            DragPanel panel = new DragPanel(icon);
            JFrame frame = new JFrame("그래픽 이미지 드래깅 연습");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
