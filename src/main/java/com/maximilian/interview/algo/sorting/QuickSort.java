package com.maximilian.interview.algo.sorting;

public class QuickSort <T extends Comparable<T>> implements SortStrategy<T> {

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    protected void quickSort(T[] array, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int partitionIndex = partition(array, leftIndex, rightIndex);

            quickSort(array, leftIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, rightIndex);
        }
    }

    protected int partition(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[rightIndex];
        int partitionIndex = leftIndex - 1;

        for(int i = leftIndex; i < rightIndex; i++) {
            if(pivot.compareTo(array[i]) > 0) {
                partitionIndex++;
                T tmp = array[partitionIndex];
                array[partitionIndex] = array[i];
                array[i] = tmp;
            }
        }

        partitionIndex++;
        T tmp = array[partitionIndex];
        array[partitionIndex] = array[rightIndex];
        array[rightIndex] = tmp;
        return partitionIndex;
    }

}
