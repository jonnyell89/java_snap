package snap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {

    @Test
    void testCardGameInitialisesCorrectly() {
        CardGame cardGame = new CardGame();

        assertNotNull(cardGame);
        assertEquals("Snap", cardGame.name);
        assertEquals(52, cardGame.cards.size());

    }

}
