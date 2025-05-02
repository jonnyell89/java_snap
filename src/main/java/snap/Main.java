package snap;

public class Main {

    public static void main(String[] args) {

        CardGame cardGame = new CardGame();

        System.out.println(cardGame.getDeck());

        // System.out.println(cardGame.name);

        // System.out.println(cardGame.dealCard());

        cardGame.sortDeckIntoValueOrder();

        cardGame.printDeck();

        cardGame.sortDeckIntoSuitOrder();

        cardGame.printDeck();

        cardGame.shuffleDeck();

        cardGame.printDeck();

    }
}
