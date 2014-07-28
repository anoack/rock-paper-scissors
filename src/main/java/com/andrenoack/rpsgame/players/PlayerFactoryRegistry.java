package com.andrenoack.rpsgame.players;

import com.andrenoack.rpsgame.GameType;

import java.util.HashMap;
import java.util.Map;

/**
 * Registers PlayerFactories to be used for certain game types.
 */
public class PlayerFactoryRegistry {

    private final Map<GameType, PlayerFactory> lookup;

    public PlayerFactoryRegistry() {
        lookup = new HashMap<>(2);
    }

    public void add(GameType gameType, PlayerFactory playerFactory) {
        lookup.put(gameType, playerFactory);
    }

    public PlayerFactory get(GameType gameType) {
        return lookup.get(gameType);
    }
}
