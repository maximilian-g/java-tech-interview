package com.maximilian.interview.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    /*
     * This implementation assumes that "recently used"
     * item is item that has least "accessCount"
     */

    private final Map<Integer, Node> keyValueMap;
    private final int capacity;

    private Node leastUsed;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
    }

    public int get(int key) {
        updateKeyIfPresent(key);
        Node node = keyValueMap.get(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        if (!keyValueMap.containsKey(key) && keyValueMap.size() + 1 > capacity) {
            removeLeastRecentlyUsed();
        }
        Node valueNode = keyValueMap.get(key);
        if (valueNode == null) {
            valueNode = new Node();
            valueNode.key = key;
            keyValueMap.put(key, valueNode);
        }
        valueNode.value = value;
        updateKeyIfPresent(key);
    }

    private void removeLeastRecentlyUsed() {
        keyValueMap.remove(leastUsed.key);
        leastUsed = leastUsed.next;
        if (leastUsed != null) {
            leastUsed.prev = null;
        }
    }

    private void updateKeyIfPresent(int key) {
        Node node = keyValueMap.get(key);
        if (node != null) {
            node.accessCount++;
            // new node case
            if (node.next == null && node.prev == null) {
                if (leastUsed != null) {
                    leastUsed.prev = node;
                }
                node.next = leastUsed;
                leastUsed = node;
                return;
            }
            // swapping current and next node if next node val < current node val
            while (node.next != null && node.next.accessCount < node.accessCount) {
                Node next = node.next;
                if (node.prev != null) {
                    node.prev.next = next;
                }
                next.prev = node.prev;
                node.next = next.next;
                if (next.next != null) {
                    next.next.prev = node;
                }
                next.next = node;
                node.prev = next;
                // means that 'next' node is head of a list and is leastUsed node
                if (next.prev == null) {
                    leastUsed = next;
                }
            }
        }
    }

    private static class Node {
        private int key;
        private int value;
        private int accessCount;

        private Node prev;
        private Node next;

    }

}
