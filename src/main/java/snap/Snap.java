package snap;

import java.util.ArrayList;
import java.util.Objects;

public class Snap extends CardGame {

    protected ArrayList<Card> pile;
    protected Card previousCard;
    protected Card currentCard;

    public Snap(Player player) {

        super("Snap: Single-player", player);
        this.pile = new ArrayList<>();
        this.previousCard = null;
        this.currentCard = null;

    }

    public Snap(Player playerOne, Player playerTwo) {

        super("Snap: Multi-player", playerOne, playerTwo);
        this.pile = new ArrayList<>();
        this.previousCard = null;
        this.currentCard = null;

    }

    public ArrayList<Card> getPile() {
        return pile;
    }

    public void setPile(ArrayList<Card> pile) {
        this.pile = pile;
    }

    public Card getPreviousCard() {
        return previousCard;
    }

    public void setPreviousCard(Card previousCard) {
        this.previousCard = previousCard;
    }

    public void addPreviousCardToPile(Card previousCard) {
        pile.add(previousCard);
        setPreviousCard(null);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public void addCurrentCardToPile(Card currentCard) {
        addCardToPile(currentCard);
        setCurrentCard(null);
    }

    public void addCardToPile(Card card) {
        pile.add(card);
    }

    public Card removeCardFromPile() {
        return pile.remove(0);
    }

    public void addPileToDeck() {
        int pileSize = getPile().size();
        for (int i = 0; i < pileSize; i++) {
            addCardToDeck(removeCardFromPile());
        }
    }

    public void singlePlayerAddHandToPile() {
        int handSize = player.getHand().size();
        for (int i = 0; i < handSize; i++) {
            addCardToPile(player.playCard());
        }
    }

    public void multiPlayerAddHandsToPile() {
        int playerOneHandSize = playerOne.getHand().size();
        int playerTwoHandSize = playerTwo.getHand().size();
        for (int i = 0; i < playerOneHandSize; i++) {
            addCardToPile(playerOne.playCard());
        }
        for (int i = 0; i < playerTwoHandSize; i++) {
            addCardToPile(playerTwo.playCard());
        }
    }

    public void singlePlayerResetGame() {
        singlePlayerAddHandToPile();
        addPileToDeck();
    }

    public void multiPlayerResetGame() {
        multiPlayerAddHandsToPile();
        addPileToDeck();
    }

    public boolean isSnap(Card currentCard, Card previousCard) {
        return Objects.equals(currentCard.getSymbol(), previousCard.getSymbol());
    }

    public void playSinglePlayerGame() {

        shuffleDeck();
        singlePlayerDealDeckToHand();

        while (!player.getHand().isEmpty()) {
            boolean playerTurn = promptPlayerTurn(player);
            if (playerTurn) {
                return;
            }
        }
        System.out.println("There are no cards left to deal: Game Over");
    }

    public void playMultiPlayerGame() {

        shuffleDeck();
        multiPlayerDealDeckToHands();

        while (!playerOne.getHand().isEmpty() && !playerTwo.getHand().isEmpty()) {

            boolean playerOneTurn = promptPlayerTurn(playerOne);
            if (playerOneTurn) {
                return;
            }

            boolean playerTwoTurn = promptPlayerTurn(playerTwo);
            if (playerTwoTurn) {
                return;
            }
        }
        System.out.println("There are no cards left to deal: Game Over");
    }

    // Returns true if player wins, otherwise returns false: calls isSnap.
    public boolean turnLogic(Card playedCard) {

        // Round 1:
        if (getPreviousCard() == null) {
            setPreviousCard(playedCard);
            getPreviousCard().printCard();
            return false;
        }

        setCurrentCard(playedCard);
        getCurrentCard().printCard();

        // Winning Condition:
        if (isSnap(getCurrentCard(), getPreviousCard())) {
            addCurrentCardToPile(getCurrentCard());
            addPreviousCardToPile(getPreviousCard());
            return true;
        }

        addPreviousCardToPile(getPreviousCard());
        setPreviousCard(getCurrentCard());

        return false;
    }

    // Returns true if player wins, otherwise returns false: calls turnLogic.
    public boolean playerTakesTurn(Player player) {

        player.incrementTurnCounter();
        Card playedCard = player.playCard();

        if (turnLogic(playedCard)) {
            System.out.printf("Congratulations %s, you won the game in %d turns!", player.getName(), player.getTurnCounter());
            return true;
        }
        return false;
    }

    // Returns true when player takes their turn: calls playerTakesTurn.
    public boolean promptPlayerTurn(Player player) {

        while (true) {

            System.out.printf("%s, press enter to deal a card: ", player.getName());
            String inputEnter = scanner.nextLine();

            if (inputEnter.isEmpty()) {
                return playerTakesTurn(player);

            } else {
                System.out.println("To deal a card, you must press enter.");

            }
        }
    }
}
