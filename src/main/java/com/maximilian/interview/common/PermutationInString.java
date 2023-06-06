package com.maximilian.interview.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        char[] chars = s2.toCharArray();
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            occurrenceMap.put(c, occurrenceMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= chars.length - s1.length(); i++) {

            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                tempMap.put(chars[i + j], tempMap.getOrDefault(chars[i + j], 0) + 1);
            }
            if (allCharsAreUsed(occurrenceMap, tempMap)) {
                return true;
            }
        }
        return false;
    }

    private static boolean allCharsAreUsed(Map<Character, Integer> firstMap,
                                           Map<Character, Integer> secondMap) {
        for (char key : firstMap.keySet()) {
            if (!secondMap.containsKey(key) || firstMap.get(key) - secondMap.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

}
