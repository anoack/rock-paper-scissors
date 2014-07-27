package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;

/**
 * This class represents the result of a game.
 */
public class Result {

    private final Player winner;

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
