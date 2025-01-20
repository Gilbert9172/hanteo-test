package com.hanteo.quiz2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolutionTest {

    @Test
    void testCase1() {
        // given
        Solution solution = new Solution();
        int[] coins = {2, 5, 3, 6};
        int sum = 10;

        // when
        int answer = solution.allCombinations(coins, sum);

        // then
        assertThat(answer).isEqualTo(5);
    }

    @Test
    void testCase2() {
        // given
        Solution solution = new Solution();
        int[] coins = {1, 2, 4, 5, 6};
        int sum = 10;

        // when
        int answer = solution.allCombinations(coins, sum);

        // then
        assertThat(answer).isEqualTo(21);
    }

    @Test
    void testCase3() {
        // given
        Solution solution = new Solution();
        int[] coins = {1, 2, 4, 5, 6};
        int sum = -1;

        // when
        int answer = solution.allCombinations(coins, sum);

        // then
        assertThat(answer).isEqualTo(0);
    }

    @Test
    @DisplayName("0보다 작은 값이 배열에 있는 경우 에러 발생")
    void testCase4() {
        // given
        Solution solution = new Solution();
        int[] coins = {0, 2, 4, 5, 6};
        int sum = 10;

        // when && then
        assertThrows(
                RuntimeException.class,
                () -> solution.allCombinations(coins, sum)
        );
    }

}
