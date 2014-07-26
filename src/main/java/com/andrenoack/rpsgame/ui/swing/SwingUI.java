package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.ui.UI;

/**
 * A Swing based UI.
 */
public class SwingUI implements UI {

    @Override
    public void start(Controller controller) {
        SwingView swingView = new SwingView(controller);
        swingView.setVisible(true);
    }
}
