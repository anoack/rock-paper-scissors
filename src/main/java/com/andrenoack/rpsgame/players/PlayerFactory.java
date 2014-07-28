package com.andrenoack.rpsgame.players;

/**
 * A Factory for creating two opponent players.
 */
public interface PlayerFactory {

    public Player createPlayerOne();

    public Player createPlayerTwo();
}
