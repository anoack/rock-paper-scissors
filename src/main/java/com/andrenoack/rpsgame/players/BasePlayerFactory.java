package com.andrenoack.rpsgame.players;

/**
 * A PlayerFactory that returns a Computer player as the first Player. Subclasses have to take care about the
 * creation of the second player.
 */
public abstract class BasePlayerFactory implements PlayerFactory {

    final AutoChoosingStrategy autoChoosingStrategy;

    /**
     * At least one player returned by subclasses is a Computer player
     * who needs an AutoChoosingStrategy for making his choice.
     * @param autoChoosingStrategy the strategy to be used by newly
     *                             created Computer Players for making a choice
     */
    BasePlayerFactory(AutoChoosingStrategy autoChoosingStrategy) {
        this.autoChoosingStrategy = autoChoosingStrategy;
    }

    @Override
    public Player createPlayerOne() {
        return new AutoChoicePlayerDecorator(new GenericPlayer("Computer 1"), autoChoosingStrategy);
    }

    @Override
    public abstract Player createPlayerTwo();
}
