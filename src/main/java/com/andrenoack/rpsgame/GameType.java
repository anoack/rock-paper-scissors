package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.*;

/**
 * Created by Andre on 24.07.2014.
 */
public enum GameType {
    PLAYER_VS_COMPUTER("Player vs. Computer", new PlayerVsComputerPlayerFactory()),
    COMPUTER_VS_COMPUTER("Computer vs. Computer", new ComputerVsComputerPlayerFactory());

    private String caption;
    private PlayerFactory playerFactory;

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
