package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

/**
 * Created by Andre on 24.07.2014.
 */
public interface Player {

    public void addObserver(java.util.Observer observer);

    public void play();

    public String getName();

    public void setChoice(Choice choice);

    public Choice getChoice();

    public boolean isChoiceMade();
}
