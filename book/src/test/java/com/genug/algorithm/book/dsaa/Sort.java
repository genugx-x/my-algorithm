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

    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int lowestNumberIndex = i;
            for (int j = i; j < array.length; i++) {
                if (array[i] < array[lowestNumberIndex]) {
                    lowestNumberIndex = j;
                }
            }
            if (lowestNumberIndex != i) {
                int temp = array[i];
                array[i] = array[lowestNumberIndex];
                array[lowestNumberIndex] = temp;
            }
        }
        return array;
    }

    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tempValue = array[i];
            int position = i;
            while (position > 0 &&
                    array[position - 1] > tempValue) {
                array[position] = array[position - 1];
                position = position - 1;
            }
            array[position] = tempValue;
        }
    }
}
