package com.andrenoack.rpsgame.players;

/**
 * Created by Andre on 24.07.2014.
 */
public class PlayerVsComputerPlayerFactory extends BasePlayerFactory {

    @Override
    public Player createPlayerTwo() {
        return new GenericPlayer("You");
    }
}
