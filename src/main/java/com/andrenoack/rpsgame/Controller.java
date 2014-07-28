package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

/**
 * This is the controller for handling user interactions.
 * It basically delegates to the Model for doing the work.
 */
public class Controller {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    /**
     * This is usually the first event to handle in the game: the player has chosen the type of game to play.
     */
    public void onGameTypeChosen(GameType gameType) {
        model.initPlayers(gameType);
        model.startGame();
    }

    /**
     * A player has made his choice.
     */
    public void onPlayerMadeChoice(Player player, Choice choice) {
        model.setPlayersChoice(player, choice);
    }

    /**
     * The player has decided to play another round.
     */
    public void onRestart() {
        model.reset();
    }

    public Model getModel() {
        return model;
    }

}
