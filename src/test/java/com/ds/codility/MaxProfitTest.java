package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MaxProfitTest {

    @Test
    public void testMaxProfit() {
        int[] transactions = new int[] { 200, 150, 320, 99, 100 };
        assertThat(MaxProfit.maxProfit(transactions)).isEqualTo(0);
    }

}
