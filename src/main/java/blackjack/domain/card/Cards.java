package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public Cards(Cards cards) {
        this.cards = new ArrayList<>(cards.getCards());
    }

    public void include(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int getTotalScore() {
        return cards.stream()
            .map(Card::getNumber)
            .mapToInt(Number::getScore)
            .sum();
    }
}