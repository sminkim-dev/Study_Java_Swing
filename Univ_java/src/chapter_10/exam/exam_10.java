package chapter_10.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exam_10 extends JFrame {
    private JLabel[] l = new JLabel[20];
    private int count = 0;
    private Container c = getContentPane();

    public exam_10() {
        super("exam_10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setLayout(null);

        MyKeyListener kListener = new MyKeyListener();
        c.addKeyListener(kListener); // 한글 영어 구분해서 입력할 것.

        setSize(300, 300);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocusInWindow();
    }

    class MyListener extends MouseAdapter {
        private int startX, startY;

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JLabel target = (JLabel)e.getSource();

            int x = target.getX() + e.getX() - startX;
            int y = target.getY() + e.getY() - startY;

            target.setLocation(x, y);
        }
    }

    class MyKeyListener extends KeyAdapter {
        public Color ranCol() {
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);

            return new Color(r, g, b);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar() == 'm') {
                if(count >= l.length) return;

                l[count] = new JLabel();
                l[count].setOpaque(true);
                l[count].setBackground(ranCol());
                l[count].setBounds(100, 100, 80, 80);

                MyListener listener = new MyListener();

                l[count].addMouseListener(listener);
                l[count].addMouseMotionListener(listener);

                c.add(l[count]);
                count++;

                c.repaint();
                c.requestFocusInWindow();
            }
        }
    }

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> new exam_10());
    	new exam_10();
    }
}
