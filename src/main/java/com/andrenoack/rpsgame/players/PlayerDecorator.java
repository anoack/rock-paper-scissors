package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

import java.util.Observer;

/**
 * Created by Andre on 24.07.2014.
 */
public abstract class PlayerDecorator implements Player {

    private Player decoratedPlayer;

    public PlayerDecorator(Player decoratedPlayer) {
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
}
