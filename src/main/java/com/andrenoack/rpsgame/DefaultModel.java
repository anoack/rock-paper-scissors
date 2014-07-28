package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

import java.util.*;
import static com.andrenoack.rpsgame.GameState.*;

/**
 * Contains the game data as well as logic to manipulate the game data.
 */
public class DefaultModel extends Observable implements Observer, Model {

    private GameState state;
    private Map<String, Player> players;
    private Result result;

    public DefaultModel() {
        super();
        initialize();
    }

    private void initialize() {
        players = new LinkedHashMap<>(2);
        setState(INITIALIZED);
    }

    private void setState(GameState state) {
        if (this.state != state) {
            setChanged();
            notifyObservers(state);
            this.state = state;
        }
    }

    @Override
    public void reset() {
        result = null;
        players = null;
        initialize();
    }

    @Override
    public void initPlayers(GameType gameType) {
        addPlayer(gameType.getPlayerFactory().createPlayerOne());
        addPlayer(gameType.getPlayerFactory().createPlayerTwo());
    }

    private void addPlayer(Player player) {
        players.put(player.getName(), player);
        player.addObserver(this);
    }

    @Override
    public void startGame() {
        for (Player player : getPlayers()) {
            player.play();
        }
        if (state == INITIALIZED) {
            setState(RUNNING);
        }
    }

    @Override
    public void setPlayersChoice(Player player, Choice choice) {
        player.setChoice(choice);
    }

    /**
     * The model subscribes to the events when a player has made a choice.
     * This method is the implementation of the Observer interface.
     * @see java.util.Observable
     */
    @Override
    public void update(Observable observable, Object o) {
        if (isChoicesComplete()) {
            calculateResult();
        }
    }

    /**
     * Checks if both Players are finished with making their choice.
     * @return true if both players are finished, false otherwise
     */
    boolean isChoicesComplete() {
        for (Player player : players.values()) {
            if(!player.isChoiceMade()) {
                return false;
            }
        }
        return !players.isEmpty();
    }

    /**
     * Compute the result, i.e. which Player wins the game after both Players
     * have made their choice.
     */
    void calculateResult() {
        if (isChoicesComplete()) {
            Player[] playerArray = getPlayers().toArray(new Player[2]);
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

    @Override
    public Result getResult() {
        return result;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players.values();
    }

    @Override
    public GameState getState() {
        return state;
    }

}
