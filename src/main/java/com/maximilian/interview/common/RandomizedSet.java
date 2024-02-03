package com.maximilian.interview.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * <p>
 * bool insert(int val) Inserts an item val into the set if not present.
 * Returns true if the item was not present, false otherwise.
 * <p>
 * bool remove(int val) Removes an item val from the set if present.
 * Returns true if the item was present, false otherwise.
 * <p>
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 * <p>
 * You must implement the functions of the class such that each function works
 * in average O(1) time complexity.
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= val <= 2^31 - 1
 * At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class RandomizedSet {

    private final List<Integer> valuesList = new ArrayList<>();
    private final Map<Integer, Integer> indexByValueMap = new HashMap<>();
    private static final Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (indexByValueMap.containsKey(val)) {
            return false;
        }

        indexByValueMap.put(val, valuesList.size());
        valuesList.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!indexByValueMap.containsKey(val)) {
            return false;
        }

        int lastValue = valuesList.get(valuesList.size() - 1);

        int index = indexByValueMap.get(val);
        indexByValueMap.remove(val);
        valuesList.remove(valuesList.size() - 1);
        if (lastValue != val) {
            valuesList.set(index, lastValue);
            indexByValueMap.put(lastValue, index);
        }

        return true;
    }

    public int getRandom() {
        // it is guaranteed that getRandom will be called with at least 1 element
        return valuesList.get(random.nextInt(valuesList.size()));
    }

}
