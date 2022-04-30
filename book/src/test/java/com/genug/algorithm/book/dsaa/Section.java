package com.genug.algorithm.book.dsaa;

import java.util.ArrayList;
import java.util.List;

public class Section {
    public Integer[] interSection(int[] firstArray, int[] secondArray) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    results.add(firstArray[i]);
                    break;
                }
            }
        }
        return (Integer[]) results.toArray();
    }
}
