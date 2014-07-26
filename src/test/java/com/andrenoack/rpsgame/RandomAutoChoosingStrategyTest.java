package com.andrenoack.rpsgame;

import com.andrenoack.rpsgame.players.RandomAutoChoosingStrategy;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class RandomAutoChoosingStrategyTest {

    private RandomAutoChoosingStrategy strategy;

    @Before
    public void setUp() throws Exception {
        strategy = new RandomAutoChoosingStrategy();
    }

    @Test
    public void testChoicesAreEvenlySpread() throws Exception {
        Set<Choice> allChoices = EnumSet.allOf(Choice.class);
        final int cyclesPerChoice = 100;
        final int minimumExpectedCountPerChoice = 80;
        final int totalCycles = cyclesPerChoice * allChoices.size();

        Map<Choice,AtomicInteger> results = new HashMap<>();
        for (int i=0; i<totalCycles; i++) {
            Choice choice = strategy.choose();
            if (results.get(choice) == null) {
                results.put(choice, new AtomicInteger());
            }
            results.get(choice).getAndIncrement();
        }

        assertEquals(allChoices, results.keySet());
        for (Choice choice : results.keySet()) {
            assertThat(results.get(choice).intValue(), greaterThan(minimumExpectedCountPerChoice));
        }
    }
}