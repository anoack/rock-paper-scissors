package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

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

    public void initPlayers(GameType gameType) {
        addPlayer(gameType.getPlayerFactory().createPlayerOne());
        addPlayer(gameType.getPlayerFactory().createPlayerTwo());
    }

    public void startGame() {
        for (Player player : getPlayers()) {
            player.play();
        }
    }

    private void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public void addPlayerObserver(Observer observer) {
        for (Player player : getPlayers()) {
            player.addObserver(observer);
            player.addObserver(observer);
        }
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
        if (isChoicesComplete()) {
            Player[] playerArray = getPlayers().toArray(new Player[0]);
            switch (compareChoices(playerArray[0].getChoice(), playerArray[1].getChoice())) {
                case 1:
                    result = new Result(playerArray[0]);
                    break;
                case -1:
                    result = new Result(playerArray[1]);
                    break;
                default:
                    result = new Result(null);
            }
        }
    }


    private int compareChoices (Choice one, Choice two) {
        if (one.isBeating(two)) {
            return 1;
        }
        if (two.isBeating(one)) {
            return -1;
        }
        return 0;
    }

    public Result getResult() {
        return result;
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

}
