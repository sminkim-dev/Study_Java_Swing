package chapter_12.exam;

import java.awt.*;
import javax.swing.*;

// 11번: 입력 칸에서 Enter를 누르면 판매 비율과 파이 차트를 함께 갱신한다.
public class exam_11 {
    static class ChartPanel extends JPanel {
        private final String[] names = {"apple", "cherry", "strawberry", "prune"};
        private final Color[] colors = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE};
        private final JTextField[] fields = new JTextField[4];
        private int[] sales = {0, 0, 0, 0};
        private final JPanel chart;
        ChartPanel() {
            setLayout(new BorderLayout());
            JPanel input = new JPanel(new FlowLayout());
            for (int i = 0; i < fields.length; i++) {
                input.add(new JLabel(names[i]));
                fields[i] = new JTextField("0", 4);
                fields[i].addActionListener(e -> updateSales());
                input.add(fields[i]);
            }
            add(input, BorderLayout.NORTH);
            chart = new JPanel() {
                @Override protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    long total = 0;
                    for (int sale : sales) total += sale;
                    for (int i = 0; i < sales.length; i++) {
                        g.setColor(colors[i]);
                        int percent = total == 0 ? 0 : (int) Math.round(100.0 * sales[i] / total);
                        g.drawString(names[i] + " " + percent + "%", 10 + i * getWidth() / 4, 25);
                    }
                    if (total == 0) {
                        g.setColor(Color.DARK_GRAY);
                        g.drawString("판매량을 입력하고 Enter를 누르세요.", 20, 60);
                        return;
                    }
                    int diameter = Math.max(0, Math.min(getWidth() - 40, getHeight() - 70));
                    int x = (getWidth() - diameter) / 2, y = 50;
                    int start = 0;
                    long cumulative = 0;
                    for (int i = 0; i < sales.length; i++) {
                        cumulative += sales[i];
                        // 개별 각도 대신 누적 비율을 반올림하면 최종 각도가 정확히 360도가 된다.
                        int end = (int) Math.round(360.0 * cumulative / total);
                        g.setColor(colors[i]);
                        g.fillArc(x, y, diameter, diameter, start, end - start);
                        start = end;
                    }
                }
            };
            chart.setBackground(Color.WHITE);
            add(chart, BorderLayout.CENTER);
        }
        private void updateSales() {
            try {
                int[] next = new int[4];
                for (int i = 0; i < next.length; i++) {
                    next[i] = Integer.parseInt(fields[i].getText().trim());
                    if (next[i] < 0) throw new NumberFormatException();
                }
                sales = next; // 모든 칸을 검증한 뒤 한 번에 바꾼다.
                chart.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "판매량은 0 이상의 정수로 입력하세요.");
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("파이 차트 그리기");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new ChartPanel());
            frame.setSize(760, 520);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
