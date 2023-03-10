package com.ll.programmers.level0.p120847;

import com.ll.programmers.level0.p120847.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {

    @Test
    @DisplayName("")
    void t1() {
    }
    @Test
    @DisplayName("91도가 입력되었을 때의 결과는 3")
    void t2() {
        assertThat(new Solution().solution(91)).isEqualTo(3);
    }

}
