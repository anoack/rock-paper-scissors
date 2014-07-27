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

    private static final int CYCLES = 10000;
    private static final int TOLERANCE_PERCENT = 80;

    private RandomAutoChoosingStrategy strategy;
    private Set<Choice> allChoices;
    private int minimumPerChoice;
    private Map<Choice,AtomicInteger> results;

    @Before
    public void setUp() throws Exception {
        strategy = new RandomAutoChoosingStrategy();
        allChoices = EnumSet.allOf(Choice.class);
        results = new HashMap<>();
        minimumPerChoice = CYCLES / allChoices.size() * TOLERANCE_PERCENT / 100;
        assertThat(minimumPerChoice, greaterThan(0));
        assertThat(minimumPerChoice, lessThan(CYCLES));
    }

    @Test
    public void testChoicesAreEvenlySpread() throws Exception {
        createRepresentativeAmountOfChoices();
        checkAllPossibleChoicesHaveBeenChosen();
        checkAllCountsAboveThreshold();
    }

    private void checkAllPossibleChoicesHaveBeenChosen() {
        assertEquals(allChoices, results.keySet());
    }

    private void checkAllCountsAboveThreshold() {
        for (Choice choice : results.keySet()) {
            assertThat(results.get(choice).intValue(), greaterThan(minimumPerChoice));
        }
    }

    private void createRepresentativeAmountOfChoices() {
        for (int i=0; i<CYCLES; i++) {
            Choice choice = strategy.choose();
            if (results.get(choice) == null) {
                results.put(choice, new AtomicInteger());
            }
            results.get(choice).getAndIncrement();
        }
    }

}