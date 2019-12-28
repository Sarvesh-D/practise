package com.ds.codility;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class EquilibriumTest {

    int[] largeInput = randomIntArr(10000 ^ 2);

    // @Test
    public void largeInputsApproach1() {
        Instant start = Instant.now();
        System.out.println("Equilibrium Approach 1 = " + Equilibrium.findEquilibrium(largeInput));
        Instant end = Instant.now();
        System.out.println("Time Taken = " + ChronoUnit.MILLIS.between(start, end));
    }

    private static int[] randomIntArr(int size) {
        return new Random().ints(size, 0, 100)
                           .toArray();
    }

}
