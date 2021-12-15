package blackjack.domain.card;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> deck;

    public Deck() {
        generateCardDeck();
        Collections.shuffle(deck);
    }

    private void generateCardDeck() {
        this.deck = new LinkedList<>();

        for (Pattern pattern : Pattern.values()) {
            for (Number number : Number.values()) {
                deck.add(new Card(pattern, number));
            }
        }
    }

    public Card draw() {
        return new Card(deck.pollLast());
    }
}