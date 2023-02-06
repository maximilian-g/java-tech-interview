package com.maximilian.interview.algo.sorting;

public class MergeSort<T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    protected void mergeSort(T[] array, int startIndex, int endIndex) {
        if(endIndex - startIndex < 1) {
            return;
        }
        int mid = (startIndex + endIndex) / 2;
        mergeSort(array, startIndex, mid);
        mergeSort(array, mid + 1, endIndex);
        merge(array, startIndex, mid, mid + 1, endIndex);
    }

    protected void merge(T[] array,
                         int firstStartIndex, int firstEndIndex,
                         int secondStartIndex, int secondEndIndex) {
        int i = firstStartIndex;
        int j = secondStartIndex;
        while (i <= firstEndIndex && j <= secondEndIndex) {
            if(array[i].compareTo(array[j]) > 0) {
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            } else {
                j++;
            }
        }
        for(; j < secondEndIndex; j++) {
            if(array[j].compareTo(array[j + 1]) > 0) {
                T tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
    }

}
