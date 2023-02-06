package com.maximilian.interview.algo.sorting;

public class SelectionSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = findMinIndex(array, i, array.length - 1);
            T tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    protected int findMinIndex(T[] array, int startIndex, int endIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (array[i].compareTo(array[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

}
