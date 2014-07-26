package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

/**
 * This ChoosingStrategy is basically useful in tests.
 * It returns the choice that has been set before.
 */
public class PredefinedChoiceAutoChoosingStrategy implements AutoChoosingStrategy {

    private Choice choice;

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    @Override
    public Choice choose() {
        return choice;
    }
}
