package com.ds.algos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class holding implementations of various searching algorithms
 * 
 * @author Sarvesh Dubey
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Searching {

    public static int linearSearch(int[] A, int x) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x)
                return i;
        }
        return -1;
    }

    public static int linearSearchLast(int[] A, int x) {
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x)
                index = i;
        }
        return index;
    }

    public static int binarySearch(int[] A, int x) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (x == A[mid])
                return mid;
            else if (x < A[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static int binarySearchFirst(int[] A, int x) {
        int index = -1;
        int r = 0;
        int l = A.length - 1;
        while (r <= l) {
            int mid = (r + l) / 2;
            if (x == A[mid]) {
                index = mid;
                l--;
            } else if (x < A[mid])
                l = mid - 1;
            else
                r = mid + 1;
        }
        return index;
    }

    public static int binarySearchLast(int[] A, int x) {
        int index = -1;
        int r = 0;
        int l = A.length - 1;
        while (r <= l) {
            int mid = (r + l) / 2;
            if (x == A[mid]) {
                index = mid;
                r++;
            } else if (x < A[mid])
                l = mid - 1;
            else
                r = mid + 1;
        }
        return index;
    }

}
