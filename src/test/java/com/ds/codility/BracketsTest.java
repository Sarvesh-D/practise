package com.ds.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BracketsTest {

    @Test
    public void testBrackets() {
        assertThat(Brackets.isValid("[(())]")).isEqualTo(true);
        assertThat(Brackets.isValid("[())]")).isEqualTo(false);
        assertThat(Brackets.isValid("][")).isEqualTo(false);
        assertThat(Brackets.isValid("")).isEqualTo(true);
        assertThat(Brackets.isValid("{[()()]}")).isEqualTo(true);
        assertThat(Brackets.isValid("{{{{")).isEqualTo(false);
        assertThat(Brackets.isValid("[{}")).isEqualTo(false);
        assertThat(Brackets.isValid("())(()")).isEqualTo(false);
    }

}
