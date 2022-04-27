package com.genug.algorithm.book.dsaa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AlgorithmTest {

    @Test
    @DisplayName("이진검색 기초")
    public void binarySearchTest_1_1() {
        Search search = new Search();
        int[] array = {1, 2, 4, 5};
        assertNull(search.binarySearch(array, 3));
        array = new int[] {1, 2, 3, 4, 5};
        assertEquals(2, search.binarySearch(array, 3));
    }

    @Test
    @DisplayName("버블정렬 테스트")
    public void bubbleSortTest_1_1() {
        Sort sort = new Sort();
        int[] array = {4, 2, 7, 1, 3};
        Assertions.assertArrayEquals(new int[] {1, 2, 3, 4, 7}, sort.bubbleSort(array));
    }
}
