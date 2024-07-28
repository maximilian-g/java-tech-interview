package com.maximilian.interview.common;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating
 * characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead,
 * be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple
 * characters in chars.
 * <p>
 * Constraints:
 * <p>
 * 1 <= chars.length <= 2000
 * chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
public class StringCompression {

    public static String compress(char[] chars) {
        StringBuilder builder = new StringBuilder();
        char currentChar = chars[0];
        int currentCharCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (currentChar != chars[i]) {
                builder.append(currentChar);
                if (currentCharCount != 1) {
                    builder.append(currentCharCount);
                }
                currentChar = chars[i];
                currentCharCount = 1;
            } else {
                currentCharCount++;
            }
        }
        builder.append(currentChar);
        if (currentCharCount != 1) {
            builder.append(currentCharCount);
        }
        return builder.toString();
    }

}
