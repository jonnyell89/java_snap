package snap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    protected String name;

    // Contains the items to be assigned to the corresponding Card type fields.
    // private static final ArrayList<String> suits = new ArrayList<>(Arrays.asList("♥", "♣", "♦", "♠"));
    // private static final ArrayList<String> symbols = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
    // private static final ArrayList<Integer> values = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));

    // To contain all 52 playing cards.
    private ArrayList<Card> cards; // = new ArrayList<>();

    public CardGame() {
        this.name = "Snap";
        this.cards = generateDeck();
    }

    private ArrayList<Card> generateDeck() {
        cards = new ArrayList<>();
        // for (int i = 0; i < suits.size(); i++) {
        // for (String suit : suits) {
        for (Suit suit : Suit.values()) {
            // for (int j = 0; j < values.size(); j++) {
            for (Rank rank : Rank.values()) {
                // Card card = new Card(suit, symbols.get(j), values.get(j));
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }

    public void printDeck() {
        // for (int i = 0; i < cards.size(); i++) {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public Card dealCard() {
        // Returns the last item in the array list, or the top card in the deck.
        return cards.get(cards.size() - 1);
    }

    public void sortDeckIntoValueOrder() {
        Comparator<Card> compareBySuit = Comparator.comparing(c -> c.getValue());
        cards.sort(Comparator.comparing(Card::getValue));
        // cards.sort((card1, card2) -> Integer.compare(card1.getValue(), card2.getValue()));
    }

    public void sortDeckIntoSuitOrder() {
        Comparator<Card> compareBySuit = Comparator.comparing(c -> c.getSuit());
        Comparator<Card> compareByValue = Comparator.comparing(c -> c.getValue());
        Comparator<Card> cardComparator = compareBySuit.thenComparing(compareByValue);
        // Comparator<Card> cardComparator = Comparator.comparing(Card::getSuit).thenComparing(Card::getValue);
        cards.sort(cardComparator);
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

}
