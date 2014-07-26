package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.ui.UI;
import com.andrenoack.rpsgame.ui.UIFactory;
import com.andrenoack.rpsgame.ui.swing.SwingUIFactory;

/**
 * This is the main class for starting the application.
 */
public class Game {

    public static void main(String... args) {
        UIFactory uiFactory = new SwingUIFactory();
        UI ui = uiFactory.createUI();
        ui.start(new Controller());
    }
}
