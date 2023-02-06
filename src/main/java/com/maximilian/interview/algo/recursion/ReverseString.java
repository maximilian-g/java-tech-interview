package com.maximilian.interview.algo.recursion;

public class ReverseString {

    public static String reverse(String str) {
        return new String(reverseInternal(str.toCharArray(), 0));
    }

    private static char[] reverseInternal(char[] str, int index) {
        if (index >= str.length / 2) {
            return str;
        }
        char tmp = str[index];
        str[index] = str[str.length - index - 1];
        str[str.length - index - 1] = tmp;
        return reverseInternal(str, index + 1);
    }

}
