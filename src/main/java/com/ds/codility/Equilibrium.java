package com.ds.codility;

import java.util.stream.IntStream;

public class Equilibrium {

    /**
     * Given an Integer array, finds the equilibrium. Equilibrium is defined as: the
     * difference between left array and right array such that |sum(left array) -
     * sum(right array)| is the minimum. <br>
     * Example 1: If array is [3,5,6,7,4], the equilibrium is at array[3] as
     * |(3+5+6) - (7+4)| = 3 is minimum <br>
     * 
     * @param ints
     *            an Integer array
     * @return the equilibrium
     */
    public static int findEquilibrium(int[] A) {
        int leftSum = A[0];
        int rightSum = IntStream.of(A)
                                .sum()
                - leftSum;
        int diff = Math.abs(leftSum - rightSum);
        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            int newDiff = Math.abs(leftSum - rightSum);
            if (newDiff < diff)
                diff = newDiff;
        }
        return diff;
    }

}
