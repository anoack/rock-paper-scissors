package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

/**
 * An AutoChoosingStrategy is used to make a choice for Simulated (aka Computer) Players.
 */
interface AutoChoosingStrategy {

    public Choice choose();
}
