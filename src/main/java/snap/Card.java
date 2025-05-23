package snap;

public class Card {

    protected String suit;
    protected String symbol;
    protected int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit.getSuit();
        this.symbol = rank.getSymbol();
        this.value = rank.getValue();
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void printCard() {
        System.out.println(this);
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
