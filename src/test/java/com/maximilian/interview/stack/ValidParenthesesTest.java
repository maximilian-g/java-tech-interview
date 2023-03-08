package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    @Test
    void isValid() {

        Assertions.assertFalse(ValidParentheses.isValid("{"));
        Assertions.assertFalse(ValidParentheses.isValid("{)"));
        Assertions.assertFalse(ValidParentheses.isValid("{]"));
        Assertions.assertFalse(ValidParentheses.isValid(""));
        Assertions.assertFalse(ValidParentheses.isValid("()(]"));

        Assertions.assertTrue(ValidParentheses.isValid("{}"));
        Assertions.assertTrue(ValidParentheses.isValid("()"));
        Assertions.assertTrue(ValidParentheses.isValid("[]"));
        Assertions.assertTrue(ValidParentheses.isValid("[[]]"));
        Assertions.assertTrue(ValidParentheses.isValid("()[]{}"));

    }

}