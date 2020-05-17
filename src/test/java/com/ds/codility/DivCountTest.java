package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DivCountTest {

    @Test
    public void testDivCounts() {
        assertThat(DivCount.divCount(2, 9, 3)).isEqualTo(3);
        assertThat(DivCount.divCount(11, 345, 17)).isEqualTo(20);
        System.out.println(DivCount.divCount2(11, 345, 17));
    }

}
