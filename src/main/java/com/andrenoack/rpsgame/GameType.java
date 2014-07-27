package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.*;

/**
 * Defines available Game types to play.
 */
public enum GameType {
    PLAYER_VS_COMPUTER("Player vs. Computer", new PlayerVsComputerPlayerFactory()),
    COMPUTER_VS_COMPUTER("Computer vs. Computer", new ComputerVsComputerPlayerFactory());

    private final String displayName;
    private final PlayerFactory playerFactory;

    GameType(String displayName, PlayerFactory playerFactory) {
        this.displayName = displayName;
        this.playerFactory = playerFactory;
    }

    public String getDisplayName() {
        return displayName;
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }
}
