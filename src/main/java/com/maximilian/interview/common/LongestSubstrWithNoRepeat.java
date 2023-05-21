package com.maximilian.interview.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 */
public class LongestSubstrWithNoRepeat {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxSubStringLen = 0;
        int subStringLen = 0;
        Map<Character, Integer> indexByCharMap = new HashMap<>();
        TreeMap<Integer, Character> charByIndexMap = new TreeMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (indexByCharMap.containsKey(chars[i])) {
                int charIndex = indexByCharMap.get(chars[i]);
                Map<Integer, Character> integerCharacterMap =
                        new HashMap<>(charByIndexMap.headMap(charIndex));

                for (Map.Entry<Integer, Character> entry : integerCharacterMap.entrySet()) {
                    charByIndexMap.remove(entry.getKey());
                    indexByCharMap.remove(entry.getValue());
                }
                indexByCharMap.put(chars[i], i);
                charByIndexMap.remove(charIndex);
                subStringLen = i - charIndex;
            } else {
                indexByCharMap.put(chars[i], i);
                subStringLen++;
            }
            charByIndexMap.put(i, chars[i]);
            if (subStringLen > maxSubStringLen) {
                maxSubStringLen = subStringLen;
            }
        }

        return maxSubStringLen;
    }

}
