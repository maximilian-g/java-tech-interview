package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemovingStarsFromStringTest {

    @Test
    void removeStars() {

        Assertions.assertEquals("lecoe", RemovingStarsFromString.removeStars("leet**cod*e"));
        Assertions.assertEquals("", RemovingStarsFromString.removeStars("erase*****"));

    }

}