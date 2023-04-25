package com.maximilian.interview.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

    private final Queue<T> innerQueue = new ConcurrentLinkedDeque<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmptyCondition = lock.newCondition();

    public void put(T value) {
        lock.lock();
        try {
            innerQueue.add(value);
            notEmptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    // method should block current thread until any value is added using put method
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (innerQueue.size() == 0) {
                notEmptyCondition.await();
            }
            return innerQueue.poll();
        } finally {
            lock.unlock();
        }
    }

}
