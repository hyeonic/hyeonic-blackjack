package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public interface Player {
    int WINNER_SCORE = 21;

    Name getName();
    void receive(Card card);
    Cards getCards();
    boolean isValidScore();
}