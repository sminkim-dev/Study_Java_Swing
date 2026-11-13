package prof.finalterm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

// random circle
public class exam_7 extends JFrame implements ActionListener {

    static class MyPanel extends JPanel {
        public int x, y;
        public int size = 30;
        public volatile int interval = 500;
        public String move_mode = "RandomMove";
        public String size_mode = "FixedSize";
        public int size_inc = 2;
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            if (x >= 0 && y >= 0) {
                g.fillOval(x, y, size, size); // x, y는 원의 왼쪽 위 좌표
            }
        }
    }

    static class RandomC extends Thread {
        private final MyPanel mp;
        public int x_inc = 5, y_inc = 5;
        
        public volatile boolean flag = false;

        public RandomC(MyPanel mp) {
            this.mp = mp;
        }

        void finish() {
            flag = true;
            interrupt();
        }

        // 메뉴 처리와 원의 상태 변경은 모두 Swing 이벤트 스레드에서 실행한다.
        void changeMode(String command) {
            switch (command) {
                case "FixedSize":
                    mp.size_mode = command; // 현재 크기를 그대로 유지
                    mp.interval = 500;
                    break;
                case "VarSize":
                    mp.size_mode = command;
                    mp.interval = 100;
                    break;
                case "RandomMove":
                case "Move":
                    mp.move_mode = command;
                    break;
            }
        }

        void updateCircle() {
            if (flag || mp.getWidth() <= 0 || mp.getHeight() <= 0) {
                return;
            }

            int maxSize = Math.min(70, Math.min(mp.getWidth(), mp.getHeight()));
            int minSize = Math.min(2, maxSize);
            if (mp.size_mode.equals("VarSize")) {
                if (mp.size + mp.size_inc > maxSize) {
                    mp.size_inc = -Math.abs(mp.size_inc);
                } else if (mp.size + mp.size_inc < minSize) {
                    mp.size_inc = Math.abs(mp.size_inc);
                }
                mp.size = Math.max(minSize, Math.min(maxSize, mp.size + mp.size_inc));
            }

            int maxX = Math.max(0, mp.getWidth() - mp.size);
            int maxY = Math.max(0, mp.getHeight() - mp.size);
            switch (mp.move_mode) {
                case "RandomMove":
                    mp.x = (int) (Math.random() * (maxX + 1));
                    mp.y = (int) (Math.random() * (maxY + 1));
                    break;
                case "Move":
                    mp.x += x_inc;
                    mp.y += y_inc;
                    if (mp.x <= 0) {
                        x_inc = Math.abs(x_inc);
                    } else if (mp.x >= maxX) {
                        x_inc = -Math.abs(x_inc);
                    }
                    if (mp.y <= 0) {
                        y_inc = Math.abs(y_inc);
                    } else if (mp.y >= maxY) {
                        y_inc = -Math.abs(y_inc);
                    }
                    break;
            }
            mp.x = Math.max(0, Math.min(maxX, mp.x));
            mp.y = Math.max(0, Math.min(maxY, mp.y));
            mp.repaint();
        }

        @Override
        public void run() {
            while (!flag) {
                try {
                    SwingUtilities.invokeAndWait(this::updateCircle);
                    Thread.sleep(mp.interval);
                } catch (InterruptedException e) {
                    return;
                } catch (InvocationTargetException e) {
                    throw new IllegalStateException(e.getCause());
                }
            }
        }
    }

    private final RandomC th;

    public exam_7() {
        super("실습 7번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel mp = new MyPanel();
        mp.x = mp.size;
        mp.y = mp.size;
        th = new RandomC(mp);

        mp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // 여러 번 클릭해도 스레드를 중복 생성하지 않는다.
                if (th.getState() == Thread.State.NEW) {
                    th.start();
                }
            }
        });
        // 창을 닫을 때 작업 스레드도 종료하도록 추가했던 코드이다.
        // 현재는 EXIT_ON_CLOSE가 JVM 전체를 종료하므로 반드시 필요한 코드는 아니다.
        // 기존 틀을 유지하기 위해 주석 처리한다.
        // 나중에 DISPOSE_ON_CLOSE로 바꾸면 창만 닫히고 작업 스레드는 계속 실행될 수 있다.
        // 그 경우 아래 리스너를 활성화하면 finish()가 종료 플래그를 설정하고,
        // interrupt()로 sleep 대기를 깨워 스레드가 종료되도록 한다.
        /*
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                th.finish();
            }
        });
        */

        createMenu();
        setContentPane(mp);
        setSize(300, 300);
        setVisible(true);
    }

    public void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu screenMenu = new JMenu("Mode");

        JMenuItem i1 = new JMenuItem("RandomMove");
        JMenuItem i2 = new JMenuItem("Move");
        JMenuItem i3 = new JMenuItem("FixedSize");
        JMenuItem i4 = new JMenuItem("VarSize");

        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);

        screenMenu.add(i1);
        screenMenu.add(i2);
        screenMenu.addSeparator();
        screenMenu.add(i3);
        screenMenu.add(i4);
        mb.add(screenMenu);
        setJMenuBar(mb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        th.changeMode(e.getActionCommand());
    }

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(exam_7::new);
    	new exam_7();
    }
}
