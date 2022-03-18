//package com.genug.programmers.heap.lv1;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//// 더 맵게
//public class MoreSpicy {
//
//    @Test
//    void main () {
//        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//        // [1, 2, 3, 9, 10, 12]	7	2
//        assertEquals(2, solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
//        System.out.println();
//        assertEquals(5, solution(new int[] {1, 0, 1, 1, 0, 0}, 7));
//        assertEquals(-1, solution(new int[] {1, 0, 1, 0, 0, 0}, 7));
//        /*
//        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, sort(new int[]{4, 2, 3, 1, 0}));
//        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, sort(new int[]{4, 3, 2, 1, 0}));
//        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, sort(new int[]{3, 4, 1, 2, 0}));
//         */
//
//    }
//
//    int solution(int[] scoville, int K) {
//        int answer = 0;
//        List<Integer> heap = new ArrayList<>();
//        heap.add(0);
//        for (int i : scoville) {
//            add(heap, i);
//        }
//        return answer == scoville.length ? -1 : answer;
//    }
//
//    void add(List<Integer> heap, int n) {
//        heap.add(n);
//        int index = heap.size()-1; // 추가한 값 인덱스
//        while (true) {
//            int parentIndex = index / 2;
//            // System.out.println("index : " + index + ", parentIndex: " + parentIndex);
//            if (heap.get(index) < heap.get(parentIndex)) {
//                int temp = heap.get(index);
//                heap.set(index, heap.get(parentIndex));
//                heap.set(parentIndex, temp);
//                index = parentIndex;
//            } else {
//                break;
//            }
//            System.out.println(heap.toString());
//        }
//    }
//
//    void delete() {
//        int index = 1;
//        heap.set(1, heap.get(heap.size()-1));
//        heap.remove(heap.size()-1);
//        // System.out.println("before : " + heap.toString());
//        while (true) {
//            int left = index * 2;
//            int right = left + 1;
//            int target = 0;
//            // System.out.println("left : " + left + ", right : " + right + ", heap.size : " + heap.size());
//            if (right < heap.size()) {
//                if (heap.get(left) <= heap.get(right))
//                    target = left;
//                else
//                    target = right;
//            } else if (left < heap.size()) {
//                target = left;
//            } else {
//                break;
//            }
//            if (change(index, target))
//                index = target;
//            else
//                break;
//            System.out.println(heap.toString());
//        }
//    }
//
//    boolean change(int source, int target) {
//        boolean flag = false;
//        if (heap.get(source) > heap.get(target)) {
//            int temp = heap.get(target);
//            heap.set(target, heap.get(source));
//            heap.set(source, temp);
//            flag = true;
//            // System.out.println("change : " + heap.toString());
//        }
//        return flag;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public int solution(int[] scoville, int K) {
//        int answer = 0;
//        while (check(scoville, K)) {
//            mix(scoville);
//        }
//        for (int i : scoville) {
//            if ( i == -1) answer++;
//        }
//        return answer == scoville.length ? -1 : answer;
//    }
//
//    boolean check(int[] scoville, int K) {
//        for (int i = 0; i < scoville.length; i++) {
//            if (scoville[i] > -1) {
//                if (scoville[i] < K)
//                    return true;
//            }
//        }
//        return false;
//    }
//    // -1 -1 -1 -1 -1 -1 == -1
//    // -1 -1 -1 -1 -1 8 == 5
//    void mix(int[] scoville) {
//        boolean flag = false;
//        for (int i = 0; i < scoville.length-1; i++) {
//            if (scoville[i] > -1) {
//                scoville[i+1] = scoville[i] + (scoville[i+1] * 2);
//                scoville[i] = -1;
//                if (i+1 < scoville.length-1) {
//                    for (int j = i+1; j < scoville.length-1; j++) {
//                        if (scoville[j] > scoville[j+1]) {
//                            int temp = scoville[j];
//                            scoville[j] = scoville[j+1];
//                            scoville[j+1] = temp;
//                        }
//                    }
//                }
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) {
//            scoville[scoville.length-1] = -1;
//        }
//    }
//
//    void mix2(int[] scoville) {
//        boolean flag = false;
//
//        for (int i = 1; i < scoville.length-1; i++) {
////            int left = scoville[(i+1)*2-(i+1)];
////            int right = scoville[(i+1)*2+1-1];
//            int left = scoville[i*2];
//            int right = scoville[i*2+1];
//            if (left <= right) {
//                int v = scoville[i] + (scoville[left] * 2);
//            }
//        }
//    }
//    int[] getHeap(int[] array) {
//        int[] heap = new int[array.length+1];
//        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            heap[i+1] = array[i];
//        }
//        return heap;
//    }
//
//    // 3, 2, 1, 6, 4, 5
//    public void sort(int[] array) {
//        int temp = 0;
//        int count = 1;
//        int[] heap = new int[array.length+1];
//        while(count < array.length) {
//            count++;
//            for (int i = 0; i < array.length - 1; i++) {
//                if (array[i] > array[i + 1]) {
//                    temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                }
//                // [1], 0, 2, 3 ->  [0], 1, 2, 3
//                // 0, [1], 3, 2
//                // 0, 1, [3], 2 -> 0, 1, [2], 3
//
//                // 4, 2, 3, 1, 0 -> 2, 4, 3, 1, 0 -> 2, 3, 4, 1, 0 -> 2, 3, 1, 4, 0 -> 2, 3, 1, 0, 4
//                // 2, 3, 1, 0, 4 -> 2, 1, 3, 0, 4 -> 2, 1, 0, 3, 4
//                // 2, 1, 0, 3, 4 -> 1, 2, 0, 3, 4 -> 1, 0, 2, 3, 4
//                // 1, 0, 2, 3, 4 -> 0, 1, 2, 3, 4
//            }
//            /*
//            System.out.print(count-1 + ": ");
//            for (int i : array) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//             */
//        }
//        /*
//        for (int i = 1; i < array.length-1; i++) {
//            boolean flag = false;
//            if (array[i-1] > array[i]) {
//                temp = array[i];
//                array[i] = array[i-1];
//                array[i-1] = temp;
//                flag = true;
//            }
//            if (array[i] > array[i+1]) {
//                temp = array[i];
//                array[i] = array[i+1];
//                array[i+1] = temp;
//            }
//            // 4 2 3 1 0 -> 2 3 4 1 0 -> 2 3 1 4 0 ->
//            if (flag) i--;
//        }
//        */
//    }
//
//}
