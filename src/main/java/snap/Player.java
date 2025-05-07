package snap;

import java.util.ArrayList;

public class Player {

    protected String name;
    protected ArrayList<Card> hand;
    protected int turnCounter;
    protected  int winCounter;

    public Player(String name) {

        this.name = name;
        this.hand = new ArrayList<>();
        this.turnCounter = 0;
        this.winCounter = 0;

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

    public void resetTurnCounter() {
        this.turnCounter = 0;
    }

    public void incrementTurnCounter() {
        this.turnCounter++;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public void incrementWinCounter() {
        this.winCounter++;
    }

    public String nthWin() {
        if (getWinCounter() == 1) {
            return "st";
        }
        if (getWinCounter() == 2) {
            return "nd";
        }
        if (getWinCounter() == 3) {
            return "rd";
        }
        return "th";
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        return hand.remove(0);
    }
}
