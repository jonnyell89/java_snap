package snap;

public class Card {

    protected String suit;
    protected String symbol;
    protected int value;

    public Card(String suit, String symbol, int value) {

        this.suit = suit;
        this.symbol = symbol;
        this.value = value;

    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                '}';
    }
}
