package com.andrenoack.rpsgame.ui.swing;

import com.andrenoack.rpsgame.*;
import com.andrenoack.rpsgame.Choice;
import com.andrenoack.rpsgame.players.Player;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;

/**
 * A Swing based GUI view. It observes the Model for changes
 * and acts accordingly.
 */
class SwingView extends JFrame implements Observer {

    private Controller controller;
    private JPanel screens;
    private Map<String, Component> screenMap;

    public SwingView(Controller controller) {
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
        addOrReplaceScreen(buildStartScreen(), GameState.INITIALIZED.name());
    }

    private void addOrReplaceScreen(Component screen, String name) {
        Component previous = screenMap.put(name, screen);
        if (previous != null) {
            screens.remove(previous);
        }
        screens.add(screen, name);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof GameState) {
            GameState state = ((GameState)o);
            switch (state) {
                case INITIALIZED:
                    addOrReplaceScreen(buildStartScreen(), state.name());
                    break;
                case RUNNING:
                    addOrReplaceScreen(buildChooseScreen(), state.name());
                    break;
                case FINISHED:
                    addOrReplaceScreen(buildResultScreen(), state.name());
                    break;
            }
            changeScreen(state.name());
        }
    }

    private void changeScreen(String name) {
        CardLayout cl = (CardLayout)(screens.getLayout());
        cl.show(screens, name);
    }

    private JPanel buildStartScreen() {
        JPanel panel = new JPanel();
        for (final GameType gameType : EnumSet.allOf(GameType.class)) {
            JButton button = addButton(panel, gameType.getCaption());
            button.addActionListener(e -> controller.onGameTypeChosen(gameType));
        }
        return panel;
    }

    private JPanel buildChooseScreen() {
        JPanel panel = new JPanel();
        controller.getModel().getPlayers().stream().filter(Player::isPlaying).forEach(player -> {
            JLabel label = new JLabel("Make your choice: ");
            panel.add(label);
            for (Choice choice : EnumSet.allOf(Choice.class)) {
                JButton button = addButton(panel, choice.name());
                button.addActionListener(e -> controller.onPlayerMadeChoice(player, choice));
            }
        });
        return panel;
    }

    private JPanel buildResultScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        panel.add(createChoicesView());
        panel.add(createWinnerAnnouncement());
        panel.add(createPlayAgainOptions());
        return panel;
    }

    private Component createChoicesView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTable choices = createChoicesTable();
        panel.add(choices.getTableHeader(), BorderLayout.PAGE_START);
        panel.add(choices, BorderLayout.CENTER);
        return panel;
    }

    private JTable createChoicesTable() {
        Player[] players = controller.getModel().getPlayers().toArray(new Player[2]);
        String[] columnNames = {"Player", "Choice"};
        return new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return players.length;
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Player player = players[rowIndex];
                return (columnIndex == 0) ? player.getName() : player.getChoice().name();
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    private Component createWinnerAnnouncement() {
        Result result = controller.getModel().getResult();
        String winner = result.isTie() ? "Nobody (tie)" : result.getWinner().getName();
        return (new JLabel("The winner is: " + winner));
    }

    private Component createPlayAgainOptions() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Play again?"));
        JButton yes = addButton(panel, "Sure!");
        yes.addActionListener(e -> controller.onRestart());
        JButton no = addButton(panel, "No, thanks.");
        no.addActionListener(e -> System.exit(0));
        return panel;
    }

    private JButton addButton(Container container, String text) {
        JButton button = new JButton();
        button.setText(text);
        container.add(button);
        return button;
    }

}
