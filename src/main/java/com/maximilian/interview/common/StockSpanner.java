package com.maximilian.interview.common;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/online-stock-span/description">Link to a task</a>
 * Design an algorithm that collects daily price quotes for some stock
 * and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price in one day is the maximum number of
 * consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 * <p>
 * For example, if the prices of the stock in the last four days is [7,2,1,2]
 * and the price of the stock today is 2, then the span of today is 4 because
 * starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
 * Also, if the prices of the stock in the last four days is [7,34,1,2]
 * and the price of the stock today is 8, then the span of today is 3 because
 * starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
 * Implement the StockSpanner class:
 * <p>
 * StockSpanner() Initializes the object of the class.
 * int next(int price) Returns the span of the stock's price given that today's price is price.
 * <p>
 * Constraints:
 * <p>
 * 1 <= price <= 10^5
 * At most 10^4 calls will be made to next.
 */
public class StockSpanner {

    private final List<Integer> stockPrices = new LinkedList<>();

    // O(n) straightforward solution, but could be better
    public int next(int price) {
        int result = 1;
        for (int stockPrice : stockPrices) {
            if (price >= stockPrice) {
                result++;
            } else {
                break;
            }
        }
        stockPrices.addFirst(price);
        return result;
    }

}
