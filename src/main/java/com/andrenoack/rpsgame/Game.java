package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.ui.swing.SwingController;
import com.andrenoack.rpsgame.ui.swing.SwingView;

import javax.swing.*;

/**
 * Created by Andre on 24.07.2014.
 */
public class Game {

    public static void main(String... args) {
        GameController gameController = new GameController();
        gameController.onInit();
        SwingController swingController = new SwingController(gameController);
        SwingView swingView = new SwingView(gameController.getGameModel(), swingController);
        gameController.getGameModel().addObserver(swingView);
    }
}
