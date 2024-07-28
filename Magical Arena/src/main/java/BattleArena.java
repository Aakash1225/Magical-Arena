package main.java;

public class BattleArena {
    private Player player1;
    private Player player2;
    private Dice dice;

    public BattleArena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dice = new Dice();
    }

    public void performAttack(Player attacker, Player defender) {
        int attackRoll = dice.roll(6);
        int defendRoll = dice.roll(6);

        int attackDamage = calculateDamage(attacker.getAttack(), attackRoll);
        int defendStrength = calculateDamage(defender.getStrength(), defendRoll);

        int damageValue = Math.max(0, attackDamage - defendStrength);
        defender.reduceHealth(damageValue);

        printAttackDetails(attacker, defender, attackRoll, defendRoll, attackDamage, defendStrength, damageValue);
    }

    public int calculateDamage(int attribute, int roll) {
        return attribute * roll;
    }

    public void printAttackDetails(Player attacker, Player defender, int attackRoll, int defendRoll, int attackDamage, int defendStrength, int damageValue) {
        System.out.println(attacker + " attacks! Rolls: " + attackRoll + " (Damage: " + attackDamage + ")");
        System.out.println(defender + " defends! Rolls: " + defendRoll + " (Defense: " + defendStrength + ")");
        System.out.println("Damage Value: " + damageValue);
        System.out.println(defender + " health: " + defender.getHealth());
    }

    public void startBattle() {
        Player first, second;
        if (player1.getHealth() <= player2.getHealth()) {
            first = player1;
            second = player2;
        } else {
            first = player2;
            second = player1;
        }

        while (player1.isAlive() && player2.isAlive()) {
            performAttack(first, second);
            if (!second.isAlive()) break;
            performAttack(second, first);
        }

        printWinner();
    }

    public void printWinner() {
        if (player1.isAlive()) {
            System.out.println(player1 + " wins!");
        } else {
            System.out.println(player2 + " wins!");
        }
    }
}