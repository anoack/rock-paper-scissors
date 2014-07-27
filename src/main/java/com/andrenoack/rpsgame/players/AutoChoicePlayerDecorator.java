package com.andrenoack.rpsgame.players;

/**
 * Decorates Player instances with functionality to automatically
 * make a choice by utilizing an AutoChoosingStrategy.
 */
public class AutoChoicePlayerDecorator extends PlayerDecorator {

    private final AutoChoosingStrategy autoChoosingStrategy;

    public AutoChoicePlayerDecorator(Player decoratedPlayer, AutoChoosingStrategy autoChoosingStrategy) {
        super(decoratedPlayer);
        this.autoChoosingStrategy = autoChoosingStrategy;
    }

    /**
     * Sets a choice that is retrieved by utilizing the AutoChoosingStrategy.
     */
    @Override
    public void play() {
        super.setChoice(autoChoosingStrategy.choose());
    }

}
