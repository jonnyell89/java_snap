package snap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to my Java Card Game project!");

        while (true) {

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

                    System.out.println("Would you like to play again?");
                    System.out.println("Press Y for yes");
                    System.out.println("Press N for no");

                    String playAgain = input.nextLine();

                    while (true) {
                        if (playAgain.equals("y") || playAgain.equals("Y")) {
                            singlePlayer.resetSinglePlayerGame();
                            break;
                        } else if (playAgain.equals("n") || playAgain.equals("N")) {
                            System.exit(0);
                        } else {
                            System.out.println("You must either press 'Y' to play again or 'N' to quit.");
                        }
                    }
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

                    System.out.println("Would you like to play again?");
                    System.out.println("Press Y for yes");
                    System.out.println("Press N for no");

                    String playAgain = input.nextLine();

                    while (true) {
                        if (playAgain.equals("y") || playAgain.equals("Y")) {
                            multiPlayer.resetMultiPlayerGame();
                            break;
                        } else if (playAgain.equals("n") || playAgain.equals("N")) {
                            System.exit(0);
                        } else {
                            System.out.println("You must either press 'Y' to play again or 'N' to quit.");
                        }
                    }
                }

                if (playerSelect.equals("q") || playerSelect.equals("Q")) {
                    System.exit(0);
                }

            }

            if (gameSelect.equals("q") || gameSelect.equals("Q")) {
                System.exit(0);
            }

            else {
                System.out.println("You must either press '1' to play Snap or 'Q' to quit.");
            }
        }
    }
}
