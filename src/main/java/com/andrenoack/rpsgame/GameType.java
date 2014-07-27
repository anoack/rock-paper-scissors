package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.*;

/**
 * Defines available Game types to play.
 */
public enum GameType {
    PLAYER_VS_COMPUTER("Player vs. Computer", new PlayerVsComputerPlayerFactory()),
    COMPUTER_VS_COMPUTER("Computer vs. Computer", new ComputerVsComputerPlayerFactory());

    private final String caption;
    private final PlayerFactory playerFactory;

    GameType(String caption, PlayerFactory playerFactory) {
        this.caption = caption;
        this.playerFactory = playerFactory;
    }

    public String getCaption() {
        return caption;
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }
}
