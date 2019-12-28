package com.ds.codility;

import java.util.Random;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Sarvesh Dubey
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

    private static final int DEFAULT_ARR_SIZE = 1000;

    private static final int DEFAULT_SEED = 0;

    private static final int DEFAULT_MAX_BOUND = 10;

    public static int[] randomSortedIntArr() {
        return randomIntArr(DEFAULT_ARR_SIZE, DEFAULT_SEED, DEFAULT_MAX_BOUND, true);
    }

    public static int[] randomIntArr() {
        return randomIntArr(DEFAULT_ARR_SIZE, DEFAULT_SEED, DEFAULT_MAX_BOUND, false);
    }

    public static int[] randomSortedIntArr(int size) {
        return randomIntArr(size, DEFAULT_SEED, DEFAULT_MAX_BOUND, true);
    }

    public static int[] randomIntArr(int size) {
        return randomIntArr(size, DEFAULT_SEED, DEFAULT_MAX_BOUND, false);
    }

    /**
     * Generates random sorted array containing elements as specified by size. The
     * elements will be randomly choosen from ints between start and end bounds
     * 
     * @param size
     *            size of resulting array
     * @param start
     *            seed number to randomly choose from (inclusive)
     * @param end
     *            max int number that can appear in this array (exclusive)
     * @param sorted
     *            should sort the array
     * @return A sorted array
     */
    public static int[] randomIntArr(int size, int start, int end, boolean sorted) {
        if (sorted)
            return new Random().ints(size, start, end)
                               .sorted()
                               .toArray();
        return new Random().ints(size, start, end)
                           .toArray();
    }

}
