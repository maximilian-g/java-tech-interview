package com.maximilian.interview.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLazy {

    /*
     * Very lazy implementation,
     * assuming that "recently used" - most "elder" item
     */

    private final LinkedHashMap<Integer, Integer> map;

    public LRUCacheLazy(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}

