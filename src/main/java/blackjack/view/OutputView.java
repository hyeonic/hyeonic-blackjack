package blackjack.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Name;
import blackjack.domain.player.Player;

public class OutputView {
    private static final String GUIDE_MESSAGE = "블랙잭 게임을 시작합니다.";
    private static final String NAMES_DELIMITER = ", ";
    private static final String INIT_MESSAGE_FORMAT = "\n%s 에게 카드 2장을 나누어 줍니다.\n";
    private static final String CURRENT_STATE_MESSAGE_FORMAT = "\n%s의 카드\n";

    private OutputView() {
    }

    public static void guide() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printInit(List<Player> players) {
        String names = players.stream()
            .map(Player::getName)
            .map(Name::toString)
            .collect(joining(NAMES_DELIMITER));

        System.out.printf(INIT_MESSAGE_FORMAT, names);
    }

    public static void printDealerCurrentState(Name dealerName, Card card) {
        System.out.printf(CURRENT_STATE_MESSAGE_FORMAT, dealerName);
        System.out.println(card);
    }

    public static void printGamerCurrentState(Player gamer) {
        System.out.printf(CURRENT_STATE_MESSAGE_FORMAT, gamer.getName());
        Cards cards = gamer.getCards();

        cards.getCards().forEach(System.out::println);
    }
}