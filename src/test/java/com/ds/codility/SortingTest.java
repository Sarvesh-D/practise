package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sarvesh Dubey
 *
 */
public class SortingTest {

    private static int[] A = TestUtils.randomIntArr(10000 ^ 2, -1000, 60000, false);

    private int[] ints;

    @Before
    public void init() {
        ints = A.clone();
    }

    @Test
    public void testSelectionSort() {
        int[] sorted = A.clone();
        Arrays.sort(sorted);
        assertThat(sorted).containsExactly(Sorting.selectionSort(ints));
    }

    @Test
    public void testBubbleSort() {
        int[] sorted = A.clone();
        Arrays.sort(sorted);
        assertThat(sorted).containsExactly(Sorting.bubbleSort(ints));
    }

}
