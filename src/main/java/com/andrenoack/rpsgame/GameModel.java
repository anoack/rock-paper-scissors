package com.andrenoack.rpsgame;

import java.util.*;

/**
 * Created by Andre on 24.07.2014.
 */
public class GameModel {

    private Map<String, Player> players;
    private Result result;

    public GameModel() {
        players = new LinkedHashMap<>(2);
    }

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void setPlayersChoice(String playerName, Choice choice) {
        Player player = players.get(playerName);
        if (player != null) {
            player.setChoice(choice);
        }
    }

    public boolean isChoicesComplete() {
        for (Player player : players.values()) {
            if(!player.isChoiceMade()) {
                return false;
            }
        }
        return !players.isEmpty();
    }

    public void calculateResult() {
        result = new Result();
    }

    public Result getResult() {
        return result;
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

}
