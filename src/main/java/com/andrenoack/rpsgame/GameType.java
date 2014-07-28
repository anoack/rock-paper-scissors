package com.andrenoack.rpsgame;

/**
 * Defines available Game types to play.
 */
public enum GameType {
    PLAYER_VS_COMPUTER("Player vs. Computer"),
    COMPUTER_VS_COMPUTER("Computer vs. Computer");

    private final String displayName;

    GameType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
