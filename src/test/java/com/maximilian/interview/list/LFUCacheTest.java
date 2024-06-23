package com.maximilian.interview.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LFUCacheTest {

    @Test
    void cacheTest() {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        Assertions.assertEquals(1, cache.get(1));

        cache.put(3, 3);
        Assertions.assertEquals(-1, cache.get(2));
        Assertions.assertEquals(3, cache.get(3));

        cache.put(4, 4);
        Assertions.assertEquals(-1, cache.get(1));
        Assertions.assertEquals(3, cache.get(3));
        Assertions.assertEquals(4, cache.get(4));

    }

}