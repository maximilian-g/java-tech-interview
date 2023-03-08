package com.maximilian.interview.stack;

import java.util.TreeMap;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Constraints:
 * <p>
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {

    private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    private Node top;

    public MinStack() {

    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        treeMap.put(top.val, treeMap.get(top.val) - 1);
        if (treeMap.get(top.val) <= 0) {
            treeMap.remove(top.val);
        }
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return treeMap.firstKey();
    }

    private static class Node {
        private final int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

    }

}
