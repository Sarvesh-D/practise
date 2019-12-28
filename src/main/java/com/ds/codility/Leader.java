/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ds.codility;

import java.util.stream.IntStream;

public class Leader {

    /**
     * Given an Integer array, finds the leader. A leader of an array is the element
     * which appears in the array for more than half the length of its size. <br>
     * Example 1: If array is [2,,3,4,4,4], then leader is 4. <br>
     * Example 2: If array is [1,2,2,3], then there is no leader, or the leader is
     * -1 <br>
     * 
     * @param ints
     *            Integer array
     * @return the leader element if present else -1
     */
    public static int findLeader(int[] ints) {
        final int defaultLeader = -1;
        if (ints.length == 0)
            return defaultLeader;
        if (ints.length == 1)
            return ints[0];
        int halfway = ints.length / 2;
        int iterations = ints.length % 2 == 0 ? halfway - 1 : halfway;
        return IntStream.rangeClosed(0, iterations)
                        .filter(i -> ints[i] == ints[i + halfway])
                        .map(i -> ints[i])
                        .findFirst()
                        .orElse(defaultLeader);

    }
}
