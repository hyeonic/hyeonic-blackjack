package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void include(Card card) {
        cards.add(card);
    }
}