package com.andrenoack.rpsgame.players;

/**
 * A Factory for creating two opponent players.
 */
public interface PlayerFactory {

    /**
     * PlayerFactories usually have to deal with the creation of
     * simulated players (aka Computer players). Computer players need
     * an AutoChoosingStrategy for making their choice. Use this method to
     * overwrite the default AutoChoosingStrategy to be used for newly
     * created Computer Players.
     * @param autoAutoChoosingStrategy the strategy to be used by newly created Computer Players
     */
    public void setAutoChoosingStrategy(AutoChoosingStrategy autoAutoChoosingStrategy);

    public Player createPlayerOne();

    public Player createPlayerTwo();
}
