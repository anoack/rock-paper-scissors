package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

import java.util.Random;

/**
 * A AutoChoosingStrategy that returns random choices.
 */
public class RandomAutoChoosingStrategy implements AutoChoosingStrategy {

    Random random;
    Choice[] allChoices = Choice.values();

    public RandomAutoChoosingStrategy() {
        this.random = new Random();
    }

    @Override
    public Choice choose() {
        return allChoices[random.nextInt(allChoices.length)];
    }
}
