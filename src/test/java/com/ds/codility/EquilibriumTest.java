package com.ds.codility;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * @author Sarvesh Dubey
 *
 */
public class EquilibriumTest {

    @Test
    public void largeInputsApproach1() {
        int[] randomIntArr = TestUtils.randomIntArr(10000 ^ 2);
        Instant start = Instant.now();
        System.out.println("Equilibrium Approach 1 = " + Equilibrium.findEquilibrium(randomIntArr));
        Instant end = Instant.now();
        System.out.println("Time Taken = " + ChronoUnit.MILLIS.between(start, end));
    }

}
