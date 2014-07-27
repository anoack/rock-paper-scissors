package com.andrenoack.rpsgame;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Defines the game rules, i.e. what choices are available
 * and which choice beats another choice.
 */
public enum Choice {
    ROCK, PAPER, SCISSORS;

    static {
        ROCK.beats(SCISSORS);
        PAPER.beats(ROCK);
        SCISSORS.beats(PAPER);
    }

    private final Set<Choice> losers;

    private Choice() {
        losers = new HashSet<>();
    }

    private void beats(Choice... choices) {
        Collections.addAll(this.losers, choices);
    }

    public boolean isBeating(Choice opponent) {
        return losers.contains(opponent);
    }
}
