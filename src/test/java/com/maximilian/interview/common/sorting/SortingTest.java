package com.maximilian.interview.common.sorting;

import com.maximilian.interview.sorting.BubbleSort;
import com.maximilian.interview.sorting.InsertionSort;
import com.maximilian.interview.sorting.MergeSort;
import com.maximilian.interview.sorting.QuickSort;
import com.maximilian.interview.sorting.SelectionSort;
import com.maximilian.interview.sorting.SortStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortingTest {

    @Test
    void bubbleSort() {
        SortStrategy<Integer> sortStrategy = new BubbleSort<>();
        Integer[] test = {1, 15, 55, -5, 16, 66};
        sortStrategy.sort(test);
        Assertions.assertArrayEquals(new Integer[] {-5, 1, 15, 16, 55, 66}, test);
    }

    @Test
    void selectionSort() {
        SortStrategy<Integer> sortStrategy = new SelectionSort<>();
        Integer[] test = {1, 15, 55, -5, 16, 66};
        sortStrategy.sort(test);
        Assertions.assertArrayEquals(new Integer[] {-5, 1, 15, 16, 55, 66}, test);
    }

    @Test
    void insertionSort() {
        SortStrategy<Integer> sortStrategy = new InsertionSort<>();
        Integer[] test = {1, 15, 55, -5, 16, 66};
        sortStrategy.sort(test);
        Assertions.assertArrayEquals(new Integer[] {-5, 1, 15, 16, 55, 66}, test);
    }

    @Test
    void mergeSort() {
        SortStrategy<Integer> sortStrategy = new MergeSort<>();
        Integer[] test = {1, 15, 55, -5, 16, 66};
        sortStrategy.sort(test);
        Assertions.assertArrayEquals(new Integer[] {-5, 1, 15, 16, 55, 66}, test);
    }

    @Test
    void quickSort() {
        SortStrategy<Integer> sortStrategy = new QuickSort<>();
        Integer[] test = {1, 15, 55, -5, 16, 66};
        sortStrategy.sort(test);
        Assertions.assertArrayEquals(new Integer[] {-5, 1, 15, 16, 55, 66}, test);
    }

}
