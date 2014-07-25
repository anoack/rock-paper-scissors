package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

import java.util.Observable;

/**
 * Created by Andre on 24.07.2014.
 */
public class GenericPlayer extends Observable implements Player {

    private String name;
    private Choice choice;
    private boolean playing;

    public GenericPlayer(String name) {
        this.name = name;
    }


    @Override
    public void play() {
        playing = true;
    }

    @Override
    public void setChoice(Choice choice) {
        if (!isChoiceMade()) {
            this.choice = choice;
            this.playing = false;
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public boolean isChoiceMade() {
        return choice != null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Choice getChoice() {
        return choice;
    }

    @Override
    public boolean isPlaying() {
        return playing;
    }
}
