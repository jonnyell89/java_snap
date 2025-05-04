package snap;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnapTest {

    @Test
    void testCardGameInitialisesCorrectly() {
        Snap snap = new Snap();

        assertNotNull(snap);
        assertEquals(52, snap.cards.size());

    }

    @Test
    void testDeckGeneratedHeartsCorrectlyUsingStream() {
        Snap snap = new Snap();

        Stream<Card> cardStream = snap.cards.stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.HEARTS.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testDeckGeneratedClubsCorrectlyUsingStream() {
        Snap snap = new Snap();

        Stream<Card> cardStream = snap.cards.stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.CLUBS.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testDeckGeneratedDiamondsCorrectlyUsingStream() {
        Snap snap = new Snap();

        Stream<Card> cardStream = snap.cards.stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.DIAMONDS.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testDeckGeneratedSpadesCorrectlyUsingStream() {
        Snap snap = new Snap();

        Stream<Card> cardStream = snap.cards.stream();
        Stream<Card> filteredStream = cardStream.filter(card -> Objects.equals(card.getSuit(), Suit.SPADES.getSuit()));
        long count = filteredStream.count();

        assertEquals(13, count);
    }

    @Test
    void testIsSnapReturnsTrueCorrectly() {

        Card currentCard = new Card(Suit.HEARTS, Rank.NINE);
        Card previousCard = new Card(Suit.DIAMONDS, Rank.NINE);
        Snap snap = new Snap();

        assertTrue(snap.isSnap(currentCard, previousCard));

    }

    @Test
    void testIsSnapReturnsFalseCorrectly() {

        Card currentCard = new Card(Suit.CLUBS, Rank.THREE);
        Card previousCard = new Card(Suit.SPADES, Rank.QUEEN);
        Snap snap = new Snap();

        assertFalse(snap.isSnap(currentCard, previousCard));

    }

}
