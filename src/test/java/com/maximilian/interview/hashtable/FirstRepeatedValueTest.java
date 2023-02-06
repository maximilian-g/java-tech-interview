package com.maximilian.interview.hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstRepeatedValueTest {

    @Test
    void findFirstRepeated() {

        Assertions.assertEquals(2, FirstRepeatedValue.findFirstRepeated(new int[] {2, 5, 1, 2, 3, 5, 1, 2, 4}));
        Assertions.assertEquals(1, FirstRepeatedValue.findFirstRepeated(new int[] {2, 1, 1, 2, 3, 5, 1, 2, 4}));
        Assertions.assertEquals(-1, FirstRepeatedValue.findFirstRepeated(new int[] {2, 1, 4, 5}));

    }

}