package chapter_12.exam;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

// 7번: 클릭한 점을 순서대로 저장하고 마지막 점과 첫 점까지 연결한다.
public class exam_7 {
    static class PolygonPanel extends JPanel {
        private final Vector<Point> points = new Vector<>();
        PolygonPanel() {
            addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) {
                    points.add(e.getPoint());
                    repaint();
                }
            });
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int size = points.size();
            if (size == 0) return;
            int[] x = new int[size], y = new int[size];
            for (int i = 0; i < size; i++) { x[i] = points.get(i).x; y[i] = points.get(i).y; }
            g.setColor(Color.MAGENTA);
            if (size == 1) g.fillOval(x[0] - 2, y[0] - 2, 4, 4);
            else g.drawPolygon(x, y, size);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PolygonPanel panel = new PolygonPanel();
            JFrame frame = new JFrame("마우스로 폐다각형 그리기");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(600, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
