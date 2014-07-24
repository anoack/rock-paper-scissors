package com.andrenoack.rpsgame;

import java.util.Observable;
import java.util.Observer;

/**
 * This is the controller for handling the game logic.
 */
public class GameController implements Observer {

    private GameModel gameModel;

    public void onInit(GameType gameType) {
        gameModel = new GameModel();
        gameModel.initPlayers(gameType);
        gameModel.addPlayerObserver(this);
        gameModel.startGame();
    }

    public void onPlayerMadeChoice(String playerName, Choice choice) {
        gameModel.setPlayersChoice(playerName, choice);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (getGameModel().isChoicesComplete()) {
            onChoicesComplete();
        }
    }

    private void onChoicesComplete() {
        gameModel.calculateResult();
        onFinished();
    }

    private void onFinished() {

    }

    public GameModel getGameModel() {
        return gameModel;
    }

}
