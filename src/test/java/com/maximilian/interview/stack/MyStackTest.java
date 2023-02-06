package com.maximilian.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void peek() {
        MyStack<Integer> test = new MyStack<>();

        Assertions.assertThrows(UnsupportedOperationException.class, test::peek);

        test.push(15);
        Assertions.assertEquals(15, test.peek());
    }

    @Test
    void push() {
        MyStack<Integer> test = new MyStack<>();
        test.push(15);
        Assertions.assertEquals(15, test.peek());
        test.push(777);
        Assertions.assertEquals(777, test.peek());
    }

    @Test
    void pop() {
        MyStack<Integer> test = new MyStack<>();
        test.push(15);
        test.push(777);
        Assertions.assertEquals(777, test.pop());
        Assertions.assertEquals(15, test.pop());
        Assertions.assertEquals(0, test.getLength());
    }

}