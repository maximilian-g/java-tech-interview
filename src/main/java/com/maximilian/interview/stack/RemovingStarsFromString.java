package com.maximilian.interview.stack;

import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters and stars *.
 * The operation above can be performed on s.
 */
public class RemovingStarsFromString {

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // skip current char + remove previous
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

}
