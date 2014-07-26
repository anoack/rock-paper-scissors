package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.ui.swing.SwingView;

/**
 * Created by Andre on 24.07.2014.
 */
public class Game {

    public static void main(String... args) {
        Controller controller = new Controller();
        SwingView swingView = new SwingView(controller);
    }
}
