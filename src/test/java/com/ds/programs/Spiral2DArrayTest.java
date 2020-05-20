package com.ds.programs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class Spiral2DArrayTest {

    @Test
    public void print() {
        Integer[][] _3x3 = {{2, 4,1}, {7, 9, 1}, {5, 3, 8}};
        Collection<Integer> _3x3Spiral = Spiral2DArray.print(_3x3);
        print(_3x3);
        System.out.println(_3x3Spiral);
        Assertions.assertThat(_3x3Spiral).containsExactly(2,4,1,1,8,3,5,7,9);
        Integer[][] _4x3 = {{2, 4,1}, {7, 9, 1}, {5, 3, 8}, {12, 17,15}};
        Collection<Integer> _4x3Spiral = Spiral2DArray.print(_4x3);
        print(_4x3);
        System.out.println(_4x3Spiral);
        Assertions.assertThat(_4x3Spiral).containsExactly(2, 4, 1, 1, 8, 15, 17, 12, 5, 7, 9, 3);
    }

    <T> void print(T[][] input) {
        for (int i = 0; i <= input.length - 1; i++) {
            for (int j= 0; j <= input[0].length -1; j++) {
                System.out.print(String.format("%5s", input[i][j]));
            }
            System.out.print("\n");
        }

    }


}