package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.ui.UI;
import com.andrenoack.rpsgame.ui.UIFactory;
import com.andrenoack.rpsgame.ui.swing.SwingUIFactory;

/**
 * This is the main class for starting the application.
 */
class Game {

    public static void main(String... args) {
        Model model = new DefaultModel();
        Controller controller = new Controller(model);
        UIFactory uiFactory = new SwingUIFactory();
        UI ui = uiFactory.createUI();
        ui.start(controller);
    }
}
