package prof.finalterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

public class exam_11 extends JFrame {
    private final Container c;
    private final JLabel l = new JLabel();
    private final Monster monster;
    private boolean bulletInFlight;

    public exam_11() {
        super("Mini game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setPreferredSize(new Dimension(400, 400));

        l.setBounds(150, 300, 100, 100);
        l.setOpaque(true);
        l.setBackground(Color.BLACK);
        c.add(l);

        monster = new Monster();
        c.setFocusable(true);
        c.addKeyListener(new MyListener());

        pack();
        setVisible(true);
        c.requestFocusInWindow();
        monster.start();
    }

    class MyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER && !bulletInFlight) {
                // 화면에 총알이 없을 때만 한 발 발사한다.
                bulletInFlight = true;
                new Bullet().start();
            }
        }
    }

    class Monster extends Thread {
        private final JLabel m = new JLabel();
        private final Point m_start = new Point(0, 0);
        private final Point m_position = new Point(m_start);

        public Monster() {
            setDaemon(true);
            m.setSize(50, 50);
            m.setOpaque(true);
            m.setBackground(Color.CYAN);
            m.setLocation(m_position);
            c.add(m);
        }

        private void resetPosition() {
            m_position.setLocation(m_start);
            m.setLocation(m_position);
        }

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Thread.sleep(20);
                    // Swing 컴포넌트 변경은 이벤트 처리 스레드에서 실행한다.
                    SwingUtilities.invokeAndWait(() -> {
                        if (!isDisplayable()) {
                            interrupt();
                            return;
                        }
                        int rightEdge = Math.max(0, c.getWidth() - m.getWidth());
                        m_position.x += 5;
                        if (m_position.x > rightEdge) {
                            m_position.x = 0;
                        }
                        m.setLocation(m_position);
                    });
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(e.getCause());
            }
        }
    }

    class Bullet extends Thread {
        // 총알의 라벨과 좌표는 바깥 클래스에서 공유하지 않는다.
        private final JLabel b = new JLabel();
        private final Point b_position;
        private boolean active = true;

        public Bullet() {
            setDaemon(true);
            b.setSize(10, 10);
            b.setOpaque(true);
            b.setBackground(Color.RED);
            b_position = new Point(l.getX() + (l.getWidth() - b.getWidth()) / 2,
                    l.getY() - b.getHeight());
            b.setLocation(b_position);
            c.add(b);
            c.repaint();
        }

        private void moveBullet() {
            if (!isDisplayable()) {
                active = false;
                bulletInFlight = false;
                return;
            }

            b_position.y -= 5;
            b.setLocation(b_position);
            boolean hit = b.getBounds().intersects(monster.m.getBounds());
            if (hit) {
                monster.resetPosition();
            }
            if (hit || b_position.y + b.getHeight() <= 0) {
                active = false;
                bulletInFlight = false;
                c.remove(b);
                c.revalidate();
                c.repaint();
            }
        }

        @Override
        public void run() {
            try {
                while (active && !isInterrupted()) {
                    Thread.sleep(20);
                    SwingUtilities.invokeAndWait(this::moveBullet);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(e.getCause());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(exam_11::new);
    }
}
