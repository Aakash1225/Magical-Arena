package test.java;

import main.java.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class BattleArenaTest {
    @Test
    public void testPlayerCreation() {
        Player player = new Player("Test Player", 50, 10, 5);
        assertEquals(50, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(5, player.getAttack());
    }
}
