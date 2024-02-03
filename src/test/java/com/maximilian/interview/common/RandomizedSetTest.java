package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomizedSetTest {

    @Test
    void baseTest() {
        RandomizedSet set = new RandomizedSet();
        Assertions.assertTrue(set.insert(1));
        Assertions.assertEquals(1, set.getRandom());

        Assertions.assertFalse(set.insert(1));
        Assertions.assertTrue(set.insert(2));

        int randomVal = set.getRandom();
        Assertions.assertTrue(randomVal == 1 || randomVal == 2);

        set.remove(1);
        Assertions.assertEquals(2, set.getRandom());

    }

}