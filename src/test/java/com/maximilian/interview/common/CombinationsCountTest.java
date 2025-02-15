package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CombinationsCountTest {

    @Test
    void getCombinationsCount() {
        Assertions.assertEquals(1326, CombinationsCount.getCombinationsCount(52, 2));
    }

}