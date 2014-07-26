package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

/**
 * An AutoChoosingStrategy is used to make a choice for Simulated (aka Computer) Players.
 */
public interface AutoChoosingStrategy {

    public Choice choose();
}
