package com.ds.codility;

/**
 * @author Sarvesh Dubey
 *
 */
public class MaxProfit {

    /**
     * Given an array of integers representing daily stock prices of company X, find
     * the transaction (continuous sub array) such that the profit is greater than
     * any other transactions (continuous sub array) possible.<br>
     * Example:<br<> input = [3,-2,5,1,6,-5] should result in 13 which is max
     * possible profit obtained in transaction [3,-2,5,1,6].
     * 
     * @param A
     *            input array
     * @return max possible profit.
     */
    public static int maxProfit(int[] A) {
        int globalMax = 0;
        int localMax = 0;
        for (int i = 1; i < A.length; i++) {
            int profit = A[i] - A[i - 1];
            localMax = Math.max(profit, A[i]);
            globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }

}
