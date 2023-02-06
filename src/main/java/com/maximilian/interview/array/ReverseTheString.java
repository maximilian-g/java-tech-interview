package com.maximilian.interview.array;

import java.util.Objects;

public class ReverseTheString {

    /**
     * Given a string, create a method
     * that reverses a string
     *
     * Solution below has the following properties:
     * Time complexity:  O(n) (n/2 operations)
     */
    public static String reverse(String str) {
        Objects.requireNonNull(str, "Input data cannot be null");
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

}
