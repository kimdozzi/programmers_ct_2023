package com.ll.programmers.level0.p120906;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @test
    @DisplayName("1234 => 10")
    void t1() {
        assertThat(new Solution().solution(1234)).isEqualTo(10);
    }
}
