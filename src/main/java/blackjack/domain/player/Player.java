package blackjack.domain.player;

import blackjack.domain.card.Card;

public interface Player {
    Name getName();
    void receive(Card card);
}