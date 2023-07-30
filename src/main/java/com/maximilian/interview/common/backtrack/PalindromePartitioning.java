package com.maximilian.interview.common.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, partition s such that every
 * substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return Collections.emptyList();
        }
        List<List<String>> result = new LinkedList<>();
        backtrack(s, new LinkedList<>(), result);
        return result;
    }

    private static void backtrack(String str,
                                  List<String> tempList,
                                  List<List<String>> result) {
        // if the combination is done
        if (str.length() == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 1; i <= str.length(); i++) {
            String temp = str.substring(0, i);
            if (!isPalindrome(temp)) {
                continue;
            }
            // add i into the current combination
            tempList.add(temp);
            // seeking for next palindrome strings removing first character
            backtrack(str.substring(i), tempList, result);
            // backtrack
            tempList.remove(tempList.size() - 1);
        }
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
