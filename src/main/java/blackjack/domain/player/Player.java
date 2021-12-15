package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public interface Player {
    Name getName();
    void receive(Card card);
    Cards getCards();
}