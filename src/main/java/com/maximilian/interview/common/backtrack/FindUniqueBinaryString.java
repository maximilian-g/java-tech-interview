package com.maximilian.interview.common.backtrack;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of strings nums containing n unique binary strings each of length n,
 * return a binary string of length n that does not appear in nums.
 * If there are multiple answers, you may return any of them.
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 * All the strings of nums are unique.
 */
public class FindUniqueBinaryString {

    public static String findDifferentBinaryString(String[] nums) {
        int lengthOfFirst = nums[0].length();
        return backtrack(lengthOfFirst, Arrays.asList(nums), new StringBuilder());
    }

    private static String backtrack(int desiredLength,
                                    List<String> existentNums,
                                    StringBuilder currentResult) {
        if (desiredLength == currentResult.length()) {
            String currentResultStr = currentResult.toString();
            if (!existentNums.contains(currentResultStr)) {
                // found first occurrence of non-existent string in existentNums
                return currentResultStr;
            }
            // existentNums contains currentResultStr, need to skip it now
            return null;
        }

        for (int i = 0; i < 2; i++) {
            currentResult.append(i);
            String combination = backtrack(desiredLength, existentNums, currentResult);
            if (combination != null) {
                return combination;
            }
            currentResult.deleteCharAt(currentResult.length() - 1);
        }
        return null;
    }

}
