package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

import java.util.Observer;

/**
 * An abstract Decorator that delegates all methods to the decorated Player.
 * Use this class as a base class when creating concrete PlayerDecorators.
 */
public abstract class PlayerDecorator implements Player {

    private final Player decoratedPlayer;

    PlayerDecorator(Player decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    @Override
    public void setChoice(Choice choice) {
        decoratedPlayer.setChoice(choice);
    }

    @Override
    public boolean isChoiceMade() {
        return decoratedPlayer.isChoiceMade();
    }

    @Override
    public void addObserver(Observer observer) {
        decoratedPlayer.addObserver(observer);
    }

    @Override
    public String getName() {
        return decoratedPlayer.getName();
    }

    @Override
    public Choice getChoice() {
        return decoratedPlayer.getChoice();
    }

    @Override
    public void play() {
        decoratedPlayer.play();
    }

    @Override
    public boolean isPlaying() {
        return decoratedPlayer.isPlaying();
    }
}
