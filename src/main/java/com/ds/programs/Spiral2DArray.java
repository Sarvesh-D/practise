
package com.ds.programs;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Program to print a 2D array in spiral order.
 */
public class Spiral2DArray {

    /**
     * Returns a collection containing elements in spiral order of given input 2D array
     * @param input 2D array
     * @return collection of elements in spiral order.
     */
    public static <T> Collection<T> print(T[][] input) {
        return print(input, input.length, input[0].length);
    }

    private static <T> Collection<T> print(T[][] input, int rows, int cols) {
        Collection<T> spiral = new ArrayList<>();
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int j = left; j <= right; j++) {
                    spiral.add(input[top][j]);
                }
                top++;
                dir++;
            }
            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    spiral.add(input[i][right]);
                }
                right--;
                dir++;
            }
            if (dir == 2) {
                for (int j = right; j >= left; j--) {
                    spiral.add(input[bottom][j]);
                }
                bottom--;
                dir++;
            }
            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(input[i][left]);
                }
                left++;
            }
            dir = 0;
        }
        return spiral;
    }

}
