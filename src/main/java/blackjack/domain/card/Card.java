package blackjack.domain.card;

public class Card {
    private final Pattern pattern;
    private final Number number;

    public Card(Pattern pattern, Number number) {
        this.pattern = pattern;
        this.number = number;
    }

    public Card(Card card) {
        this.pattern = card.pattern;
        this.number = card.number;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return pattern + " " + number;
    }
}