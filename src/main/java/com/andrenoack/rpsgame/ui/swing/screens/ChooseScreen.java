package com.andrenoack.rpsgame.ui.swing.screens;

import com.andrenoack.rpsgame.Choice;
import com.andrenoack.rpsgame.Controller;
import com.andrenoack.rpsgame.Model;
import com.andrenoack.rpsgame.players.Player;

import javax.swing.*;
import java.util.EnumSet;

/**
 * This is the screen where the player makes his choice.
 */
public class ChooseScreen extends Screen {

    public ChooseScreen(Controller controller, Model model) {
        super(controller, model);
        addChoices(controller);
    }

    private void addChoices(Controller controller) {
        model.getPlayers().stream().filter(Player::isPlaying).forEach(player -> {
            JLabel label = new JLabel("Make your choice: ");
            this.add(label);
            for (Choice choice : EnumSet.allOf(Choice.class)) {
                JButton button = addButton(this, choice.name());
                button.addActionListener(e -> controller.onPlayerMadeChoice(player, choice));
            }
        });
    }
}
