package snap;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnapTest {

    @Test
    void testSinglePlayerSnapInitialisesCorrectly() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        assertEquals("Snap: Single-player", snap.getName());
        assertEquals("Player", player.getName());
        assertEquals(52, snap.getDeck().size());
        assertTrue(snap.getPile().isEmpty());
        assertTrue(player.getHand().isEmpty());

        Set<Card> deckSet = new HashSet<>(snap.getDeck());
        assertEquals(snap.getDeck().size(), deckSet.size());
    }

    @Test
    void testMultiPlayerSnapInitialisesCorrectly() {
        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Snap snap = new Snap(playerOne, playerTwo);

        assertEquals("Snap: Multi-player", snap.getName());
        assertEquals("playerOne", playerOne.getName());
        assertEquals("playerTwo", playerTwo.getName());
        assertEquals(52, snap.getDeck().size());
        assertTrue(snap.getPile().isEmpty());
        assertTrue(playerOne.getHand().isEmpty());
        assertTrue(playerTwo.getHand().isEmpty());

        Set<Card> deckSet = new HashSet<>(snap.getDeck());
        assertEquals(snap.getDeck().size(), deckSet.size());
    }

    @Test
    void testSinglePlayerDealDeckToHand() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        snap.singlePlayerDealDeckToHand();

        assertTrue(snap.getDeck().isEmpty());
        assertEquals(52, player.getHand().size());
    }

    @Test
    void testMultiPlayerDealDeckToHands() {
        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Snap snap = new Snap(playerOne, playerTwo);

        snap.multiPlayerDealDeckToHands();

        assertTrue(snap.getDeck().isEmpty());
        assertEquals(26, playerOne.getHand().size());
        assertEquals(26, playerTwo.getHand().size());
    }

    @Test
    void testSinglePlayerHandAddedToPile() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        snap.singlePlayerDealDeckToHand();
        snap.singlePlayerAddHandToPile();

        assertTrue(player.getHand().isEmpty());
        assertEquals(52, snap.getPile().size());
        assertTrue(snap.getDeck().isEmpty());
    }

    @Test
    void testMultiPlayerHandAddedToPile() {
        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Snap snap = new Snap(playerOne, playerTwo);

        snap.multiPlayerDealDeckToHands();
        snap.multiPlayerAddHandsToPile();

        assertTrue(playerOne.getHand().isEmpty());
        assertTrue(playerTwo.getHand().isEmpty());
        assertEquals(52, snap.getPile().size());
        assertTrue(snap.getDeck().isEmpty());
    }

    @Test
    void testPileAddedToDeck() {
        Player player = new Player("Player");
        Snap snap = new Snap(player);

        snap.singlePlayerDealDeckToHand();
        snap.singlePlayerAddHandToPile();
        snap.addPileToDeck();

        assertTrue(player.getHand().isEmpty());
        assertTrue(snap.getPile().isEmpty());
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
    void testMultiPlayerDealDeckToHandsWorksCorrectly() {
        Player playerOne = new Player("playerOne");
        Player playerTwo = new Player("playerTwo");
        Snap snap = new Snap(playerOne, playerTwo);

        assertEquals(52, snap.getDeck().size());

        snap.multiPlayerDealDeckToHands();

        assertTrue(snap.getDeck().isEmpty());
        assertEquals(26, playerOne.getHand().size());
        assertEquals(26, playerTwo.getHand().size());
    }
}
