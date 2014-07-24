package com.andrenoack.rpsgame;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Andre on 24.07.2014.
 */
public class Player extends Observable {

    private String name;
    private Choice choice;

    public Player(String name) {
        this.name = name;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
        setChanged();
        notifyObservers();
    }

    public boolean isChoiceMade() {
        return choice != null;
    }

    public String getName() {
        return name;
    }

    public Choice getChoice() {
        return choice;
    }
}
