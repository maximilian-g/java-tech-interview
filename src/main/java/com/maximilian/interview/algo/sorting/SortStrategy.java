package com.maximilian.interview.algo.sorting;

public interface SortStrategy <T extends Comparable<T>> {

    void sort(T[] array);

}
