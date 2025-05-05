package snap;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnapTest {

    @Test
    void testSnapInitialisesCorrectly() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        assertNotNull(snap);
        assertEquals(52, snap.getDeck().size());

    }

    @Test
    void testDeckGeneratedHeartsCorrectlyUsingStream() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        Stream<Card> cardStream = snap.getDeck().stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.HEARTS.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testDeckGeneratedClubsCorrectlyUsingStream() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        Stream<Card> cardStream = snap.getDeck().stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.CLUBS.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testDeckGeneratedDiamondsCorrectlyUsingStream() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        Stream<Card> cardStream = snap.getDeck().stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.DIAMONDS.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testDeckGeneratedSpadesCorrectlyUsingStream() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        Stream<Card> cardStream = snap.getDeck().stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.SPADES.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testIsSnapReturnsTrueCorrectly() {
        Player player = new Player("Player");
        Card currentCard = new Card(Suit.HEARTS, Rank.NINE);
        Card previousCard = new Card(Suit.DIAMONDS, Rank.NINE);
        Snap snap = new Snap(player);

        assertTrue(snap.isSnap(currentCard, previousCard));

    }

    @Test
    void testIsSnapReturnsFalseCorrectly() {
        Player player = new Player("Player");
        Card currentCard = new Card(Suit.CLUBS, Rank.THREE);
        Card previousCard = new Card(Suit.SPADES, Rank.QUEEN);
        Snap snap = new Snap(player);

        assertFalse(snap.isSnap(currentCard, previousCard));

    }

    @Test
    void testSplitDeckSplitsTheDeckCorrectly() {
        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Snap snap = new Snap(playerOne, playerTwo);

        snap.multiPlayerDealDeckToHands();

        assertEquals(26, playerOne.getHand().size());
        assertEquals(26, playerTwo.getHand().size());
        assertEquals(0, snap.getDeck().size());

    }

}
