package com.andrenoack.rpsgame.ui.swing.screens;

import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.Model;
import com.andrenoack.rpsgame.Result;
import com.andrenoack.rpsgame.players.Player;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * The screen for displaying the game result.
 */
public class ResultScreen extends Screen {

    public ResultScreen(Controller controller, Model model) {
        super(controller, model);
        this.setLayout(new GridLayout(0, 1));
        this.add(createChoicesView());
        this.add(createWinnerAnnouncement());
        this.add(createPlayAgainOptions());
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
        Player[] players = model.getPlayers().toArray(new Player[2]);
        String[] columnNames = {"Player", "Player's Choice"};
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
        Result result = model.getResult();
        String winner = result.isTie() ? "Nobody (tie)" : result.getWinner().getName();
        return new JLabel("The winner is: " + winner);
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

}
