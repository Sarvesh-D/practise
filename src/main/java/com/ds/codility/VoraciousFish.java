package com.ds.codility;

import java.util.Stack;

/**
 * @author Sarvesh Dubey
 *
 */
public class VoraciousFish {

    /**
     * Given an array of integer representing direction of fishes, and another array
     * representing their weights, find out how fishes will survive.<br>
     * 0 represent fish moving in left direction while 1 represent fish moving in
     * right direction. If two fish moving in opposite direction encounter, the fish
     * with higher weight will eat the smaller fish.<br>
     * 
     * Note: All fish will have different weights.
     * 
     * @param A
     *            array representing direction of fish
     * @param B
     *            array representing weight of fish.
     * @return number of fishes that will survive.
     */
    public static int voraciousFish(int[] A, int[] B) {
        Stack<Integer> rightMovingFishes = new Stack<>();
        int survivors = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                rightMovingFishes.add(A[i]);
            } else {
                while (!rightMovingFishes.isEmpty()) {
                    int rWeight = rightMovingFishes.pop();
                    if (A[i] < rWeight) {
                        rightMovingFishes.push(rWeight);
                        break;
                    }
                }
                if (rightMovingFishes.isEmpty())
                    survivors++;
            }
        }
        return survivors + rightMovingFishes.size();
    }

}
