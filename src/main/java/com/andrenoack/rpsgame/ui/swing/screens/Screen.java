package com.andrenoack.rpsgame.ui.swing.screens;

import com.andrenoack.rpsgame.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Base class for Swig based GUI screens.
 */
abstract class Screen extends JPanel {

    final Controller controller;

    Screen(Controller controller) {
        super();
        this.controller = controller;
    }

    JButton addButton(Container container, String text) {
        JButton button = new JButton();
        button.setText(text);
        container.add(button);
        return button;
    }

}
