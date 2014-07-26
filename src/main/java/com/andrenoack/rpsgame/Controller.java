package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

/**
 * This is the controller for handling user interactions.
 */
public class Controller {

    private Model model;

    public Controller() {
        model = new Model();
    }

    public void onRestart() {
        model.reset();
    }

    public void onGameTypeChosen(GameType gameType) {
        model.initPlayers(gameType);
        model.startGame();
    }

    public void onPlayerMadeChoice(Player player, Choice choice) {
        model.setPlayersChoice(player, choice);
    }

    public Model getModel() {
        return model;
    }

}
