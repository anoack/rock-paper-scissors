package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

import java.util.Collection;
import java.util.Observer;

/**
 * Contains the game data as well as logic to manipulate the game data.
 */
public interface Model {

    /**
     * Clears the model data.
     */
    void reset();

    /**
     * Creates two opponent players. The type of players is determined by
     * the GameType.
     */
    void initPlayers(GameType gameType);

    /**
     * Ask the players to make their choice.
     */
    void startGame();

    /**
     * To be called when a player has made a choice.
     * @param player hte player who made a choice
     * @param choice the choice that has been made
     */
    void setPlayersChoice(Player player, Choice choice);

    /**
     * When both players have made their choice, this method returns the result.
     * @return the result or null if any of the players is not yet finished
     */
    Result getResult();

    /**
     * Returns a Collection view of the players.
     * @return a Collection containing both players
     */
    Collection<Player> getPlayers();

    GameState getState();

    /**
     * Add an Observer to be notified about changes of this Model.
     * @param o the Observer to be added
     */
    public void addObserver(Observer o);
}
