package blackjack.domain.player;

import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public class Dealer implements Player {
    private static final String DEFAULT_NAME = "딜러";
    public static final int DEFAULT_CARDS_INDEX = 0;

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

    @Override
    public Cards getCards() {
        return new Cards(cards);
    }

    public Card openDefaultCard() {
        List<Card> cards = this.cards.getCards();
        return new Card(cards.get(DEFAULT_CARDS_INDEX));
    }
}