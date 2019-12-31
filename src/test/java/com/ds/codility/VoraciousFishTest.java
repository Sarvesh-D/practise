package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class VoraciousFishTest {

    @Test
    public void testVoraciousFishSingleDirection() {
        int[] fishes = new int[] { 1, 1, 1, 1, 1 };
        int[] weights = new int[] { 2, 3, 4, 5, 6 };
        assertThat(VoraciousFish.voraciousFish(weights, fishes)).isEqualTo(5);

        int[] fishes2 = new int[] { 0, 0, 0, 0 };
        int[] weights2 = new int[] { 2, 3, 4, 5 };
        assertThat(VoraciousFish.voraciousFish(weights2, fishes2)).isEqualTo(4);
    }

    @Test
    public void testVoraciousFishDifferentDirection() {
        int[] fishes = new int[] { 0, 0, 0, 1, 1 };
        int[] weights = new int[] { 2, 3, 4, 5, 6 };
        assertThat(VoraciousFish.voraciousFish(weights, fishes)).isEqualTo(5);

        int[] fishes2 = new int[] { 0, 1, 0, 1, 1 };
        int[] weights2 = new int[] { 2, 3, 4, 5, 6 };
        assertThat(VoraciousFish.voraciousFish(weights2, fishes2)).isEqualTo(4);
    }

}
