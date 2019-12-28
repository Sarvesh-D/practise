package com.ds.codility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class holding implementations of various sorting algorithms
 * 
 * @author Sarvesh Dubey
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sorting {

    public static int[] selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[iMin]) {
                    iMin = j;
                }
            }
            swap(A, i, iMin);
        }
        return A;
    }

    public static int[] bubbleSort(int[] A) {
        int k = 0;
        boolean swaped = false;
        for (int i = 1; i < A.length; i++, k++) {
            for (int j = 0; j < A.length - k - 1; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    swaped = true;
                }
            }
            if (!swaped)
                break;
        }
        return A;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
