package snap;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.*;

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

    public Card getPreviousCard() {
        return previousCard;
    }

    public void setPreviousCard(Card previousCard) {
        this.previousCard = previousCard;
    }

    public void addPreviousCardToPile() {
        addCardToPile(getPreviousCard());
        setPreviousCard(null);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public void addCurrentCardToPile() {
        addCardToPile(getCurrentCard());
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

    public void resetSinglePlayerGame() {
        singlePlayerAddHandToPile();
        addPileToDeck();
    }

    public void resetMultiPlayerGame() {
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
            boolean playerTurn = promptPlayerToPressEnter(player);
            if (playerTurn) {
                return;
            }
        }
        System.out.println("There are no cards left to deal: Game Over\n");
    }

    public void playMultiPlayerGame() {

        shuffleDeck();
        multiPlayerDealDeckToHands();

        while (!playerOne.getHand().isEmpty() && !playerTwo.getHand().isEmpty()) {

            boolean playerOneTurn = promptPlayerToPressEnter(playerOne);
            if (playerOneTurn) {
                return;
            }

            boolean playerTwoTurn = promptPlayerToPressEnter(playerTwo);
            if (playerTwoTurn) {
                return;
            }
        }
        System.out.println("There are no cards left to deal: Game Over\n");
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
            addCurrentCardToPile();
            addPreviousCardToPile();
            return true;
        }

        addPreviousCardToPile();
        setPreviousCard(getCurrentCard());

        return false;
    }

    // Returns true if player wins, otherwise returns false: calls turnLogic.
    public boolean playerTakesTurn(Player player) {

        player.incrementTurnCounter();
        Card playedCard = player.playCard();

        if (turnLogic(playedCard)) {
            player.incrementWinCounter();
            System.out.printf("\nCongratulations %s, you won the game in %d turns, and this was your %d%s win!\n", player.getName(), player.getTurnCounter(), player.getWinCounter(), player.nthWin());
            return true;
        }
        return false;
    }

    // Returns true when player takes their turn: calls playerTakesTurn.
    public boolean promptPlayerToPressEnter(Player player) {

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

    // Unable to integrate into the game in time
    public boolean promptSnapInput() {
        // Creates an ExecutorService object with a single thread to handle the snap input task.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Creates a Future contract to hold the result of the submitted background thread.
        Future<String> future = executor.submit(() -> {
            System.out.println("You have two seconds to type 'snap', or you lose the game!");
            return scanner.nextLine().trim().toLowerCase();
        });

        try {
            // Blocks the main thread and waits for user input from the background thread.
            String response = future.get(2, TimeUnit.SECONDS);
            // Returns true if the result of the Future contract is equal to "snap".
            return response.equals("snap");
            // Catches the two second TimeoutException.
        } catch (TimeoutException e) {
            System.out.println("You were too slow. I'm afraid you lose the game!");
            // Catches any other Exception.
        } catch (Exception e) {
            System.out.println("Something went wrong");
            // The background thread is always shut down.
        } finally {
            executor.shutdownNow();
        }
        // Returns false if the user was too slow or the result of the Future contract was not equal to "snap".
        return false;
    }
}
