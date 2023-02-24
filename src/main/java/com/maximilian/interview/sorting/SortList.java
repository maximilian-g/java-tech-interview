package com.maximilian.interview.sorting;

import com.maximilian.interview.stack.Node;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortList {

    public static <T extends Comparable<T>> Node<T> sortList(Node<T> head) {
        List<T> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(Comparator.naturalOrder());

        Node<T> newHead = null;
        Node<T> currentNode = null;
        for (T v : list) {
            if (newHead == null) {
                newHead = new Node<>(v);
                currentNode = newHead;
            } else {
                Node<T> newNode = new Node<>(v);
                currentNode.next = newNode;
                currentNode = newNode;
            }
        }
        return newHead;
    }

}
