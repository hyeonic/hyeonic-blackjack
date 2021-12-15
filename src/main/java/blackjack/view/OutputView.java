package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Name;
import blackjack.domain.player.Player;

public class OutputView {
    private static final String GUIDE_MESSAGE = "블랙잭 게임을 시작합니다.";
    private static final String INIT_MESSAGE_FORMAT = "\n%s와 %s 에게 카드 2장을 나누어 줍니다.\n";
    private static final String CURRENT_STATE_MESSAGE_FORMAT = "\n%s의 카드\n";
    private static final String CURRENT_SCORE_MESSAGE_FORMAT = "현재 점수: %d\n";

    private OutputView() {
    }

    public static void guide() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printInit(Name dealerName, Name playerName) {
        System.out.printf(INIT_MESSAGE_FORMAT, dealerName, playerName);
    }

    public static void printDealerCurrentState(Name dealerName, Card card, int score) {
        System.out.printf(CURRENT_STATE_MESSAGE_FORMAT, dealerName);
        System.out.println(card);
        System.out.printf(CURRENT_SCORE_MESSAGE_FORMAT, score);
    }

    public static void printGamerCurrentState(Player gamer, int totalScore) {
        System.out.printf(CURRENT_STATE_MESSAGE_FORMAT, gamer.getName());
        Cards cards = gamer.getCards();

        cards.getCards().forEach(System.out::println);
        System.out.printf(CURRENT_SCORE_MESSAGE_FORMAT, totalScore);
    }
}