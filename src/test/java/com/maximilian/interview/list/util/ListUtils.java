package com.maximilian.interview.list.util;

import com.maximilian.interview.stack.Node;

public class ListUtils {

    public static <T> Node<T> makeListFrom(T[] arr) {
        Node<T> head = null;
        Node<T> temp = null;
        for (T val : arr) {
            if (head == null) {
                head = new Node<>(val);
                temp = head;
            } else {
                temp.next = new Node<>(val);
                temp = temp.next;
            }
        }
        return head;
    }

}
