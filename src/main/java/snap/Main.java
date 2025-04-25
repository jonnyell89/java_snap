package snap;

public class Main {
    public static void main(String[] args) {

        CardGame cardGame = new CardGame();

        cardGame.generateDeck();

        cardGame.getDeck();

        System.out.println(cardGame.name);

    }
}
