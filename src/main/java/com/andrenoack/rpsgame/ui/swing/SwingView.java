package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.Choice;
import com.andrenoack.rpsgame.GameModel;
import com.andrenoack.rpsgame.GameState;
import com.andrenoack.rpsgame.GameType;
import com.andrenoack.rpsgame.players.Player;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Andre on 24.07.2014.
 */
public class SwingView extends JFrame implements Observer {

    private GameModel model;
    private SwingController controller;
    private JPanel screens;

    public SwingView(GameModel model, SwingController controller) {
        this.model = model;
        this.controller = controller;
        setFrameProperties();
        screens = new JPanel(new CardLayout());
        this.setContentPane(screens);
        screens.add(buildStartScreen(), GameState.INITIALIZED.name());
        this.setVisible(true);
    }

    private void setFrameProperties() {
        this.setTitle("Rock Paper Scissors");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof GameState) {
            GameState state = ((GameState)o);
            switch (state) {
                case INITIALIZED:
                    screens.add(buildStartScreen(), state.name());
                    break;
                case RUNNING:
                    screens.add(buildChooseScreen(), state.name());
                    break;
                case FINISHED:
                    screens.add(buildResultScreen(), state.name());
                    break;
            }
            changeScreen(state.name());
        }
    }

    private void changeScreen(String name) {
        System.out.println("new state: " + name);
        CardLayout cl = (CardLayout)(screens.getLayout());
        cl.show(screens, name);
    }

    private JPanel buildStartScreen() {
        JPanel panel = new JPanel();
        for (GameType gameType : EnumSet.allOf(GameType.class)) {
            addButton(panel, gameType.getCaption(), gameType.name());
        }
        return panel;
    }

    private JPanel buildChooseScreen() {
        JPanel panel = new JPanel();
        for (Player player : model.getPlayers()) {
            if (player.isPlaying()) {
                JLabel label = new JLabel("Make your choice: ");
                panel.add(label);
                for (Choice choice : EnumSet.allOf(Choice.class)) {
                    addButton(panel, choice.name(), choice.name() + ";" + player.getName());
                }
            }
        }
        return panel;
    }

    private JPanel buildResultScreen() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Finished!");
        panel.add(label);
        return panel;
    }

    private void addButton(Container container, String text, String actionCommand) {
        JButton button = new JButton();
        button.setText(text);
        button.setActionCommand(actionCommand);
        container.add(button);
        button.addActionListener(controller);
    }

}
