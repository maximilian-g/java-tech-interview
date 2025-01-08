package com.maximilian.interview.common;

/**
 * <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description">Link to a task</a>
 * <p>
 * You are given a 0-indexed string array words.
 * <p>
 * Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
 * <p>
 * isPrefixAndSuffix(str1, str2) returns true if str1 is both a
 * prefix
 * and a
 * suffix
 * of str2, and false otherwise.
 * For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix,
 * but isPrefixAndSuffix("abc", "abcd") is false.
 * <p>
 * Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.
 * <p>
 * Remark: actually problem meant not "suffix", but POSTFIX...
 */
public class CountPrefixAndSuffixPairs {

    public static int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isPrefixAndSuffix(String firstStr, String secondStr) {
        return secondStr.startsWith(firstStr) && secondStr.endsWith(firstStr);
    }

}
