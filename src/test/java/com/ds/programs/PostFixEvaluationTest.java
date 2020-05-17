
package com.ds.programs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostFixEvaluationTest {

    @Test
    public void solution() {
        assertThat(PostFixEvaluation.solution("5 4 * 3 + 9 3 / -")).isEqualTo(20);
        assertThat(PostFixEvaluation.solution("5 4 * 5 * 8 + 9 /")).isEqualTo(12);
        assertThat(PostFixEvaluation.solution("5 4 * 5 * 8 + 12 /")).isEqualTo(9);
    }
}
