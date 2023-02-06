package com.maximilian.interview.common;

import java.util.ArrayDeque;
import java.util.Map;

public class BracketExpressionValidator {

    private static final Map<Character, Character> ALLOWED_SYMBOL_PAIRS = Map.of(
            '[', ']',
            '{', '}',
            '<', '>',
            '(', ')'
    );

    /**
     * There is expression with different type of brackets: {}, (), [], <>
     * Method needs to check if expression is correct.
     *
     * <p>
     * ([{}]) - true
     * ([)] - false
     *
     * @param expr - only symbols  {}, (), [], <> are present
     */
    public static boolean validate(String expr) {
        ArrayDeque<Character> bracketStack = new ArrayDeque<>();
        char[] chars = expr.toCharArray();

        for (char bracket : chars) {
            if (ALLOWED_SYMBOL_PAIRS.containsKey(bracket)) {
                bracketStack.addFirst(bracket);
            } else {
                // case when we have not starting symbol and stack is empty, expression is not valid
                if (bracketStack.isEmpty()) {
                    return false;
                }
                Character currentBracket = bracketStack.pop();
                Character currentBracketClosing = ALLOWED_SYMBOL_PAIRS.get(currentBracket);
                // case when 'bracket' does not match the closing bracket of 'currentBracket'
                if (currentBracketClosing != bracket) {
                    return false;
                }
            }
        }

        return bracketStack.isEmpty();
    }

}
