package com.ds.codility;

/**
 * @author Sarvesh Dubey
 *
 */
public class PassingCars {

    /**
     * Given an array of integers representing direction of cars passing, determines
     * how many instances a car moving in one direction will meet the car moving in
     * opposite direction.<br>
     * Example:<br>
     * input = [0,1,0,1,1] represents 2 cars moving in east direction (represented
     * by 0) and 3 cars moving in west direction (represented by 1). The function
     * should return 5 as output.
     * 
     * @param A
     *            array representing car directions
     * @return number of times car moving in east will meet a car moving in west.
     */
    public static int passingCars(int[] A) {
        int totalPasses = 0;
        int currentPasses = 0;
        int multiples = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == 0) {
                multiples++;
                totalPasses += currentPasses;
                currentPasses = 0;
            }
            if (A[i + 1] == 1) {
                currentPasses++;
            }
        }
        return (multiples * currentPasses) + totalPasses;
    }

    public static int passingCars1(int[] A) {
        int totalPasses = 0;
        int possiblePasses = 0;
        int multiples = -1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                possiblePasses++;
            } else {
                totalPasses += possiblePasses;
                multiples++;
                possiblePasses = 0;
            }
        }
        return (multiples * possiblePasses) + totalPasses;
    }

}
