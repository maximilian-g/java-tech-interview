package com.maximilian.interview.queue;

import com.maximilian.interview.stack.Node;

public class MyQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private long length;

    public T peek() {
        if (head == null) {
            throw new UnsupportedOperationException("Stack is empty");
        }
        return head.val;
    }

    public void enqueue(T val) {

        Node<T> node = new Node<>(val, null);
        if (tail != null) {
            tail.next = node;

        }
        tail = node;
        if (head == null) {
            head = tail;
        }
        length++;
    }

    public T dequeue() {
        if (head == null) {
            throw new UnsupportedOperationException("Stack is empty");
        }
        T tmp = head.val;
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        length--;
        return tmp;
    }

    public long getLength() {
        return length;
    }

}
