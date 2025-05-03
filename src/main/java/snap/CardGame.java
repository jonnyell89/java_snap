package snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    protected String name;

    protected ArrayList<Card> cards;

    public CardGame() {

        this.name = "Snap";
        this.cards = generateDeck();

    }

    private ArrayList<Card> generateDeck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }

    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public Card dealCard() {
        return cards.remove(cards.size() - 1);
    }

    public void sortDeckIntoValueOrder() {
        cards.sort(Comparator.comparing(Card::getValue));
    }

    public void sortDeckIntoSuitOrder() {
//        Comparator<Card> compareBySuit = Comparator.comparing(Card::getSuit);
//        Comparator<Card> compareByValue = Comparator.comparing(Card::getValue);
//        Comparator<Card> cardComparator = compareBySuit.thenComparing(compareByValue);
        Comparator<Card> cardComparator = Comparator.comparing(Card::getSuit).thenComparing(Card::getValue);
        cards.sort(cardComparator);
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

}
