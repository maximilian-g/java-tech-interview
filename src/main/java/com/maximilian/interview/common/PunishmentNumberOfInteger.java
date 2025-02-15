package com.maximilian.interview.common;

/**
 * <a href="https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/">Link to a task</a>
 * <p>
 * Given a positive integer n, return the punishment number of n.
 * <p>
 * The punishment number of n is defined as the sum of the squares of all integers i such that:
 * <p>
 * 1 <= i <= n
 * The decimal representation of i * i can be partitioned
 * into contiguous substrings such that the sum of the integer values of these substrings equals i.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 182
 * Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
 * - 1 since 1 * 1 = 1
 * - 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
 * - 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
 * Hence, the punishment number of 10 is 1 + 81 + 100 = 182
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public class PunishmentNumberOfInteger {

    public static int punishmentNumber(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int iSquared = i * i;
            if (isValidPunishmentNumber(iSquared, i)) {
                result += iSquared;
            }
        }

        return result;
    }

    private static boolean isValidPunishmentNumber(int num, int target) {
        if (num == target) {
            return true;
        }
        if (target < 0 || target > num) {
            return false;
        }
        int remainder = 0;
        int iterationsMultiplier = 1;
        while (num != 0) {
            remainder += (num % 10) * iterationsMultiplier;
            num /= 10;

            if (isValidPunishmentNumber(num, target - remainder)) {
                return true;
            }

            iterationsMultiplier *= 10;
        }
        return false;
    }

}
