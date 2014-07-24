package com.andrenoack.rpsgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {

    private GameController controller;
    private GameModel model;

    @Before
    public void setUp() throws Exception {
        controller = new GameController();
        controller.onInit();
        model = controller.getGameModel();
    }

    @Test
    public void testInitialized() throws Exception {
        assertEquals(2, model.getPlayers().size());
    }

    @Test
    public void testNoResultWhenNotPlayed() throws Exception {
        assertNull(model.getResult());
    }

    @Test
    public void testNoResultWhenOnlyOnePlayerPlayed() throws Exception {
        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        assertEquals(2, playerArray.length);
        controller.onPlayerMadeChoice(playerArray[0].getName(), Choice.SCISSORS);
        assertTrue(playerArray[0].isChoiceMade());
        assertFalse(playerArray[1].isChoiceMade());
        assertNull(model.getResult());
    }

    @Test
    public void testModelIsCalculatedAfterBothPlayersPlayed() throws Exception {
        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[0].getName(), Choice.SCISSORS);
        controller.onPlayerMadeChoice(playerArray[1].getName(), Choice.PAPER);
        assertNotNull(model.getResult());
    }
}