package com.ds.codility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Sarvesh Dubey
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaxCounters {

    /**
     * Given the size of an int array n and a set of instructions to be performed on
     * n sized array, return the n sized array after performing each instructions
     * from the instruction array m. <br>
     * Instructions are of two types: <br>
     * 1) To increment an element at specific index (e.g increment(i) means to
     * increment element at ith position/ or i - 1 index by 1) <br>
     * 2) To set all elements to the maximum int present in array (e.g maxCounter(i)
     * where i > n means to set all elements in the array to the max value present
     * during execution) <br>
     * Example:<br>
     * n = 5 , m = [3,4,4,6,1,4,4] results in state change of array from [0,0,0,0,0]
     * to [2,3,2,3,4]
     * 
     * @param N
     *            size of output array
     * @param A
     *            set instructions in form of int array
     * @return array after applying all the instructions
     */
    public static int[] maxCounters(int N, int[] A) {
        int[] counters = new int[N];
        int startLine = 0;
        int currentMax = 0;
        for (int i : A) {
            int index = i - 1;
            if (i > N)
                startLine = currentMax;
            else if (counters[index] < startLine)
                counters[index] = startLine + 1;
            else
                counters[index]++;
            if (i < N && counters[index] > currentMax)
                currentMax = counters[index];
        }
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < startLine)
                counters[i] = startLine;
        }
        return counters;
    }

}
