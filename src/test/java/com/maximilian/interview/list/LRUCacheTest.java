package com.maximilian.interview.list;

import com.maximilian.interview.list.LRUCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    /*
     * LRUCache assumes that "recently used"
     * item is item that has least "accessCount"
     */
    @Test
    void cacheTest() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        Assertions.assertEquals(1, cache.get(1));

        cache.put(3, 3);
        Assertions.assertEquals(-1, cache.get(2));

        cache.put(4, 4);
        Assertions.assertEquals(1, cache.get(1));
        Assertions.assertEquals(-1, cache.get(3));
        Assertions.assertEquals(4, cache.get(4));
    }

}