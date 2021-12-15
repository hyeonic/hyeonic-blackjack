package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public class Gamer implements Player {
    private final Name name;
    private final Cards cards;

    public Gamer(String name) {
        this.name = new Name(name);
        this.cards = new Cards();
    }

    @Override
    public Name getName() {
        return new Name(name);
    }

    @Override
    public void receive(Card card) {
        cards.include(card);
    }

    @Override
    public Cards getCards() {
        return new Cards(cards);
    }

    @Override
    public boolean isValidScore() {
        return cards.getTotalScore() <= WINNER_SCORE;
    }
}