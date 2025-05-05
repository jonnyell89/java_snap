package snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public abstract class CardGame {

    protected final Scanner scanner;

    protected String name;
    protected ArrayList<Card> deck;
    protected Player playerOne;
    protected Player playerTwo;

    public CardGame(String name) {

        this.name = name;
        this.deck = generateDeck();
        this.scanner = new Scanner(System.in);

    }

    public CardGame(String name, Player playerOne, Player playerTwo) {

        this.name = name;
        this.deck = generateDeck();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scanner = new Scanner(System.in);

    }

    private ArrayList<Card> generateDeck() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card.toString());
        }
    }

    public void splitDeck() {
        int deckSize = deck.size();
        for (int i = 0; i < deckSize; i++) {
            if (!(i % 2 == 0)) {
                playerOne.addCardToHand(dealCard());
            } else {
                playerTwo.addCardToHand(dealCard());
            }
        }
    }

    public void resetDeck() {
        int playerOneHandSize = playerOne.getHand().size();
        int playerTwoHandSize = playerTwo.getHand().size();
        for (int i = 0; i < playerOneHandSize; i++) {
            addCardToDeck(playerOne.playCard());
        }
        for (int i = 0; i < playerTwoHandSize; i++) {
            addCardToDeck(playerTwo.playCard());
        }
    }

    public Card dealCard() {
        return deck.remove(0);
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public void sortDeckIntoValueOrder() {
        deck.sort(Comparator.comparing(Card::getValue));
    }

    public void sortDeckIntoSuitOrder() {
        Comparator<Card> cardComparator = Comparator.comparing(Card::getSuit).thenComparing(Card::getValue);
        deck.sort(cardComparator);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

}
