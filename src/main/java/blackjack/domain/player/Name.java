package blackjack.domain.player;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    public Name(Name name) {
        this.name = name.name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}