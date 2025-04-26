package snap;

public class Main {
    public static void main(String[] args) {

        CardGame cardGame = new CardGame();

        System.out.println(cardGame.getDeck());

        cardGame.printDeck();

        System.out.println(cardGame.name);

        System.out.println(cardGame.dealCard());

    }
}
