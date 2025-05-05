package snap;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to my Java Card Game project!");
            System.out.println("Which game would you like to play?");
            System.out.println("Press 1 for Snap");
            System.out.println("Press Q to Quit");

            String gameSelect = input.nextLine();

            if (gameSelect.equals("1")) {

                System.out.println("Do you want to play Single-player Snap or Multi-player Snap?");
                System.out.println("Press 1 for Single-player");
                System.out.println("Press 2 for Multi-player");
                System.out.println("Press Q to quit");

                String playerSelect = input.nextLine();

                if (playerSelect.equals("1")) {

                    System.out.println("What is your name?");
                    String playerName = input.nextLine();
                    Player player = new Player(playerName);

                    Snap singlePlayer = new Snap(player);

                    singlePlayer.playSinglePlayerGame();

                    singlePlayer.singlePlayerAddHandToPile();

                    singlePlayer.addPileToDeck();

                }

                if (playerSelect.equals("2")) {

                    System.out.println("Player One: what is your name?");
                    String playerOneName = input.nextLine();
                    Player playerOne = new Player(playerOneName);

                    System.out.println("Player Two: what is your name?");
                    String playerTwoName = input.nextLine();
                    Player playerTwo = new Player(playerTwoName);

                    Snap multiPlayer = new Snap(playerOne, playerTwo);

                    multiPlayer.playMultiPlayerGame();

                    multiPlayer.multiPlayerAddHandsToPile();

                    multiPlayer.addPileToDeck();

                }

                if (playerSelect.equals("q") || playerSelect.equals("Q")) {
                    System.exit(0);
                }

            }

            if (gameSelect.equals("q") || gameSelect.equals("Q")) {
                System.exit(0);
            }

        }
    }
}
