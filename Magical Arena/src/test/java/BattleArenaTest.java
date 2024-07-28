package test.java;

import main.java.Dice;
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

    @Test
    public void testDiceRoll() {
        Dice dice = new Dice();
        for (int i = 0; i < 100; i++) { // Test multiple rolls to ensure randomness within bounds
            int roll = dice.roll(6);
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}
