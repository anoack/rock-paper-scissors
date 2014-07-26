package com.andrenoack.rpsgame.players;

/**
 * This PlayerFactory creates a Computer Player and a regular Player.
 */
public class PlayerVsComputerPlayerFactory extends BasePlayerFactory {

    @Override
    public Player createPlayerTwo() {
        return new GenericPlayer("You");
    }
}
