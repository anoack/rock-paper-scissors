package com.andrenoack.rpsgame;

import org.junit.Test;

import static org.junit.Assert.*;
import static com.andrenoack.rpsgame.Choice.*;

public class ChoiceTest {

    @Test
    public void testRock() {
        assertTrue(ROCK.isBeating(SCISSORS));
        assertFalse(ROCK.isBeating(PAPER));
        assertFalse(ROCK.isBeating(ROCK));
    }

    @Test
    public void testScissors() {
        assertTrue(SCISSORS.isBeating(PAPER));
        assertFalse(SCISSORS.isBeating(ROCK));
        assertFalse(SCISSORS.isBeating(SCISSORS));
    }

    @Test
    public void testPaper() {
        assertTrue(PAPER.isBeating(ROCK));
        assertFalse(PAPER.isBeating(SCISSORS));
        assertFalse(PAPER.isBeating(PAPER));
    }

}