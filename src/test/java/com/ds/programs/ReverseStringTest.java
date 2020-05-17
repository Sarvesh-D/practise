
package com.ds.programs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void solution() {
        assertThat(ReverseString.solution("ABC")).isEqualTo("CBA");
        assertThat(ReverseString.solution("JKHLIU")).isEqualTo("UILHKJ");
    }
}
