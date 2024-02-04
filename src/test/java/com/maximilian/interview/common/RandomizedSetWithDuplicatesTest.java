package com.maximilian.interview.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomizedSetWithDuplicatesTest {

    @Test
    void baseTest() {
        RandomizedSetWithDuplicates set = new RandomizedSetWithDuplicates();
        Assertions.assertTrue(set.insert(1));
        Assertions.assertEquals(1, set.getRandom());

        Assertions.assertTrue(set.insert(2));
        Assertions.assertFalse(set.insert(1));
        Assertions.assertTrue(set.insert(3));
        Assertions.assertFalse(set.insert(1));

        int randomVal = set.getRandom();
        Assertions.assertTrue(randomVal == 1 || randomVal == 2 || randomVal == 3);

        set.remove(2);
        randomVal = set.getRandom();
        Assertions.assertTrue(randomVal == 1 || randomVal == 3);

        set.remove(3);
        set.remove(1);
        Assertions.assertEquals(1, set.getRandom());

    }

    @Test
    void complexTest() {
        RandomizedSetWithDuplicates set = new RandomizedSetWithDuplicates();

        Assertions.assertTrue(set.insert(9));
        Assertions.assertFalse(set.insert(9));
        Assertions.assertTrue(set.insert(1));
        Assertions.assertFalse(set.insert(1));
        Assertions.assertTrue(set.insert(2));
        Assertions.assertFalse(set.insert(1));

        Assertions.assertTrue(set.remove(2));
        Assertions.assertTrue(set.remove(1));
        Assertions.assertTrue(set.remove(1));
        Assertions.assertFalse(set.insert(9));
        Assertions.assertTrue(set.remove(1));
        Assertions.assertFalse(set.remove(1));

    }

}