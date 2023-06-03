package com.maximilian.interview.common.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeMapTest {

    @Test
    void get() {
        TimeMap map = new TimeMap();

        map.set("hello", "world", 10);
        map.set("hello", "qwe", 12);

        Assertions.assertEquals("", map.get("hello", 9));
        Assertions.assertEquals("world", map.get("hello", 10));
        Assertions.assertEquals("world", map.get("hello", 11));
        Assertions.assertEquals("qwe", map.get("hello", 12));
        Assertions.assertEquals("qwe", map.get("hello", 13));

    }

}