package com.andrenoack.rpsgame.players;

/**
 * Created by Andre on 24.07.2014.
 */
public abstract class BasePlayerFactory implements PlayerFactory {

    protected ChoosingStrategy autoChoosingStrategy;

    protected BasePlayerFactory() {
        this.autoChoosingStrategy = new RandomChoosingStrategy();
    }

    /**
     * Overwrite the default ChoosingStrategy.
     * @param autoChoosingStrategy
     */
    public void setAutoChoosingStrategy(ChoosingStrategy autoChoosingStrategy) {
        this.autoChoosingStrategy = autoChoosingStrategy;
    }

    @Override
    public Player createPlayerOne() {
        return new AutoChoicePlayerDecorator(new GenericPlayer("Computer 1"), autoChoosingStrategy);
    }
}
