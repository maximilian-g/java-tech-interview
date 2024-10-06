package com.maximilian.interview.common.dp;

/**
 * <a href="https://leetcode.com/problems/integer-break/description/">Link to a task</a>
 * <p>
 * Given an integer n, break it into the sum of k positive integers,
 * where k >= 2, and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 58
 */
public class IntegerBreak {

    public static int integerBreak(int n) {
        return integerBreak(n, new int[n]);
    }

    private static int integerBreak(int n, int[] maxProductOrValueByNumber) {
        if (maxProductOrValueByNumber[n - 1] != 0) {
            return maxProductOrValueByNumber[n - 1];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            if (maxProductOrValueByNumber[n - i - 1] == 0) {
                maxProductOrValueByNumber[n - i - 1] = Math.max(integerBreak(n - i, maxProductOrValueByNumber), n - i);
            }
            if (maxProductOrValueByNumber[i - 1] == 0) {
                maxProductOrValueByNumber[i - 1] = Math.max(integerBreak(i, maxProductOrValueByNumber), i);
            }
            res = Math.max(maxProductOrValueByNumber[n - i - 1] * maxProductOrValueByNumber[i - 1], res);
        }
        return res;
    }

}
