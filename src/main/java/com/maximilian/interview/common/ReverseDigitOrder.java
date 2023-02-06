package com.maximilian.interview.common;

/**
 * Revert order of digits in integer number: 12389 - 98321
 */
public class ReverseDigitOrder {

    // more preferable, performance is good
    public static int revertDigitOrder(int value) {
        boolean isNegative = value < 0;
        if (isNegative) {
            value *= -1;
        }
        int res = 0;

        while (value > 0) {
            res += value % 10;
            value /= 10;
            if (value > 0) {
                res *= 10;
            }
        }

        return res * (isNegative ? -1 : 1);
    }


    public static int revertDigitOrderUsingChars(int value) {
        boolean isNegative = value < 0;
        char[] chars = Integer.toString(value).replaceFirst("-", "").toCharArray();

        char tmp;
        for (int i = 0; i < chars.length / 2; i++) {
            tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }

        return Integer.parseInt((isNegative ? "-" : "") + new String(chars));
    }

}
