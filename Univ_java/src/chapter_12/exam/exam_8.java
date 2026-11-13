package chapter_12.exam;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

// 8번: 누른 위치를 중심으로, 놓은 위치까지의 거리를 반지름으로 저장한다.
public class exam_8 {
    static class Circle {
        final Point center;
        final int radius;
        Circle(Point center, Point edge) {
            this.center = new Point(center);
            radius = (int) Math.round(center.distance(edge));
        }
        void draw(Graphics g) { g.drawOval(center.x - radius, center.y - radius, radius * 2, radius * 2); }
    }
    static class CirclePanel extends JPanel {
        private final Vector<Circle> circles = new Vector<>();
        private Point center, edge;
        CirclePanel() {
            MouseAdapter mouse = new MouseAdapter() {
                @Override public void mousePressed(MouseEvent e) { center = e.getPoint(); edge = center; }
                @Override public void mouseDragged(MouseEvent e) { edge = e.getPoint(); repaint(); }
                @Override public void mouseReleased(MouseEvent e) {
                    if (center == null) return;
                    circles.add(new Circle(center, e.getPoint()));
                    center = null; edge = null;
                    repaint();
                }
            };
            addMouseListener(mouse);
            addMouseMotionListener(mouse);
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            // 목록을 다시 그려야 창이 가려졌다 나타나도 이전 원들이 사라지지 않는다.
            for (Circle circle : circles) circle.draw(g);
            if (center != null && edge != null) new Circle(center, edge).draw(g);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CirclePanel panel = new CirclePanel();
            JFrame frame = new JFrame("마우스로 원 그리기");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
