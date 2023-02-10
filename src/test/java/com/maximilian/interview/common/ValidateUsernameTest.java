package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateUsernameTest {

    @Test
    void isValid() {
        Assertions.assertTrue(ValidateUsername.isValid("Mark-153"));
        Assertions.assertTrue(ValidateUsername.isValid("Mark153"));
        Assertions.assertTrue(ValidateUsername.isValid("aleks666"));

        Assertions.assertFalse(ValidateUsername.isValid("5aleks666"));
        Assertions.assertFalse(ValidateUsername.isValid("aleks-"));
        Assertions.assertFalse(ValidateUsername.isValid("-aleks"));
        Assertions.assertFalse(ValidateUsername.isValid("ali"));
        Assertions.assertFalse(ValidateUsername.isValid("aliexpress0very0long0string"));
        Assertions.assertFalse(ValidateUsername.isValid("aliex$#%#%$#x"));
        Assertions.assertFalse(ValidateUsername.isValid("%aliex"));
        Assertions.assertFalse(ValidateUsername.isValid("al  iex"));
        Assertions.assertFalse(ValidateUsername.isValid("Mark--153"));
    }

}