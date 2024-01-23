package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindMedianFromDataStreamTest {

    @Test
    void findMedian() {
        FindMedianFromDataStream test = new FindMedianFromDataStream();
        test.addNum(1);
        Assertions.assertEquals(1.0, test.findMedian());
        test.addNum(2);
        Assertions.assertEquals(1.5, test.findMedian());
        test.addNum(3);
        Assertions.assertEquals(2.0, test.findMedian());
        test.addNum(4);
        Assertions.assertEquals(2.5, test.findMedian());
        test.addNum(5);
        Assertions.assertEquals(3, test.findMedian());
        test.addNum(6);
        Assertions.assertEquals(3.5, test.findMedian());

        test = new FindMedianFromDataStream();
        test.addNum(6);
        Assertions.assertEquals(6.0, test.findMedian());
        test.addNum(10);
        Assertions.assertEquals(8.0, test.findMedian());
        test.addNum(2);
        Assertions.assertEquals(6.0, test.findMedian());
        test.addNum(6);
        Assertions.assertEquals(6.0, test.findMedian());
        test.addNum(5);
        Assertions.assertEquals(6.0, test.findMedian());
        test.addNum(0);
        Assertions.assertEquals(5.5, test.findMedian());
        test.addNum(6);
        Assertions.assertEquals(6.0, test.findMedian());
        test.addNum(3);
        Assertions.assertEquals(5.5, test.findMedian());
        test.addNum(1);
        Assertions.assertEquals(5.0, test.findMedian());
        test.addNum(0);
        Assertions.assertEquals(4.0, test.findMedian());
        test.addNum(0);
        Assertions.assertEquals(3.0, test.findMedian());
    }

}