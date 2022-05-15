package com.genug.algorithm.book.dsaa;

public class Duplicator {
    public boolean hasDuplicateValue(int[] array) {
        int[] existingNumbers = array;
        int steps = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                steps++;
                if( i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        System.out.println(steps);
        return false;
    }

}
