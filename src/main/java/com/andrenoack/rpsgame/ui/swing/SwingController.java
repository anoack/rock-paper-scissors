package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.GameController;
import com.andrenoack.rpsgame.GameType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andre on 24.07.2014.
 */
public class SwingController implements ActionListener {

    private GameController gameController;

    public SwingController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Action: " + actionEvent.getActionCommand());
        switch (gameController.getGameModel().getState()) {
            case INITIALIZED:
                chooseGameType(actionEvent.getActionCommand());
                break;
            case RUNNING:
                makeChoice(actionEvent.getActionCommand());
        }
    }

    private void chooseGameType(String type) {
        GameType gameType = GameType.valueOf(type);
        gameController.onGameTypeChosen(gameType);
    }

    private void makeChoice(String choice) {
        System.out.println(choice);

    }
}
