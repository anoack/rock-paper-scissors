package com.andrenoack.rpsgame.ui.swing.screens;

import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.Model;

import javax.swing.*;
import java.awt.*;

/**
 * Base class for Swing based GUI screens.
 */
public abstract class Screen extends JPanel {

    final Controller controller;
    final Model model;

    Screen(Controller controller, Model model) {
        super();
        this.controller = controller;
        this.model = model;
    }

    JButton addButton(Container container, String text) {
        JButton button = new JButton();
        button.setText(text);
        container.add(button);
        return button;
    }

}
