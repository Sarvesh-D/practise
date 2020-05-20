
package com.ds.programs;

/**
 * Program to find count of an item in a sorted array.
 */
public class CountDuplicates {

    /**
     * Counts the number of given item in input array.
     * @param input array to be searched
     * @param item item to be searched
     * @param <T> Any comparable
     * @return the number of times the item occurs in the array
     */
    public static <T extends Comparable<T>> int count(T[] input, T item) {
        int firstIndex = indexOf(input, item, true);
        if (firstIndex == -1)
            return 0;
        int lastIndex = indexOf(input, item, false);
        return lastIndex - firstIndex + 1;
    }

    /**
     * Performs binary search to find either the first index or last index of given item.
     * @param input the input to array to be searched
     * @param item to be searched
     * @param first should find the first? if <code>false</code> finds the last index of the item
     * @return the first or last index of the item. <code>-1</code> if item does not exists in the array.
     */
    private static <T extends Comparable<T>> int indexOf(T[] input, T item, boolean first) {
        int left = 0;
        int right = input.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = right - left / 2;
            if (item.compareTo(input[mid]) == 0) {
                index = mid;
                if (first)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (item.compareTo(input[mid]) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
