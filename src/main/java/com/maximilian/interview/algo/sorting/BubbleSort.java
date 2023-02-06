package com.maximilian.interview.algo.sorting;

public class BubbleSort <T extends Comparable<T>> implements SortStrategy<T> {

    // O(n^2)
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

}
