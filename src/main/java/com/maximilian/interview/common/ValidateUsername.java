package com.maximilian.interview.common;

import java.util.Objects;

/**
 * Implement username validation function, that follows rules below:
 * - The username must be at least 6 char long and not exceed 16 char;
 * - The username must contain only letters, numbers and optionally one hyphen (-);
 * - The username must start with a letter and must not end with a hyphen (-);
 */
public class ValidateUsername {

    public static boolean isValid(String username) {
        Objects.requireNonNull(username, "Username cannot be null");
        return username.length() >= 6 &&
               username.length() <= 16 &&
               username.matches("[a-zA-Z][a-zA-Z\\d]+(-)?[a-zA-Z\\d]+");
    }

}
