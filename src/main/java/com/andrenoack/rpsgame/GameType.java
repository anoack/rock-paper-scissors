package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.*;

/**
 * Created by Andre on 24.07.2014.
 */
public enum GameType {
    PLAYER_VS_COMPUTER(new PlayerVsComputerPlayerFactory()),
    COMPUTER_VS_COMPUTER(new ComputerVsComputerPlayerFactory());

    private PlayerFactory playerFactory;

    GameType(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }
}
