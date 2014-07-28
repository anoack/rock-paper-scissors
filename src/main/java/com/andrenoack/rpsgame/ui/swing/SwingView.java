package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.*;

import com.andrenoack.rpsgame.ui.swing.screens.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * A Swing based GUI view. It observes the Model for changes
 * and switches between screens accordingly.
 */
class SwingView extends JFrame implements Observer {

    private interface ScreenFactory {
        public Screen createScreen(Controller controller, Model model);
    }

    private final Controller controller;
    private final Model model;
    private final JPanel screens;
    private final Map<GameState, Component> screenMap;
    private final Map<GameState, ScreenFactory> screenFactoryRegistry;

    public SwingView(Controller controller, Model model) {
        super();
        this.controller = controller;
        this.model = model;
        screens = new JPanel(new CardLayout());
        screenMap = new HashMap<>(3);
        screenFactoryRegistry = new HashMap<>(3);

        model.addObserver(this);
        setFrameProperties();
        initScreens();
    }

    private void setFrameProperties() {
        this.setTitle("Rock Paper Scissors");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 200);
    }

    private void initScreens() {
        this.setContentPane(screens);
        screenFactoryRegistry.put(GameState.INITIALIZED, StartScreen::new);
        screenFactoryRegistry.put(GameState.RUNNING, ChooseScreen::new);
        screenFactoryRegistry.put(GameState.FINISHED, ResultScreen::new);
        showScreen();
    }

    private void showScreen() {
        GameState gameState = model.getState();
        Screen screen = screenFactoryRegistry.get(gameState).createScreen(controller, model);
        Component previous = screenMap.put(gameState, screen);
        if (previous != null) {
            screens.remove(previous);
        }
        screens.add(screen, gameState.name());
        CardLayout cl = (CardLayout)(screens.getLayout());
        cl.show(screens, gameState.name());
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof GameState) {
            showScreen();
        }
    }

}
