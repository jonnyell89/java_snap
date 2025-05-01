package snap;

public enum Suit {

    HEARTS("♥"),
    CLUBS("♣"),
    DIAMONDS("♦"),
    SPADES("♠");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "suit='" + suit + '\'' +
                '}';
    }
}
