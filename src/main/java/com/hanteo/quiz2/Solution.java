package com.hanteo.quiz2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private final List<List<Integer>> combinations = new ArrayList<>();

    public int allCombinations(int[] coins, int sum) {
        validateInputs(coins);
        findCombinations(coins, 0, sum, new ArrayList<>(), 0);
        return combinations.size();
    }

    private void findCombinations(int[] coins, int currentAmount, int sum, List<Integer> bucket, int idx) {
        if (currentAmount > sum) return;

        if (currentAmount == sum) {
            combinations.add(new ArrayList<>(bucket));
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            int currentCoin = coins[i];

            currentAmount += currentCoin;
            bucket.add(currentCoin);

            findCombinations(coins, currentAmount, sum, bucket, i);

            currentAmount -= currentCoin;
            bucket.removeLast();
        }
    }

    private void validateInputs(int[] coins) {
        if (coins.length == 0) {
            throw new RuntimeException("coins 배열이 비어있을 순 없습니다.");
        }

        boolean hasMinus = Arrays.stream(coins).anyMatch(value -> value <=0);
        if (hasMinus) {
            throw new RuntimeException("coin이 0보다 작거나 같을 순 없습니다.");
        }
    }

    public static void main(String[] args) {
        Solution quiz2 = new Solution();

        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        int answer = quiz2.allCombinations(coins, sum);
        System.out.println(answer);
    }

}
