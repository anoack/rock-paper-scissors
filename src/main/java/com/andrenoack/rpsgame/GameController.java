package com.andrenoack.rpsgame;

import java.util.Observable;
import java.util.Observer;

/**
 * This is the controller for handling the game logic.
 */
public class GameController {

    private GameModel gameModel;

    public void onInit() {
        gameModel = new GameModel();
    }

    public void onGameTypeChosen(GameType gameType) {
        gameModel.initPlayers(gameType);
        gameModel.startGame();
    }

    public void onPlayerMadeChoice(String playerName, Choice choice) {
        gameModel.setPlayersChoice(playerName, choice);
    }

    public GameModel getGameModel() {
        return gameModel;
    }

}
