package test.java;

import main.java.BattleArena;
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

    @Test
    public void testCalculateDamage() {
        BattleArena arena = new BattleArena(new Player("Player A", 50, 10, 5),
                            new Player("Player B", 100, 10, 5));
        int damage = arena.calculateDamage(5, 3);
        assertEquals(15, damage);
    }

    @Test
    public void testPerformAttack() {
        Player attacker = new Player("Player A", 50, 10, 5);
        Player defender = new Player("Player B", 100, 10, 5);
        BattleArena arena = new BattleArena(attacker, defender);
        int initialHealth = defender.getHealth();
        arena.performAttack(attacker, defender);
        assertTrue(defender.getHealth() <= initialHealth); // Defender's health should decrease or stay the same
    }

    @Test
    public void testGameStartAndBattle() {
        Player player1 = new Player("Player A", 50, 10, 5);
        Player player2 = new Player("Player B", 100, 10, 5);

        BattleArena arena = new BattleArena(player1, player2);
        arena.startBattle();
        assertTrue(player1.isAlive() || player2.isAlive());
        assertFalse(player1.isAlive() && player2.isAlive());
    }

    @Test
    public void testEdgeCases() {
        // Very low health
        Player player1 = new Player("Player A", 1, 10, 5);
        Player player2 = new Player("Player B", 100, 10, 5);

        BattleArena arena = new BattleArena(player1, player2);
        arena.startBattle();
        assertFalse(player1.isAlive());
        assertTrue(player2.isAlive());

        // Equal health
        player1 = new Player("Player A", 100, 10, 5);
        player2 = new Player("Player B", 100, 10, 5);

        arena = new BattleArena(player1, player2);
        arena.startBattle();
        assertTrue(player1.isAlive() || player2.isAlive());
        assertFalse(player1.isAlive() && player2.isAlive());
    }
}
