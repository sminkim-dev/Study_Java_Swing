package chapter_11.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class exam_12 extends JFrame{
	private CardLabel[] cards = new CardLabel[12];

    private Player[] players = {
        new Player("황기태"),
        new Player("이재문")
    };

    private JLabel titleLabel =
            new JLabel("2장의 동일 번호 카드 찾기", SwingConstants.CENTER);

    private JLabel lastLabel = new JLabel("마지막: ");

    private CardLabel firstCard = null; // 먼저 선택한 카드
    private int turn = 0;               // 현재 선수: 0 또는 1
    private int matchedPairs = 0;       // 맞힌 카드 쌍의 개수
	public exam_12() {
		super("카드 찾기 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout(0, 5));

        // 위쪽 제목
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.YELLOW);
        c.add(titleLabel, BorderLayout.NORTH);

        // 가운데 카드: 4행 3열
        JPanel cardPanel = new JPanel(new GridLayout(4, 3, 8, 8));
        cardPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 30, 5, 30));

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new CardLabel();
            cardPanel.add(cards[i]);
        }

        c.add(cardPanel, BorderLayout.CENTER);

        // 아래쪽 선수 점수와 마지막 카드 번호
        JPanel infoPanel = new JPanel(new GridLayout(1, 3));
        infoPanel.setBackground(Color.YELLOW);

        infoPanel.add(players[0].label);
        infoPanel.add(players[1].label);
        infoPanel.add(lastLabel);

        c.add(infoPanel, BorderLayout.SOUTH);

        startGame();

        setSize(380, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 카드를 섞고 새 게임 시작
	private void startGame() {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int number = 1; number <= 6; number++) {
            numbers.add(number);
            numbers.add(number); // 같은 숫자 두 장씩
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < cards.length; i++) {
            cards[i].number = numbers.get(i);
            cards[i].showBack();
            cards[i].setVisible(true);
        }

        firstCard = null;
        turn = 0;
        matchedPairs = 0;

        for (Player player : players) {
            player.score = 0;
        }

        updatePlayers();
    }

    // 점수와 현재 차례 표시
    private void updatePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i].label.setText(
                    players[i].name + " " + players[i].score);

            players[i].label.setForeground(
                    i == turn ? Color.RED : Color.BLACK);
        }
    }

    // 카드 클릭 처리
    private void selectCard(CardLabel selected) {
        // 첫 번째 카드를 다시 클릭하면 무시
        if (selected == firstCard || !selected.isVisible()) {
            return;
        }

        selected.showFront();

        // 이번 시도의 첫 번째 카드
        if (firstCard == null) {
            firstCard = selected;
            return;
        }

        // 이번 시도의 두 번째 카드
        lastLabel.setText("마지막: " + selected.number);

        if (firstCard.number == selected.number) {
            players[turn].score++;
            matchedPairs++;

            // 맞힌 카드는 자리만 남기고 숨김
            firstCard.setVisible(false);
            selected.setVisible(false);
        } else {
            // 틀리면 다시 뒷면으로 표시
            firstCard.showBack();
            selected.showBack();
        }

        firstCard = null;

        if (matchedPairs == 6) {
            finishGame();
        } else {
            turn = 1 - turn; // 0 → 1, 1 → 0
            updatePlayers();
        }
    }

    // 승자를 표시하고 다음 게임 시작
    private void finishGame() {
        String result;

        if (players[0].score > players[1].score) {
            result = "승자: " + players[0].name;
        } else if (players[0].score < players[1].score) {
            result = "승자: " + players[1].name;
        } else {
            result = "비겼음";
        }

        titleLabel.setText("2장의 동일 번호 카드 찾기 / " + result);

        startGame();
    }

    // 카드 한 장
    private class CardLabel extends JLabel {
        private int number;

        public CardLabel() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setOpaque(true);
            setFont(new Font("SansSerif", Font.BOLD, 25));
            setBorder(BorderFactory.createLineBorder(Color.GRAY));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectCard(CardLabel.this);
                }
            });
        }

        public void showFront() {
            setText(String.valueOf(number));
            setBackground(new Color(150, 210, 40));
            setForeground(Color.BLACK);
        }

        public void showBack() {
            setText("◆");
            setBackground(new Color(40, 50, 90));
            setForeground(Color.WHITE);
        }
    }

    // 선수 한 명
    private class Player {
        private String name;
        private int score;
        private JLabel label = new JLabel();

        public Player(String name) {
            this.name = name;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exam_12();
	}

}
