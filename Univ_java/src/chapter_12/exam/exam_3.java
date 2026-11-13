package chapter_12.exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 3번: JLabel에 이미지를 넣고 누른 지점을 유지하면서 드래그한다.
public class exam_3 {
    static class DragPanel extends JPanel {
        DragPanel(ImageIcon icon) {
            setLayout(null);
            JLabel label = new JLabel(icon);
            label.setBounds(100, 100, icon.getIconWidth(), icon.getIconHeight());
            add(label);
            MouseAdapter drag = new MouseAdapter() {
                private Point offset;
                @Override public void mousePressed(MouseEvent e) { offset = e.getPoint(); }
                @Override public void mouseDragged(MouseEvent e) {
                    if (offset == null) return;
                    // 이벤트 좌표는 레이블 기준이므로 부모 패널 좌표로 변환한다.
                    Point parentPoint = SwingUtilities.convertPoint(label, e.getPoint(), DragPanel.this);
                    label.setLocation(parentPoint.x - offset.x, parentPoint.y - offset.y);
                }
                @Override public void mouseReleased(MouseEvent e) { offset = null; }
            };
            label.addMouseListener(drag);
            label.addMouseMotionListener(drag);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 교재 이미지 대신 기존 buddy1.jpeg를 아래 절대 경로에서 직접 읽는다.
            ImageIcon icon = new ImageIcon("<PROJECT_ROOT>/src/image/buddy1.jpeg");
            DragPanel panel = new DragPanel(icon);
            JFrame frame = new JFrame("이미지 레이블 드래깅 연습");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
