package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.Choice;

/**
 * A Player of the Rock-Paper-Scissors Game.
 */
public interface Player {

    /**
     * Add a subscriber of Player events, e.g. for getting
     * notified when the Player has made his choice.
     * @param observer the subscriber of Player events
     */
    public void addObserver(java.util.Observer observer);

    /**
     * Ask the Player to kindly make his choice.
     */
    public void play();

    /**
     * Indicates if this Player is currently asked to make a choice.
     * @return true if the Player is asked to make a choice, false otherwise
     */
    public boolean isPlaying();

    public String getName();

    public void setChoice(Choice choice);

    public Choice getChoice();

    public boolean isChoiceMade();
}
