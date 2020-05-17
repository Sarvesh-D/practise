package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MaxProfitTest {

    @Test
    public void testMaxProfit() {
        int[] transactions = new int[] { 200, 150, 320, 99, 100 };
        assertThat(MaxProfit.maxProfit(transactions)).isEqualTo(0);
    }

}
