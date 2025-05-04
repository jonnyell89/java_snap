package snap;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to my Java Card Game project!");
        System.out.println("Which game would you like to play?");
        System.out.println("Press 1 for Snap");
        System.out.println("Press Q to Quit");

        String gameSelect = input.nextLine();

        if (gameSelect.equals("1")) {

            System.out.println("How many players are playing?");
            System.out.println("Press 1 for one");
            System.out.println("Press 2 for two");
            System.out.println("Press Q to quit");

            String playerSelect = input.nextLine();

            if (playerSelect.equals("1")) {

                Snap snapOnePlayer = new Snap();
                snapOnePlayer.playGame();

            }

            if (playerSelect.equals("2")) {

                System.out.println("Player One: what is your name?");
                String playerOneName = input.nextLine();
                Player playerOne = new Player(playerOneName);

                System.out.println("Player Two: what is your name?");
                String playerTwoName = input.nextLine();
                Player playerTwo = new Player(playerTwoName);

                Snap snapTwoPlayer = new Snap(playerOne, playerTwo);

                snapTwoPlayer.playGame();

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
