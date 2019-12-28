package com.ds.codility;

/**
 * @author Sarvesh Dubey
 *
 */
public class CyclicRotation {

    /**
     * A single cyclic rotation is to shift all elements of array from left to right
     * once.
     * 
     * @param A
     *            input array
     * @param k
     *            number of cyclic rotations to perform
     * @return rotated array
     */
    public static int[] cyclicRotate(int[] A, int k) {
        int length = A.length;
        if (length == k)
            return A;
        int[] rotatedArr = new int[length];
        for (int i = 0; i < A.length; i++) {
            rotatedArr[(i + k) % length] = A[i];
        }
        return rotatedArr;
    }

}
