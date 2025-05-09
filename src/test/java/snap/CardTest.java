package snap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @Test
    void testCardInitialisesSevenOfHeartsWithEnumValuesCorrectly() {
        Card cardHearts = new Card(Suit.HEARTS, Rank.SEVEN);

        assertEquals("♥", cardHearts.getSuit());
        assertEquals("7", cardHearts.getSymbol());
        assertEquals(7, cardHearts.getValue());
    }

    @Test
    void testCardInitialisesJackOfClubsWithEnumValuesCorrectly() {
        Card cardClubs = new Card(Suit.CLUBS, Rank.JACK);

        assertEquals("♣", cardClubs.getSuit());
        assertEquals("J", cardClubs.getSymbol());
        assertEquals(11, cardClubs.getValue());
    }

    @Test
    void testCardInitialisesTenOfDiamondsWithEnumValuesCorrectly() {

        Card cardDiamonds = new Card(Suit.DIAMONDS, Rank.TEN);

        assertEquals("♦", cardDiamonds.getSuit());
        assertEquals("10", cardDiamonds.getSymbol());
        assertEquals(10, cardDiamonds.getValue());
    }

    @Test
    void testCardInitialisesThreeOfSpadesWithEnumValuesCorrectly() {

        Card cardSpades = new Card(Suit.SPADES, Rank.THREE);

        assertEquals("♠", cardSpades.getSuit());
        assertEquals("3", cardSpades.getSymbol());
        assertEquals(3, cardSpades.getValue());
    }
}
