package com.andrenoack.rpsgame.players;

/**
 * A PlayerFactory that returns a Computer player as the first Player. Subclasses have to take care about the
 * creation of the second player.
 */
public abstract class BasePlayerFactory implements PlayerFactory {

    protected AutoChoosingStrategy autoChoosingStrategy;

    protected BasePlayerFactory() {
        this.autoChoosingStrategy = new RandomAutoChoosingStrategy();
    }

    @Override
    public void setAutoChoosingStrategy(AutoChoosingStrategy autoChoosingStrategy) {
        this.autoChoosingStrategy = autoChoosingStrategy;
    }

    @Override
    public Player createPlayerOne() {
        return new AutoChoicePlayerDecorator(new GenericPlayer("Computer 1"), autoChoosingStrategy);
    }
}
