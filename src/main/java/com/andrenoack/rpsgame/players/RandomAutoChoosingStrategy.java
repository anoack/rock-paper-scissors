package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

import java.util.Random;

/**
 * A AutoChoosingStrategy that returns random choices.
 */
public class RandomAutoChoosingStrategy implements AutoChoosingStrategy {

    private final Random random;
    private final Choice[] allChoices;

    public RandomAutoChoosingStrategy() {
        this.random = new Random();
        allChoices = Choice.values();
    }

    @Override
    public Choice choose() {
        return allChoices[random.nextInt(allChoices.length)];
    }
}
