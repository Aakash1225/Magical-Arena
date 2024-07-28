package main.java;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll(int sides) {
        return random.nextInt(sides) + 1;
    }

}