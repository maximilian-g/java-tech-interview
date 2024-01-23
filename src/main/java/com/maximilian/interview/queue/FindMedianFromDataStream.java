package com.maximilian.interview.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value,
 * and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * <p>
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * <p>
 * double findMedian() returns the median of all elements so far.
 * Answers within 10^-5 of the actual answer will be accepted.
 * <p>
 * Constraints:
 * <p>
 * -10^5 <= num <= 10^5
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 */
public class FindMedianFromDataStream {

    private final Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private final Queue<Integer> minHeap = new PriorityQueue<>();

    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size() > 1 ||
                (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        Queue<Integer> heapToPeekFrom = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        return heapToPeekFrom.peek();
    }

}
