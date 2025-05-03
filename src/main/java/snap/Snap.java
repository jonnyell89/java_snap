package snap;

import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {

    protected Card previousCard;
    protected Card currentCard;

    public Snap() {

        this.previousCard = null;
        this.currentCard = null;
        shuffleDeck();

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

    public void printCurrentCard() {
        System.out.println(this.currentCard);
    }

    public void playGame() {

        Scanner input = new Scanner(System.in);

        while (!cards.isEmpty()) {

            System.out.println("Press enter to deal a card: ");

            String inputEnter = input.nextLine();

            // User presses enter:
            if (inputEnter.isEmpty()) {

                Card dealtCard = dealCard();

                setCurrentCard(dealtCard);

                printCurrentCard();

                // Round 1:
                if (getPreviousCard() == null) {

                    setPreviousCard(getCurrentCard());

                    setCurrentCard(null);

                    continue;

                }

                // Winning condition:
                if (Objects.equals(getCurrentCard().getSymbol(), getPreviousCard().getSymbol())) {

                    System.out.println("Congratulations, you have won the game!");

                    return;

                }

                setPreviousCard(getCurrentCard());

            } else {

                System.out.println("To deal a card, you must press enter.");

            }

        }

        System.out.println("There are no cards left to deal: Game Over");

    }

}
