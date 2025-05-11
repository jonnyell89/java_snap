package snap;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.*;

public class Snap extends CardGame {

    protected ArrayList<Card> pile;

    public Snap(Player playerOne) {
        super("Snap: Single-player", playerOne);
        this.pile = new ArrayList<>();
    }

    public Snap(Player playerOne, Player playerTwo) {
        super("Snap: Multi-player", playerOne, playerTwo);
        this.pile = new ArrayList<>();
    }

    public ArrayList<Card> getPile() {
        return pile;
    }

    public Card getCurrentCard() {
        return pile.get(0);
    }

    public void addCardToPile(Card card) {
        pile.add(0, card);
    }

    public Card removeCardFromPile() {
        return pile.remove(0);
    }

    public Card getPreviousCard() {
        return pile.get(1);
    }

    public void addPileToDeck() {
        int pileSize = getPile().size();
        for (int i = 0; i < pileSize; i++) {
            addCardToDeck(removeCardFromPile());
        }
    }

    public void singlePlayerAddHandToPile() {
        int handSize = playerOne.getHand().size();
        for (int i = 0; i < handSize; i++) {
            addCardToPile(playerOne.playCard());
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

        while (!playerOne.getHand().isEmpty()) {
            boolean playerTurn = promptPlayerToPressEnter(playerOne);
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

    // Returns when player takes their turn: calls playerTakesTurn.
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

    // Returns true if player wins, otherwise returns false: calls turnLogic and promptSnapInput.
    public boolean playerTakesTurn(Player player) {
        player.incrementTurnCounter();
        Card playedCard = player.playCard();

        if (turnLogic(playedCard)) {
            if (promptSnapInput()) {
                player.incrementWinCounter();
                System.out.printf("\nCongratulations %s, you won the game in %d turns, and this was your %d%s win!\n", player.getName(), player.getTurnCounter(), player.getWinCounter(), player.nthWin());
                return true;
            }
            return false;
        }
        return false;
    }

    // Returns true if player wins, otherwise returns false: calls isSnap.
    public boolean turnLogic(Card playedCard) {
        if (getPile().isEmpty()) {
            playedCard.printCard();
            addCardToPile(playedCard);
            return false;
        }
        playedCard.printCard();
        addCardToPile(playedCard);

        // Winning Condition:
        return isSnap(getCurrentCard(), getPreviousCard());
    }

    public boolean promptSnapInput() {
        // Creates an ExecutorService object with a single thread to handle the snap input task.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Creates a separate Scanner object to read the result of the background thread.
        Scanner threadScanner = new Scanner(System.in);

        // Creates a Future contract to hold the result of the submitted background thread.
        Future<String> future = executor.submit(() -> {
            System.out.println("You have two seconds to type 'snap'!");
            return threadScanner.nextLine().trim().toLowerCase();
        });

        try {
            // Blocks the main thread and waits for user input from the background thread.
            String response = future.get(2, TimeUnit.SECONDS);
            // Returns true if the result of the Future contract is equal to "snap".
            return response.equals("snap");
            // Catches the two second TimeoutException.
        } catch (TimeoutException e) {
            System.out.println("You were too slow. The game continues...!");
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
