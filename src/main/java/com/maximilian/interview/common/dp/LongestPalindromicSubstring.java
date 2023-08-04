package com.maximilian.interview.common.dp;

/**
 * Given a string s, return the longest
 * palindromic substring in s.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }
        String currentLongest = null;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (currentLongest == null ||
                        (temp.length() > currentLongest.length() &&
                                isPalindrome(temp))) {
                    currentLongest = temp;
                }
            }
        }
        return currentLongest;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
