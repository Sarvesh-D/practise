package com.ds.codility;

/**
 * @author Sarvesh Dubey
 *
 */
public class MaxSliceSum {

    /**
     * Given an array of integers, returns sum of sub array (continuous array) such
     * that the sum is greater than any other sub array.<br>
     * Example:<br<> input = [3,-2,5,1,6,-5] should result in 13 which is max
     * possible sum obtained by sub array [3,-2,5,1,6].
     * 
     * @param A
     *            input array
     * @return max possible sum of any sub array possible.
     */
    public static int maxSliceSum(int[] A) {
        int globalMax = A[0];
        int localMax = globalMax;

        for (int i = 1; i < A.length; i++) {
            if (A[i] <= localMax + A[i]) {
                localMax += A[i];
            } else {
                localMax = A[i];
            }
            if (localMax > globalMax) {
                globalMax = localMax;
            }

        }
        return globalMax;
    }

}
