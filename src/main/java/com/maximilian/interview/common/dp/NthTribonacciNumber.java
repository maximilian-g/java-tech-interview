package com.maximilian.interview.common.dp;

/**
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number/description">
 * Link to a task</a>
 * <p>
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber {

    public static int tribonacci(int n) {
        // 3 - we want to initialize t0, t1, t2 anyway
        int[] dp = new int[n + 3];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

}
