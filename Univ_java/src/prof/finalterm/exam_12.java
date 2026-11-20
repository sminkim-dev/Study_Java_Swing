package prof.finalterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class exam_12 extends JFrame {
    private final Container c;
    private final JLabel l = new JLabel();
    private static final int MAX_MONSTERS = 5;
    private static final int MAX_BULLETS = 5;
    private final List<Monster> monsters = new ArrayList<>();
    private final List<Bullet> bullets = new ArrayList<>();
    private boolean gameOver;
    private int roundId;

    public exam_12() {
        super("Mini game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setPreferredSize(new Dimension(400, 400));

        l.setBounds(150, 300, 100, 100);
        l.setOpaque(true);
        l.setBackground(Color.BLACK);
        c.add(l);

        c.setFocusable(true);
        c.addKeyListener(new MyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stopGame();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                stopGame();
            }
        });

        pack();
        setVisible(true);
        c.requestFocusInWindow();
    }

    private void stopGame() {
        gameOver = true;
        for (Monster monster : monsters) {
            monster.interrupt();
        }
        for (Bullet bullet : bullets) {
            bullet.interrupt();
        }
    }

    private void finishGame() {
        if (gameOver) {
            return;
        }
        stopGame();
        int choice = JOptionPane.showConfirmDialog(this,
                "몬스터가 발사대 영역에 도달했습니다.\n다시 시작하시겠습니까?",
                "게임 종료", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
        	stopGame();  // 기존 몬스터·총알 스레드에 interrupt()
        	dispose();   // 기존 창 닫기
        	new exam_12(); // 새 게임 객체 생성
        } else {
            // No 또는 다이얼로그 닫기를 선택하면 종료한다.
            dispose();
        }
    }

    class MyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (gameOver) {
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE && monsters.size() < MAX_MONSTERS) {
                Monster monster = new Monster();
                monsters.add(monster);
                monster.start();
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER && bullets.size() < MAX_BULLETS) {
                Bullet bullet = new Bullet();
                bullets.add(bullet);
                bullet.start();
            }
        }
    }

    class Monster extends Thread {
        private final int myRoundId = roundId;
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
            c.repaint();
        }

        private void resetPosition() {
            m_position.setLocation(m_start);
            m.setLocation(m_position);
        }

        private void moveMonster() {
            if (myRoundId != roundId || gameOver || !isDisplayable()) {
                interrupt();
                return;
            }
            int rightEdge = Math.max(0, c.getWidth() - m.getWidth());
            m_position.x += 5;
            if (m_position.x >= rightEdge) {
                m_position.x = rightEdge;
                m.setLocation(m_position);

                // 몬스터 아래쪽이 발사대 위쪽 높이에 도달한 상태에서
                // 오른쪽 끝까지 이동했을 때만 게임을 종료한다.
                if (m_position.y + m.getHeight() >= l.getY()) {
                	//m.setVisible(false);
                	m.setBackground(Color.RED);
                    finishGame();
                    return;
                }

                m_position.x = 0;
                m_position.y += 50;
            }
            m.setLocation(m_position);
        }

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    Thread.sleep(20);
                    // Swing 컴포넌트 변경은 이벤트 처리 스레드에서 실행한다.
                    SwingUtilities.invokeAndWait(this::moveMonster);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(e.getCause());
            }
        }
    }

    class Bullet extends Thread {
        private final int myRoundId = roundId;
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
            if (myRoundId != roundId || gameOver || !isDisplayable()) {
                active = false;
                return;
            }

            b_position.y -= 5;
            b.setLocation(b_position);
            boolean hit = false;
            for (Monster monster : monsters) {
                if (b.getBounds().intersects(monster.m.getBounds())) {
                    monster.resetPosition();
                    hit = true;
                    break;
                }
            }
            if (hit || b_position.y + b.getHeight() <= 0) {
                active = false;
                c.remove(b);
                bullets.remove(this);
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
        SwingUtilities.invokeLater(exam_12::new);
    }
}
