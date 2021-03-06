/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.ds.codility;

import static com.ds.codility.TestUtils.randomIntArr;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sarvesh Dubey
 *
 */
@Ignore
public class LeaderTest {

    @Test
    public void should_return_default_leader_for_empty_array() {
        assertThat(Leader.findLeader(new int[] {})).isEqualTo(-1);
    }

    @Test
    public void should_return_lone_element_for_single_sized_array() {
        assertThat(Leader.findLeader(new int[] { 4 })).isEqualTo(4);
    }

    @Test
    public void should_return_leader_from_right_half_of_array() {
        int[] sample_1 = new int[] { 4, 1, 1, 4, 4 };
        int[] sample_2 = new int[] { 1, 1, 5, 5, 5, 5 };
        assertThat(Leader.findLeader(sample_1)).isEqualTo(4);
        assertThat(Leader.findLeader(sample_2)).isEqualTo(5);
    }

    @Test
    public void should_return_leader_from_left_half_of_array() {
        int[] sample_1 = new int[] { 1, 1, 1, 1, 4, 5 };
        int[] sample_2 = new int[] { 1, 1, 1, 2, 4 };
        assertThat(Leader.findLeader(sample_1)).isEqualTo(1);
        assertThat(Leader.findLeader(sample_2)).isEqualTo(1);
    }

    @Test
    public void should_return_leader() {
        int[] sample_1 = new int[] { 1, 1, 2, 3, 4, 5 };
        int[] sample_2 = new int[] { 1, 1, 3, 4, 5 };
        int[] sample_3 = new int[] { 1, 1, 1, 1, 5, 6 };
        int[] sample_4 = new int[] { 1, 1, 5, 5, 5 };
        int[] sample_5 = new int[] { 9, 9, 9 };
        int[] sample_6 = new int[] { 9, 9, 10 };
        assertThat(Leader.findLeader(sample_1)).isEqualTo(-1);
        assertThat(Leader.findLeader(sample_2)).isEqualTo(-1);
        assertThat(Leader.findLeader(sample_3)).isEqualTo(1);
        assertThat(Leader.findLeader(sample_4)).isEqualTo(5);
        assertThat(Leader.findLeader(sample_5)).isEqualTo(9);
        assertThat(Leader.findLeader(sample_6)).isEqualTo(9);

    }

    // @Test
    public void should_return_leader_from_random_arr() {
        IntStream.rangeClosed(800, 9900)
                 .forEach(i -> {
                     int[] ints = randomIntArr(i);
                     Map<Integer, Long> stats = Arrays.stream(ints)
                                                      .boxed()
                                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                     int leader = stats.entrySet()
                                       .stream()
                                       .filter(e -> e.getValue() > ints.length / 2)
                                       .map(Map.Entry::getKey)
                                       .findFirst()
                                       .orElse(-1);
                     assertThat(leader).isEqualTo(Leader.findLeader(ints));

                 });
    }

}
