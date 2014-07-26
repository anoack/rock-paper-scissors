package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.Player;
import com.andrenoack.rpsgame.players.PredefinedChoiceAutoChoosingStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    private Controller controller;
    private Model model;
    private PredefinedChoiceAutoChoosingStrategy fakeAutoChoose;

    @Before
    public void setUp() throws Exception {
        fakeAutoChoose = new PredefinedChoiceAutoChoosingStrategy();
        GameType.COMPUTER_VS_COMPUTER.getPlayerFactory().setAutoChoosingStrategy(fakeAutoChoose);
        GameType.PLAYER_VS_COMPUTER.getPlayerFactory().setAutoChoosingStrategy(fakeAutoChoose);
        controller = new Controller();
        model = controller.getModel();
    }


    private void playPlayerVsComputer(Choice forAutoChoose) {
        fakeAutoChoose.setChoice(forAutoChoose);
        controller.onGameTypeChosen(GameType.PLAYER_VS_COMPUTER);

    }

    private void playComputerVsComputer(Choice forAutoChoose) {
        fakeAutoChoose.setChoice(forAutoChoose);
        controller.onGameTypeChosen(GameType.COMPUTER_VS_COMPUTER);
    }

    @Test
    public void testInitialized() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);
        assertEquals(2, model.getPlayers().size());
    }

    @Test
    public void testModelStateInitialized() throws Exception {
        assertEquals (GameState.INITIALIZED, model.getState());
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
    public void testModelStateRunning() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);
        assertEquals (GameState.RUNNING, model.getState());
    }

    @Test
    public void testModelStateFinished() throws Exception {
        playComputerVsComputer(Choice.SCISSORS);
        assertEquals (GameState.FINISHED, model.getState());
    }

    @Test
    public void testPlayerOneWins() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);

        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[1], Choice.PAPER);

        assertNotNull(model.getResult());
        assertFalse(model.getResult().isTie());
        assertEquals(playerArray[0], model.getResult().getWinner());
    }

    @Test
    public void testPlayerTwoWins() throws Exception {
        playPlayerVsComputer(Choice.ROCK);

        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[1], Choice.PAPER);

        assertNotNull(model.getResult());
        assertFalse(model.getResult().isTie());
        assertEquals(playerArray[1], model.getResult().getWinner());
    }

    @Test
    public void testTie() throws Exception {
        playPlayerVsComputer(Choice.SCISSORS);

        Player[] playerArray = model.getPlayers().toArray(new Player[0]);
        controller.onPlayerMadeChoice(playerArray[1], Choice.SCISSORS);

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

    @Test
    public void testRestart() throws Exception {
        playComputerVsComputer(Choice.SCISSORS);
        controller.onRestart();
        assertEquals (GameState.INITIALIZED, model.getState());
    }
}