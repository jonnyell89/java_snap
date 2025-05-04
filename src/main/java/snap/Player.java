package snap;

import java.util.ArrayList;

public class Player {

    protected String name;
    protected ArrayList<Card> hand;

    public Player(String name) {

        this.name = name;
        this.hand = new ArrayList<>();

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

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        return hand.remove(0);
    }

}
