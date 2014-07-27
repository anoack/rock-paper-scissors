package com.andrenoack.rpsgame.players;

/**
 * This PlayerFactory creates two Computer Players.
 */
public class ComputerVsComputerPlayerFactory extends BasePlayerFactory {

    public ComputerVsComputerPlayerFactory() {
        super();
    }

    @Override
    public Player createPlayerTwo() {
        return new AutoChoicePlayerDecorator(new GenericPlayer("Computer 2"), autoChoosingStrategy);
    }
}
