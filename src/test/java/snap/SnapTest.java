package snap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnapTest {

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
