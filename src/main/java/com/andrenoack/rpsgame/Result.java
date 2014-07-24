package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

/**
 * Created by Andre on 24.07.2014.
 */
public class Result {

    private Player winner;

    public Result(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isTie() {
        return winner == null;
    }
}
