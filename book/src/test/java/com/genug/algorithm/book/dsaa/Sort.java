package com.genug.algorithm.book.dsaa;

public class Sort {
    public int[] bubbleSort(int[] array) {
        int unsortedUntilIndex = array.length - 1;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsortedUntilIndex; i++) {
                if (array[i] > array[i+1]) {
                    sorted = false;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            unsortedUntilIndex = unsortedUntilIndex - 1;
        }
        return array;
    }
}
