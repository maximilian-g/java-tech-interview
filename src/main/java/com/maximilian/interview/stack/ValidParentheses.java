package com.maximilian.interview.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Map<Character, Character> closingChars = new HashMap<>();
        closingChars.put('(', ')');
        closingChars.put('[', ']');
        closingChars.put('{', '}');
        Stack<Character> openingChars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charToRemember = s.charAt(i);
            if (!closingChars.containsValue(charToRemember)) {
                openingChars.push(charToRemember);
            } else if (!openingChars.isEmpty()) {
                char charToLookup = openingChars.pop();
                if (closingChars.get(charToLookup) != s.charAt(i)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return openingChars.size() == 0;
    }

}
