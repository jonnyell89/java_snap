package snap;

import java.util.ArrayList;
import java.util.Arrays;

public class CardGame {

    protected String name;

    // Contains the items to be assigned to the corresponding Card type fields.
    private static final ArrayList<String> suits = new ArrayList<>(Arrays.asList("♥", "♣", "♦", "♠"));
    private static final ArrayList<String> symbols = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
    private static final ArrayList<Integer> values = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));

    // To contain all 52 playing cards.
    private ArrayList<Card> cards = new ArrayList<>();

    public CardGame() {

        this.name = "Snap";
        generateDeck();

    }

    private void generateDeck() {
        for (int i = 0; i < suits.size(); i++) {
            for (int j = 0; j < symbols.size(); j++) {
                Card card = new Card(suits.get(i), symbols.get(j), values.get(j));
                cards.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }

    public void printDeck() {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            System.out.println(card.toString());
        }
    }

    public Card dealCard() {
        // Returns the last item in the array list, or the top card in the deck.
        return cards.get(cards.size() - 1);
    }

    public void sortDeckIntoValueOrder() {
        cards.sort(null);
    }
}
