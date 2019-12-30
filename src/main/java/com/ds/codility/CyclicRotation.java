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

    public static int[] cyclicRotate2(int[] A, int K) {
        int length = A.length;
        if (length == 0)
            return A;
        int distinctRotations = K % length;
        if (distinctRotations == 0)
            return A;
        int[] rotatedArr = new int[length];
        for (int i = 0; i + distinctRotations < rotatedArr.length; i++) {
            rotatedArr[i + distinctRotations] = A[i];
        }
        for (int i = 0; i < distinctRotations; i++) {
            rotatedArr[i] = A[length - distinctRotations + i];
        }
        return rotatedArr;
    }

}
