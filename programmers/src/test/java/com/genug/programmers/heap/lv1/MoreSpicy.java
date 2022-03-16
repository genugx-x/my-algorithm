package com.genug.programmers.heap.lv1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// 더 맵게
public class MoreSpicy {


    @Test
    public void main () {
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // [1, 2, 3, 9, 10, 12]	7	2
        // solution(new int[] {1, 2, 3, 9, 10, 12}, 7);

        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, sort(new int[]{4, 2, 3, 1, 0}));
//        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, sort(new int[]{4, 3, 2, 1, 0}));
//        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, sort(new int[]{3, 4, 1, 2, 0}));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        mix(scoville, K, 0);
        return answer;
    }

    public int mix(int[] scovile, int k, int count) {
        scovile = sort(scovile);
        for (int i = 0; i < scovile.length; i++) {
            System.out.println(i);
        }
        return count;
    }

    // 버블정렬
    public int[] sort(int[] array) {
        int temp = 0;
        int count = 1;
        while(count < array.length) {
            count++;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
                // [1], 0, 2, 3 ->  [0], 1, 2, 3
                // 0, [1], 3, 2
                // 0, 1, [3], 2 -> 0, 1, [2], 3

                // 4, 2, 3, 1, 0 -> 2, 4, 3, 1, 0 -> 2, 3, 4, 1, 0 -> 2, 3, 1, 4, 0 -> 2, 3, 1, 0, 4
                // 2, 3, 1, 0, 4 -> 2, 1, 3, 0, 4 -> 2, 1, 0, 3, 4
                // 2, 1, 0, 3, 4 -> 1, 2, 0, 3, 4 -> 1, 0, 2, 3, 4
                // 1, 0, 2, 3, 4 -> 0, 1, 2, 3, 4
            }
            System.out.print(count-1 + ": ");
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        /*
        for (int i = 1; i < array.length-1; i++) {
            boolean flag = false;
            if (array[i-1] > array[i]) {
                temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
                flag = true;
            }
            if (array[i] > array[i+1]) {
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
            // 4 2 3 1 0 -> 2 3 4 1 0 -> 2 3 1 4 0 ->
            if (flag) i--;
        }
        */
        return array;
    }

}
