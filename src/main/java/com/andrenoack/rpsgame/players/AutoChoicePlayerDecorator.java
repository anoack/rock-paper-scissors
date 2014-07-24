package com.andrenoack.rpsgame.players;

/**
 * Created by Andre on 24.07.2014.
 */
public class AutoChoicePlayerDecorator extends PlayerDecorator {

    private ChoosingStrategy choosingStrategy;

    public AutoChoicePlayerDecorator(Player decoratedPlayer, ChoosingStrategy choosingStrategy) {
        super(decoratedPlayer);
        this.choosingStrategy = choosingStrategy;
    }

    @Override
    public void play() {
        super.setChoice(choosingStrategy.choose());
    }

}
