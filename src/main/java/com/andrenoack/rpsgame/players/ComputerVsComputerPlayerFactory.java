package com.andrenoack.rpsgame.players;

/**
 * Created by Andre on 24.07.2014.
 */
public class ComputerVsComputerPlayerFactory extends BasePlayerFactory {

    @Override
    public Player createPlayerTwo() {
        return new AutoChoicePlayerDecorator(new GenericPlayer("Computer 2"), super.autoChoosingStrategy);
    }
}
