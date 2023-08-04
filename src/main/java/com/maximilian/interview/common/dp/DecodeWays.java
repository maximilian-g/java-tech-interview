package com.maximilian.interview.common.dp;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only digits, return the number of ways to decode it.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {


    public static int numDecodingsDpBottomUp(String s) {
        int stringSize = s.length();
        int[] dp = new int[stringSize + 1];
        dp[stringSize] = 1;
        for (int i = stringSize - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            dp[i] = dp[i + 1];
            if (i < stringSize - 1 &&
                    (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static int numDecodingsRecursive(String s) {
        return s.isEmpty() ? 0 : numOfDecodings(s, 0);
    }

    private static int numOfDecodings(String s, int index) {
        if (index == s.length()) {
            return 1;
        }
        if (index >= s.length() || s.charAt(index) == '0') {
            return 0;
        }
        int res = numOfDecodings(s, index + 1);
        if (index + 1 < s.length() &&
                (s.charAt(index) == '1' ||
                        (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            res += numOfDecodings(s, index + 2);
        }
        return res;
    }

}
