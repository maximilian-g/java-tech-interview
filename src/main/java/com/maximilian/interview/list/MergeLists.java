package com.maximilian.interview.list;

import com.maximilian.interview.stack.Node;

import java.util.Arrays;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeLists {

    public static <T extends Comparable<T>> Node<T> mergeKLists(Node<T>[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        Node<T> resultHead = null;
        Node<T> temp = null;

        sortLists(lists);
        while (lists[0] != null) {
            if (resultHead == null) {
                resultHead = new Node<>(lists[0].val);
                temp = resultHead;
            } else {
                temp.next = new Node<>(lists[0].val);
                temp = temp.next;
            }
            lists[0] = lists[0].next;
            sortLists(lists);
        }
        return resultHead;
    }

    private static <T extends Comparable<T>> void sortLists(Node<T>[] lists) {
        Arrays.sort(lists, (l, r) -> {
            if (l == null) {
                return 1;
            }
            if (r == null) {
                return -1;
            }
            return l.val.compareTo(r.val);
        });
    }

}
