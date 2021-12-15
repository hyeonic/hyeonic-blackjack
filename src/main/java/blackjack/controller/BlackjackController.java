package blackjack.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Gamer;
import blackjack.domain.player.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {
    private static final int DEFAULT_INDEX = 0;
    private static final int INIT_DRAW_COUNT = 2;

    public void run() {
        OutputView.guide();
        Deck deck = new Deck();
        List<Player> players = getPlayers();

        initPhase(deck, players);
    }

    private List<Player> getPlayers() {
        return new ArrayList<>(Arrays.asList(new Dealer(), new Gamer(InputView.name())));
    }

    private void initPhase(Deck deck, List<Player> players) {
        OutputView.printInit(players);
        for (int i = DEFAULT_INDEX; i < INIT_DRAW_COUNT; i++) {
            distribute(deck, players);
        }

        for (Player player : players) {
            OutputView.printCurrentState(player);
        }
    }

    private void distribute(Deck deck, List<Player> players) {
        for (Player player : players) {
            Card card = deck.draw();
            player.receive(card);
        }
    }
}