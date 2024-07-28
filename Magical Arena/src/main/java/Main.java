package main.java;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player A", 50, 10, 5);
        Player player2 = new Player("Player B", 100, 10, 5);

        BattleArena arena = new BattleArena(player1, player2);
        arena.startBattle();
    }
}