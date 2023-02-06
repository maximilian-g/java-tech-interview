package com.maximilian.interview.stack;

public class MyStack <T> {
    private Node<T> head;
    private long length;

    public T peek() {
        if (head == null) {
            throw new UnsupportedOperationException("Stack is empty");
        }
        return head.val;
    }

    public void push(T val) {
        head = new Node<>(val, head);
        length++;
    }

    public T pop() {
        if (head == null) {
            throw new UnsupportedOperationException("Stack is empty");
        }
        T tmp = head.val;
        head = head.next;
        length--;
        return tmp;
    }

    public long getLength() {
        return length;
    }

}
