package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

import java.util.Random;

/**
 * Created by Andre on 24.07.2014.
 */
public class RandomChoosingStrategy implements ChoosingStrategy {

    Random random;
    Choice[] allChoices = Choice.values();

    public RandomChoosingStrategy() {
        this.random = new Random();
    }

    @Override
    public Choice choose() {
        return allChoices[random.nextInt(allChoices.length)];
    }
}
