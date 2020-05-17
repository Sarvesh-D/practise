package com.ds.algos;

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

    public static int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int currentVal = A[i];
            int insertPos = i;
            while (insertPos > 0 && A[insertPos - 1] > currentVal) {
                A[insertPos] = A[insertPos - 1];
                insertPos--;
            }
            A[insertPos] = currentVal;
        }
        return A;
    }

    public static int[] mergeSort(int[] A) {
        int size = A.length;
        if (size < 2)
            return A;
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        for (int i = 0; i < left.length; i++)
            left[i] = A[i];
        for (int i = mid; i < size; i++)
            right[i - mid] = A[i];
        mergeSort(left);
        mergeSort(right);
        merge(left, right, A);
        return A;
    }

    private static int[] merge(int[] left, int[] right, int[] accumulator) {
        int lSize = left.length;
        int rSize = right.length;
        int lSelected = 0;
        int rSelected = 0;
        int accumulated = 0;
        while (lSelected < lSize && rSelected < rSize) {
            if (left[lSelected] <= right[rSelected])
                accumulator[accumulated++] = left[lSelected++];
            else
                accumulator[accumulated++] = right[rSelected++];
        }
        while (lSelected < lSize)
            accumulator[accumulated++] = left[lSelected++];
        while (rSelected < rSize)
            accumulator[accumulated++] = right[rSelected++];
        return accumulator;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
