
package com.ds.programs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class InfixToPostFixTest {

    @Test
    public void convert() {
        assertThat(InfixToPostFix.convert("5 * 4 + 3 - 9 / 3")).isEqualTo("5 4 * 3 + 9 3 / -");
        assertThat(InfixToPostFix.convert("A + B * C + D")).isEqualTo("A B C * + D +");
        assertThat(InfixToPostFix.convert("A + B + C + D")).isEqualTo("A B + C + D +");
    }
}
