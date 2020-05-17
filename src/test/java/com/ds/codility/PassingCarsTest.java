package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PassingCarsTest {

    @Test
    public void testPassingCars() {
        int[] input_1 = new int[] { 0, 1, 0, 1, 1 };
        int[] input_2 = new int[] { 0, 0, 1, 1, 0, 1, 0 };
        assertThat(PassingCars.passingCars(input_1)).isEqualTo(5);
        assertThat(PassingCars.passingCars(input_2)).isEqualTo(7);
    }

}
