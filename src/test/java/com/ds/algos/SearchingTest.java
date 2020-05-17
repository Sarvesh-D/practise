package com.ds.algos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SearchingTest {

    private int[] input;

    private int[] sortedInput;

    @Before
    public void init() {
        input = new int[] { 3, 1, 2, 6, 4, 2, 2 };
        sortedInput = new int[] { 1, 2, 2, 2, 2, 3, 4, 6 };
    }

    @Test
    public void testLinearSearch() {
        assertThat(Searching.linearSearch(input, 6)).isEqualTo(3);
        assertThat(Searching.linearSearch(input, 3)).isEqualTo(0);
        assertThat(Searching.linearSearch(input, 2)).isEqualTo(2);
        assertThat(Searching.linearSearch(input, 7)).isEqualTo(-1);
    }

    @Test
    public void testLinearSearchLast() {
        assertThat(Searching.linearSearchLast(input, 6)).isEqualTo(3);
        assertThat(Searching.linearSearchLast(input, 3)).isEqualTo(0);
        assertThat(Searching.linearSearchLast(input, 2)).isEqualTo(6);
        assertThat(Searching.linearSearchLast(input, 7)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearch() {
        assertThat(Searching.binarySearch(sortedInput, 6)).isEqualTo(7);
        assertThat(Searching.binarySearch(sortedInput, 3)).isEqualTo(5);
        assertThat(Searching.binarySearch(sortedInput, 2)).isNotEqualTo(-1);
        assertThat(Searching.binarySearch(sortedInput, 7)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearchFirst() {
        assertThat(Searching.binarySearchFirst(sortedInput, 6)).isEqualTo(7);
        assertThat(Searching.binarySearchFirst(sortedInput, 3)).isEqualTo(5);
        assertThat(Searching.binarySearchFirst(sortedInput, 2)).isEqualTo(1);
        assertThat(Searching.binarySearchFirst(sortedInput, 7)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearchLast() {
        assertThat(Searching.binarySearchLast(sortedInput, 6)).isEqualTo(7);
        assertThat(Searching.binarySearchLast(sortedInput, 3)).isEqualTo(5);
        assertThat(Searching.binarySearchLast(sortedInput, 2)).isEqualTo(4);
        assertThat(Searching.binarySearchLast(sortedInput, 7)).isEqualTo(-1);
    }

}
