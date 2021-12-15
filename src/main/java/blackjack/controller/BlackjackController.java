package blackjack.controller;

import java.util.Arrays;

import blackjack.domain.Rule;
import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
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
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer(InputView.name());

        initPhase(deck, dealer, gamer);
        if (dealer.isWinner()) {
            OutputView.printWinner(dealer.getName());
            return;
        }

        playPhase(deck, dealer, gamer);
    }

    private void initPhase(Deck deck, Dealer dealer, Player gamer) {
        OutputView.printInit(dealer.getName(), gamer.getName());
        for (int i = DEFAULT_INDEX; i < INIT_DRAW_COUNT; i++) {
            distribute(deck, dealer);
            distribute(deck, gamer);
        }

        printCurrentState(dealer, gamer);
    }


    private void playPhase(Deck deck, Dealer dealer, Player gamer) {
        playGamerTurn(deck, dealer, gamer);
        playDealerTurn(deck, dealer, gamer);

        if (checkValid(dealer, gamer)) {
            return;
        }

        Rule rule = new Rule();
        Player winner = rule.getWinner(Arrays.asList(dealer, gamer));
        OutputView.printWinner(winner.getName());
    }

    private boolean checkValid(Dealer dealer, Player gamer) {
        if (checkTie(dealer, gamer)) {
            return true;
        }

        if (!dealer.isValidScore()) {
            OutputView.printWinner(gamer.getName());
            return true;
        }

        if (!gamer.isValidScore()) {
            OutputView.printWinner(dealer.getName());
            return true;
        }
        return false;
    }

    private boolean checkTie(Dealer dealer, Player gamer) {
        if (!dealer.isValidScore() && !gamer.isValidScore()) {
            OutputView.printTie();
            return true;
        }
        return false;
    }

    private void playGamerTurn(Deck deck, Dealer dealer, Player gamer) {
        while (InputView.isTurn(gamer.getName())) {
            distribute(deck, gamer);
            printCurrentState(dealer, gamer);
        }
    }

    private void playDealerTurn(Deck deck, Dealer dealer, Player gamer) {
        while (dealer.isDraw()) {
            distribute(deck, dealer);
            printFinalState(dealer, gamer);
        }
    }

    private void distribute(Deck deck, Player player) {
        Card card = deck.draw();
        player.receive(card);
    }

    private void printCurrentState(Dealer dealer, Player gamer) {
        OutputView.printDealerCurrentState(dealer.getName(), dealer.openDefaultCard(), dealer.getDefaultScore());

        Cards cards = gamer.getCards();
        OutputView.printGamerCurrentState(gamer, cards.getTotalScore());
    }

    private void printFinalState(Dealer dealer, Player gamer) {
        Cards dealerCards = dealer.getCards();
        OutputView.printGamerCurrentState(dealer, dealerCards.getTotalScore());

        Cards gamerCards = gamer.getCards();
        OutputView.printGamerCurrentState(gamer, gamerCards.getTotalScore());
    }
}