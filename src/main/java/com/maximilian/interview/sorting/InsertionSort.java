package com.maximilian.interview.sorting;

public class InsertionSort <T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(T[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            while(j > 0 && array[j].compareTo(array[j - 1]) < 0) {
                T tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j--] = tmp;
            }
        }
    }

}
