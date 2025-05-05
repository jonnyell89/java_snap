package snap;

import java.util.Objects;

public class Snap extends CardGame {

    protected Card previousCard;
    protected Card currentCard;

    public Snap() {

        super("Snap");
        this.previousCard = null;
        this.currentCard = null;

    }

    public Snap(Player playerOne, Player playerTwo) {

        super("Snap", playerOne, playerTwo);
        this.previousCard = null;
        this.currentCard = null;

    }

    public Card getPreviousCard() {
        return previousCard;
    }

    public void setPreviousCard(Card previousCard) {
        this.previousCard = previousCard;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public boolean isSnap(Card currentCard, Card previousCard) {
        return Objects.equals(currentCard.getSymbol(), previousCard.getSymbol());
    }

    public void playGame() {

        shuffleDeck();

        int enterCount = 0;

        while (!deck.isEmpty()) {

            System.out.println("Press enter to deal a card: ");
            String inputEnter = scanner.nextLine();

            if (inputEnter.isEmpty()) {

                enterCount++;

                Card dealtCard = dealCard();

                // Round 1:
                if (getPreviousCard() == null) {
                    setPreviousCard(dealtCard);
                    getPreviousCard().printCard();
                    continue;
                }

                setCurrentCard(dealtCard);
                getCurrentCard().printCard();

                // Winning Condition:
                if (isSnap(getCurrentCard(), getPreviousCard())) {
                    System.out.printf("Congratulations, you won the game in %d turns!", enterCount);
                    return;
                }

                setPreviousCard(getCurrentCard());

            } else {

                System.out.println("To deal a card, you must press enter.");

            }
        }

        System.out.println("There are no cards left to deal: Game Over");

    }

    public void playTwoPlayerGame() {

        shuffleDeck();

        splitDeck();

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

    // Returns true if player wins, otherwise returns false. Calls isSnap.
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
            return true;
        }

        setPreviousCard(getCurrentCard());

        return false;

    }

    // Returns true if player wins, otherwise returns false. Calls turnLogic.
    public boolean playerTakesTurn(Player player) {

        player.incrementTurnCounter();

        Card playedCard = player.playCard();

        if (turnLogic(playedCard)) {
            System.out.printf("Congratulations %s, you won the game in %d turns!", player.getName(), player.getTurnCounter());
            return true;
        }

        return false;

    }

    // Returns when player takes their turn, calls playerTakesTurn.
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
