package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;
import com.andrenoack.rpsgame.players.PredefinedChoiceChoosingStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {

    private GameController controller;
    private GameModel model;
    private PredefinedChoiceChoosingStrategy fakeAutoChoose;

    @Before
    public void setUp() throws Exception {
        fakeAutoChoose = new PredefinedChoiceChoosingStrategy();
        GameType.COMPUTER_VS_COMPUTER.getPlayerFactory().setAutoChoosingStrategy(fakeAutoChoose);
        GameType.PLAYER_VS_COMPUTER.getPlayerFactory().setAutoChoosingStrategy(fakeAutoChoose);
        controller = new GameController();
    }

    private void playPlayerVsComputer(Choice forAutoChoose) {
        fakeAutoChoose.setChoice(forAutoChoose);
        controller.onInit(GameType.PLAYER_VS_COMPUTER);
        model = controller.getGameModel();
    }

    private void playComputerVsComputer(Choice forAutoChoose) {
        fakeAutoChoose.setChoice(forAutoChoose);
        controller.onInit(GameType.COMPUTER_VS_COMPUTER);
        model = controller.getGameModel();
    }

    @Test
    public void testInitialized() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);
        assertEquals(2, model.getPlayers().size());
    }

    @Test
    public void testNoResultWhenNotPlayed() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);
        assertNull(model.getResult());
    }

    @Test
    public void testNoResultWhenOnlyOnePlayerPlayed() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);
        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        assertTrue(playerArray[0].isChoiceMade());
        assertFalse(playerArray[1].isChoiceMade());
        assertNull(model.getResult());
    }

    @Test
    public void testPlayerOneWins() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);

        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[1].getName(), Choice.PAPER);

        assertNotNull(model.getResult());
        assertFalse(model.getResult().isTie());
        assertEquals(playerArray[0], model.getResult().getWinner());
    }

    @Test
    public void testPlayerTwoWins() throws Exception {
        playPlayerVsComputer(Choice.ROCK);

        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[1].getName(), Choice.PAPER);

        assertNotNull(model.getResult());
        assertFalse(model.getResult().isTie());
        assertEquals(playerArray[1], model.getResult().getWinner());
    }

    @Test
    public void testTie() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);

        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[1].getName(), Choice.SCISSORS);

        assertNotNull(model.getResult());
        assertTrue(model.getResult().isTie());
        assertNull(model.getResult().getWinner());
    }

    @Test
    public void testComputerVsComputerTie() throws Exception {
        playComputerVsComputer(Choice.ROCK);

        assertNotNull(model.getResult());
        assertTrue(model.getResult().isTie());
        assertNull(model.getResult().getWinner());
    }
}