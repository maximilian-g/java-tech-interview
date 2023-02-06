package com.maximilian.interview.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void peek() {
        MyQueue<Integer> test = new MyQueue<>();
        test.enqueue(15);
        test.enqueue(30);
        test.enqueue(45);
        Assertions.assertEquals(15, test.peek());
        Assertions.assertEquals(15, test.peek());
        Assertions.assertEquals(3, test.getLength());
    }

    @Test
    void enqueueAndDequeue() {
        MyQueue<Integer> test = new MyQueue<>();
        test.enqueue(15);
        test.enqueue(30);
        test.enqueue(45);
        Assertions.assertEquals(15, test.dequeue());
        Assertions.assertEquals(30, test.dequeue());
        Assertions.assertEquals(45, test.dequeue());

        Assertions.assertThrows(UnsupportedOperationException.class, test::dequeue);

        test.enqueue(10);
        Assertions.assertEquals(10, test.dequeue());
        Assertions.assertEquals(0, test.getLength());
    }

}