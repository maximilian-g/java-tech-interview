package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestStockTradeTimeTest {

    @Test
    void maxProfit() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Assertions.assertEquals(5, BestStockTradeTime.maxProfit(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        Assertions.assertEquals(0, BestStockTradeTime.maxProfit(prices));
    }

}