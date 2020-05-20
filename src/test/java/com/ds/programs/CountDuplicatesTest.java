package com.ds.programs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountDuplicatesTest {

    @Test
    public void count() {
        Integer[] ints = new Integer[]{1,1,2,2,2,5,5,5,5,5,5,7,8,9};
        Assertions.assertThat(CountDuplicates.count(ints, 5)).isEqualTo(6);
        Assertions.assertThat(CountDuplicates.count(ints, 1)).isEqualTo(2);
        Assertions.assertThat(CountDuplicates.count(ints, 8)).isEqualTo(1);
        Assertions.assertThat(CountDuplicates.count(ints, 4)).isEqualTo(0);
    }
}