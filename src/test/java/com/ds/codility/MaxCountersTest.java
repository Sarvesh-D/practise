package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MaxCountersTest {

    @Test
    public void testMaxCounters() {
        int[] ints = new int[] { 3, 4, 4, 6, 1, 4, 4 };
        assertThat(MaxCounters.maxCounters(5, ints)).containsExactly(3, 2, 2, 4, 2);
    }

}
