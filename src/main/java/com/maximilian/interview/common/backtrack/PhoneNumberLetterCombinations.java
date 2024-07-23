package com.maximilian.interview.common.backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/">
 * Link to a task</a>
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all
 * possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class PhoneNumberLetterCombinations {

    private static final Map<Character, List<Character>> DIGITS_MAP =
            Map.of(
                    '2', List.of('a', 'b', 'c'),
                    '3', List.of('d', 'e', 'f'),
                    '4', List.of('g', 'h', 'i'),
                    '5', List.of('j', 'k', 'l'),
                    '6', List.of('m', 'n', 'o'),
                    '7', List.of('p', 'q', 'r', 's'),
                    '8', List.of('t', 'u', 'v'),
                    '9', List.of('w', 'x', 'y', 'z')
            );

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        backtrack(new StringBuilder(), result, digits, 0);

        return result;
    }

    private static void backtrack(StringBuilder currentCombination, List<String> result,
                                  String digits, int start) {
        if (currentCombination.length() == digits.length()) {
            if (!currentCombination.isEmpty()) {
                result.add(currentCombination.toString());
            }
            return;
        }

        char currentChar = digits.charAt(start);
        for (char mappedChar : DIGITS_MAP.get(currentChar)) {
            currentCombination.append(mappedChar);
            backtrack(currentCombination, result, digits, start + 1);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

}
