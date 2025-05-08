package snap;

import java.util.Scanner;

public class CardGameRunner {

    Scanner input = new Scanner(System.in);

    public void runGameSelect() {

        while (true) {

            System.out.println("MAIN MENU");
            System.out.println("Which game would you like to play?");
            System.out.println("Press 1 for Snap");
            System.out.println("Press Q to Quit");

            String gameSelect = input.nextLine();

            switch (gameSelect) {
                case "1":
                    runPlayerSelect();
                    break;
                case "q":
                case "Q":
                    System.out.println("Shutting down...\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please press '1' to play, or 'Q' to quit.\n");
            }
        }
    }

    public void runPlayerSelect() {

        while (true) {

            System.out.println("Do you want to play Single-player Snap or Multi-player Snap?");
            System.out.println("Press 1 for Single-player");
            System.out.println("Press 2 for Multi-player");
            System.out.println("Press Q to return to the Main Menu");

            String playerSelect = input.nextLine();

            switch (playerSelect) {
                case "1":
                    runSinglePlayerSnap();
                    return;
                case "2":
                    runMultiPlayerSnap();
                case "q":
                case "Q":
                    System.out.println("Returning to the Main Menu...\n");
                    runGameSelect();
                    return;
                default:
                    System.out.println("Please press '1' for single-player, '2' for multi-player, or 'Q' to return to the Main Menu.\n");
            }
        }
    }

    public void runSinglePlayerSnap() {

        System.out.println("What is your name?");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        Snap singlePlayer = new Snap(player);

        singlePlayer.playSinglePlayerGame();

        singlePlayer.resetSinglePlayerGame();
        player.resetTurnCounter();

        runSinglePlayerPlayAgain(player);
    }

    public void runSinglePlayerSnap(Player player) {

        Snap singlePlayer = new Snap(player);

        singlePlayer.playSinglePlayerGame();

        singlePlayer.resetSinglePlayerGame();
        player.resetTurnCounter();

        runSinglePlayerPlayAgain(player);
    }

    public void runSinglePlayerPlayAgain(Player player) {

        while (true) {

            System.out.println("Would you like to play again?");
            System.out.println("Press Y for yes");
            System.out.println("Press N for no");

            String playAgain = input.nextLine();

            switch (playAgain) {
                case "y":
                case "Y":
                    runSinglePlayerSnap(player);
                    return;
                case "n":
                case "N":
                    System.out.printf("Thank you for playing, %s.\n", player.getName());
                    printWinnerWinCounter(player);
                    System.out.println("Returning to the Main Menu...\n");
                    runGameSelect();
                    return;
                default:
                    System.out.println("You must either press 'Y' to play again or 'N' to return to the Main Menu.\n");
            }
        }
    }

    public void runMultiPlayerSnap() {

        System.out.println("Player One: what is your name?");
        String playerOneName = input.nextLine();
        Player playerOne = new Player(playerOneName);

        System.out.println("Player Two: what is your name?");
        String playerTwoName = input.nextLine();
        Player playerTwo = new Player(playerTwoName);

        Snap multiPlayer = new Snap(playerOne, playerTwo);

        multiPlayer.playMultiPlayerGame();

        multiPlayer.resetMultiPlayerGame();
        playerOne.resetTurnCounter();
        playerTwo.resetTurnCounter();

        runMultiPlayerPlayAgain(playerOne, playerTwo);
    }

    public void runMultiPlayerSnap(Player playerOne, Player playerTwo) {

        Snap multiPlayer = new Snap(playerOne, playerTwo);

        multiPlayer.playMultiPlayerGame();

        multiPlayer.resetMultiPlayerGame();
        playerOne.resetTurnCounter();
        playerOne.resetTurnCounter();

        runMultiPlayerPlayAgain(playerOne, playerTwo);
    }

    public void runMultiPlayerPlayAgain(Player playerOne, Player playerTwo) {

        while (true) {

            System.out.println("Would you like to play again?");
            System.out.println("Press Y for yes");
            System.out.println("Press N for no");

            String playAgain = input.nextLine();

            switch (playAgain) {
                case "y":
                case "Y":
                    runMultiPlayerSnap(playerOne, playerTwo);
                    return;
                case "n":
                case "N":
                    System.out.printf("Thank you for playing, %s and %s.\n", playerOne.getName(), playerTwo.getName());
                    printMultiPlayerWinCounter(playerOne, playerTwo);
                    System.out.println("Returning to the Main Menu...\n");
                    runGameSelect();
                    return;
                default:
                    System.out.println("You must either press 'Y' to play again or 'N' to return to the Main Menu.\n");
            }
        }
    }

    public void printWinnerWinCounter(Player player) {
        if (player.getWinCounter() > 1) {
            System.out.printf("Congratulations, %s. You won %d games in total!\n", player.getName(), player.getWinCounter());
        }

        else if (player.getWinCounter() == 1) {
            System.out.printf("Congratulations, %s. You won %d game in total.\n", player.getName(), player.getWinCounter());
        }

        else {
            System.out.printf("Commiserations, %s. You won %d games in total.\n", player.getName(), player.getWinCounter());
        }
    }

    public void printLoserWinCounter(Player player) {
        if (player.getWinCounter() > 1) {
            System.out.printf("Commiserations, %s. You lost, but you still won %d games in total!\n", player.getName(), player.getWinCounter());
        }

        else if (player.getWinCounter() == 1) {
            System.out.printf("Commiserations, %s. You lost, but you still won %d game in total.\n", player.getName(), player.getWinCounter());
        }

        else {
            System.out.printf("Commiserations, %s. You lost, and you won %d games in total.\n", player.getName(), player.getWinCounter());
        }
    }

    public void printDrawWinCounter(Player playerOne, Player playerTwo) {
        if (playerOne.getWinCounter() > 1) {
            System.out.println("Well done, %s and %s! You both won %d games. It's a draw.");
        }

        else if (playerOne.getWinCounter() == 1) {
            System.out.println("Well done, %s and %s. You both won %d game. It's a draw. ");
        }

        else {
            System.out.println("Commiserations, %d and %d. You both won %d games.");
        }
    }

    public void printMultiPlayerWinCounter(Player playerOne, Player playerTwo) {
        if (playerOne.getWinCounter() > playerTwo.getWinCounter()) {
            printWinnerWinCounter(playerOne);
            printLoserWinCounter(playerTwo);
        }

        else if (playerTwo.getWinCounter() > playerOne.getWinCounter()) {
            printWinnerWinCounter(playerTwo);
            printLoserWinCounter(playerOne);
        }

        else {
            printDrawWinCounter(playerOne, playerTwo);
        }
    }
}
