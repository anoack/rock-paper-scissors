package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

import java.util.*;
import static com.andrenoack.rpsgame.GameState.*;

/**
 * Created by Andre on 24.07.2014.
 */
public class Model extends Observable implements Observer {

    private GameState state;
    private Map<String, Player> players;
    private Result result;

    public Model() {
        initialize();
    }

    private void initialize() {
        players = new LinkedHashMap<>(2);
        setState(INITIALIZED);
    }

    public void reset() {
        result = null;
        players = null;
        initialize();
    }

    private void setState(GameState state) {
        if (this.state != state) {
            setChanged();
            notifyObservers(state);
            this.state = state;
        }
    }

    public void initPlayers(GameType gameType) {
        addPlayer(gameType.getPlayerFactory().createPlayerOne());
        addPlayer(gameType.getPlayerFactory().createPlayerTwo());
    }

    public void startGame() {
        for (Player player : getPlayers()) {
            player.play();
        }
        if (state == INITIALIZED) {
            setState(RUNNING);
        }
    }

    private void addPlayer(Player player) {
        players.put(player.getName(), player);
        player.addObserver(this);
    }

    public void setPlayersChoice(Player player, Choice choice) {
        player.setChoice(choice);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (isChoicesComplete()) {
            calculateResult();
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
        setState(FINISHED);
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

    public GameState getState() {
        return state;
    }

}
