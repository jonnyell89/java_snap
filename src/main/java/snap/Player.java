package snap;

import java.util.ArrayList;

public class Player {

    protected String name;
    protected ArrayList<Card> hand;
    protected int turnCounter;

    public Player(String name) {

        this.name = name;
        this.hand = new ArrayList<>();
        this.turnCounter = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public void incrementTurnCounter() {
        this.turnCounter++;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        return hand.remove(0);
    }
}
