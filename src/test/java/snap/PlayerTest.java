package snap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    @Test
    void testPlayerInitialisesCorrectly() {

        Player player = new Player("player");

        assertEquals("player", player.getName());
        assertTrue(player.getHand().isEmpty());
    }
}
