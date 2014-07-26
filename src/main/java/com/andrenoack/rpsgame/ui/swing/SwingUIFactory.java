package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.ui.UI;
import com.andrenoack.rpsgame.ui.UIFactory;

/**
 * Creates a Swing based GUI.
 */
public class SwingUIFactory implements UIFactory {

    @Override
    public UI createUI() {
        return new SwingUI();
    }
}
