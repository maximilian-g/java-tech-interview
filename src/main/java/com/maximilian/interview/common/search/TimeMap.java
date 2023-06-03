package com.maximilian.interview.common.search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 * <p>
 * Implement the TimeMap class:
 * <p>
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp)
 * Stores the key with the value value at the given time timestamp.
 * <p>
 * String get(String key, int timestamp)
 * Returns a value such that set was called previously,
 * with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the value associated with the largest timestamp_prev.
 * If there are no values, it returns "".
 */
public class TimeMap {

    private final Map<String, TreeMap<Integer, String>> valueMap = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (!valueMap.containsKey(key)) {
            valueMap.put(key, new TreeMap<>());
        }
        valueMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!valueMap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = valueMap.get(key);
        Map.Entry<Integer, String> integerStringEntry = treeMap.floorEntry(timestamp);
        return integerStringEntry != null ? integerStringEntry.getValue() : "";
    }

}
