package com.maximilian.interview.common.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/perfect-squares/description/">Link to a task</a>
 * <p>
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 */
public class PerfectSquares {

    public static int numSquares(int n) {
        return numSquares(n, 0, new HashMap<>());
    }

    public static int numSquares(int n, int operationsCount, Map<Integer, Integer> operationsByValue) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return operationsCount;
        }
        if (operationsByValue.containsKey(n)) {
            return operationsByValue.get(n) + operationsCount;
        }
        int minOperations = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            minOperations = Math.min(minOperations, numSquares(n - i * i, operationsCount + 1, operationsByValue));
        }
        operationsByValue.put(n, minOperations - operationsCount);
        return minOperations;
    }

}
