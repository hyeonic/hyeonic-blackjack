package blackjack.domain.player;

public class Gamer {
    private final Name name;

    public Gamer(String name) {
        this.name = new Name(name);
    }
}