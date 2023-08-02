package com.maximilian.interview.common.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinChangeTest {

    @Test
    void coinChange() {

        Assertions.assertEquals(2, CoinChange.coinChange(new int[]{1, 3, 4, 5}, 7));
//        Assertions.assertEquals(3, CoinChange.coinChange(new int[]{1, 2, 5}, 11));
//        Assertions.assertEquals(-1, CoinChange.coinChange(new int[] {2}, 3));
//        Assertions.assertEquals(1, CoinChange.coinChange(new int[] {11}, 11));
//        Assertions.assertEquals(2, CoinChange.coinChange(new int[] {7, 4}, 11));
//        Assertions.assertEquals(0, CoinChange.coinChange(new int[] {7, 4}, 0));
//        Assertions.assertEquals(20, CoinChange.coinChange(new int[] {186,419,83,408}, 6249));

    }

}