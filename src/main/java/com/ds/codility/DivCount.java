package com.ds.codility;

import java.util.stream.IntStream;

/**
 * @author Sarvesh Dubey
 *
 */
public class DivCount {

    /**
     * Given an inclusive range represented input int a and int b (both inclusive),
     * determine how many ints in the given range are divisible by input int k.
     * 
     * @param A
     *            range start (inclusive)
     * @param B
     *            range end (inclusive)
     * @param K
     *            int to determine divisors in the given range
     * @return number of divisors in range of which k is factor
     */
    public static int divCount(int A, int B, int K) {
        int result = 0;
        if (A % K == 0)
            result++;
        if (B % K == 0)
            result++;
        result += (B - A) / K;
        return result;
    }

    public static long divCount2(int A, int B, int K) {
        return IntStream.rangeClosed(A, B)
                        .filter(i -> i % K == 0)
                        .peek(System.out::println)
                        .count();
    }

}
