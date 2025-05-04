package snap;

public class Main {

    public static void main(String[] args) {

        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Snap snap = new Snap(playerOne, playerTwo);

        System.out.println(snap.getDeck());

        System.out.println(snap.name);

        // snap.playGame();

        System.out.println(snap.deck.size());

        snap.splitDeck();

        snap.printDeck();

    }
}
