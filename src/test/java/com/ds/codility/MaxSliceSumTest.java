package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MaxSliceSumTest {

    @Test
    public void testMaxSliceSum() {
        int[] input1 = new int[] { 3, -2, 5, 1, 6, -5 };
        int[] input2 = new int[] { 5, -4, 8, -10, -2, 4, -3, 2, 7, -8, 3, -5, 3 };
        int[] input3 = new int[] { 3, 2, -6, 4, 0 };
        assertThat(MaxSliceSum.maxSliceSum(input1)).isEqualTo(13);
        assertThat(MaxSliceSum.maxSliceSum(input2)).isEqualTo(10);
        assertThat(MaxSliceSum.maxSliceSum(input3)).isEqualTo(5);
    }

}
