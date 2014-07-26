package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.ui.UI;

/**
 * Created by Andre on 26.07.2014.
 */
public class SwingUI implements UI {

    @Override
    public void start(Controller controller) {
        SwingView swingView = new SwingView(controller);
        swingView.setVisible(true);
    }
}
