package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.*;

import com.andrenoack.rpsgame.ui.swing.screens.ChooseScreen;
import com.andrenoack.rpsgame.ui.swing.screens.ResultScreen;
import com.andrenoack.rpsgame.ui.swing.screens.StartScreen;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * A Swing based GUI view. It observes the Model for changes
 * and switches between screens accordingly.
 */
class SwingView extends JFrame implements Observer {

    private final Controller controller;
    private JPanel screens;
    private Map<String, Component> screenMap;

    public SwingView(Controller controller) {
        super();
        this.controller = controller;
        controller.getModel().addObserver(this);
        setFrameProperties();
        initScreens();
    }

    private void setFrameProperties() {
        this.setTitle("Rock Paper Scissors");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 200);
    }

    private void initScreens() {
        screenMap = new HashMap<>();
        screens = new JPanel(new CardLayout());
        this.setContentPane(screens);
        showScreen(new StartScreen(controller), GameState.INITIALIZED.name());
    }

    private void showScreen(Component screen, String name) {
        Component previous = screenMap.put(name, screen);
        if (previous != null) {
            screens.remove(previous);
        }
        screens.add(screen, name);
        CardLayout cl = (CardLayout)(screens.getLayout());
        cl.show(screens, name);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof GameState) {
            GameState state = ((GameState)o);
            switch (state) {
                case INITIALIZED:
                    showScreen(new StartScreen(controller), state.name());
                    break;
                case RUNNING:
                    showScreen(new ChooseScreen(controller), state.name());
                    break;
                case FINISHED:
                    showScreen(new ResultScreen(controller), state.name());
                    break;
            }
        }
    }

}
