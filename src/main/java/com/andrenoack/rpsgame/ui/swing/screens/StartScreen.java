package com.andrenoack.rpsgame.ui.swing.screens;

import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.GameType;

import javax.swing.*;
import java.awt.*;
import java.util.EnumSet;

/**
 * The screen to be displayed to the player for choosing the game type.
 */
public class StartScreen extends Screen {

    public StartScreen(Controller controller) {
        super(controller);
        this.setLayout(new BorderLayout());
        this.add(buildHeader(), BorderLayout.PAGE_START);
        this.add(buildGameTypeChoice(), BorderLayout.CENTER);
    }

    private Component buildHeader() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("What type of game would you like to play?");
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        panel.add(label);
        return panel;
    }

    private Component buildGameTypeChoice() {
        JPanel panel = new JPanel();
        for (final GameType gameType : EnumSet.allOf(GameType.class)) {
            JButton button = addButton(panel, gameType.getDisplayName());
            button.addActionListener(e -> controller.onGameTypeChosen(gameType));
        }
        return panel;
    }
}
