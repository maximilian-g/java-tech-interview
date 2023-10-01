package com.maximilian.interview.intervals.data;

public class Interval<T extends Comparable<T>> {

    private T from;
    private T to;

    public Interval() {
    }

    public Interval(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public T getFrom() {
        return from;
    }

    public Interval<T> setFrom(T from) {
        this.from = from;
        return this;
    }

    public T getTo() {
        return to;
    }

    public Interval<T> setTo(T to) {
        this.to = to;
        return this;
    }

}
