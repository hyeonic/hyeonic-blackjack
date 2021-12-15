package blackjack.controller;

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
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer(InputView.name());

        initPhase(deck, dealer, gamer);
    }

    private void initPhase(Deck deck, Dealer dealer, Player gamer) {
        for (int i = DEFAULT_INDEX; i < INIT_DRAW_COUNT; i++) {
            distribute(deck, dealer);
            distribute(deck, gamer);
        }

        printCurrentState(dealer, gamer);
    }

    private void distribute(Deck deck, Player player) {
        Card card = deck.draw();
        player.receive(card);
    }

    private void printCurrentState(Dealer dealer, Player gamer) {
        OutputView.printDealerCurrentState(dealer.getName(), dealer.openDefaultCard());
        OutputView.printGamerCurrentState(gamer);
    }
}