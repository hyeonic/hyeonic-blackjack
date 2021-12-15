package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public class Dealer implements Player {
    public static final String DEFAULT_NAME = "딜러";

    private final Cards cards;

    public Dealer() {
        this.cards = new Cards();
    }

    @Override
    public Name getName() {
        return new Name(DEFAULT_NAME);
    }

    @Override
    public void receive(Card card) {
        cards.include(card);
    }
}