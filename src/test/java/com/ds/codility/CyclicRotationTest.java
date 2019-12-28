package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CyclicRotationTest {

    @Test
    public void testCyclicRotation() {
        int[] ints = new int[] { 3, 1, 4, 6, 2, 17 };
        assertThat(CyclicRotation.cyclicRotate(ints, 3)).containsExactly(6, 2, 17, 3, 1, 4);
        assertThat(CyclicRotation.cyclicRotate(ints, ints.length)).containsExactly(ints);
    }

}
