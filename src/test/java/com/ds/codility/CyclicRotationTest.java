package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CyclicRotationTest {

    private int[] ints = new int[] { 3, 1, 4, 6, 2, 17 };

    @Test
    public void testCyclicRotation() {
        assertThat(CyclicRotation.cyclicRotate(ints, 3)).containsExactly(6, 2, 17, 3, 1, 4);
        assertThat(CyclicRotation.cyclicRotate(ints, 9)).containsExactly(6, 2, 17, 3, 1, 4);
        assertThat(CyclicRotation.cyclicRotate(ints, ints.length)).containsExactly(ints);
    }

    @Test
    public void testCyclicRotation2() {
        assertThat(CyclicRotation.cyclicRotate2(new int[] {}, 3)).isEmpty();
        assertThat(CyclicRotation.cyclicRotate2(new int[] {}, 0)).isEmpty();
        assertThat(CyclicRotation.cyclicRotate2(ints, 3)).containsExactly(6, 2, 17, 3, 1, 4);
        assertThat(CyclicRotation.cyclicRotate2(ints, 9)).containsExactly(6, 2, 17, 3, 1, 4);
        assertThat(CyclicRotation.cyclicRotate2(ints, ints.length)).containsExactly(ints);
    }

    public void testCyclicRotationPerformance() {

    }

}
