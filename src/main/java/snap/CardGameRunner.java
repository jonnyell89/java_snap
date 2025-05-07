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
                    System.out.println("Shutting down...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please press '1' to play, or 'Q' to quit.");
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
                    break;
                case "2":
                    runMultiPlayerSnap();
                case "q":
                case "Q":
                    System.out.println("Returning to the Main Menu...");
                    runGameSelect();
                    break;
                default:
                    System.out.println("Please press '1' for single-player, '2' for multi-player, or 'Q' to return to the Main Menu.");
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
                    break;
                case "n":
                case "N":
                    System.out.printf("Thank you for playing, %s.\n", player.getName());
                    System.out.printf("You won %d game/s in total!\n", player.getWinCounter());
                    System.out.println("Returning to the Main Menu...\n");
                    runGameSelect();
                    break;
                default:
                    System.out.println("You must either press 'Y' to play again or 'N' to return to the Main Menu.");
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
                    break;
                case "n":
                case "N":
                    System.out.printf("Thank you for playing, %s and %s.\n", playerOne.getName(), playerTwo.getName());
                    System.out.printf("%s, you won %d game/s in total!\n", playerOne.getName(), playerOne.getWinCounter());
                    System.out.printf("%s, you won %d game/s in total!\n", playerTwo.getName(), playerTwo.getWinCounter());
                    System.out.println("Returning to the Main Menu...\n");
                    runGameSelect();
                    break;
                default:
                    System.out.println("You must either press 'Y' to play again or 'N' to return to the Main Menu.");
            }
        }
    }
}
