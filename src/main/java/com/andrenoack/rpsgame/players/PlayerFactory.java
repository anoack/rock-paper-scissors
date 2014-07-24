package com.andrenoack.rpsgame.players;

/**
 * Created by Andre on 24.07.2014.
 */
public interface PlayerFactory {

    public void setAutoChoosingStrategy(ChoosingStrategy autoChoosingStrategy);

    public Player createPlayerOne();

    public Player createPlayerTwo();
}
