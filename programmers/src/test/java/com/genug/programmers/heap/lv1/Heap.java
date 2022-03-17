package com.genug.programmers.heap.lv1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    // int[] array = new int[]{0, 1, 3, 4, 6, 7, 8, 9, 10};
    List<Integer> heap;

    @Test
    void main() {
        init();

        System.out.println("ADD");
        add(3);
        System.out.println();
        System.out.println();
        System.out.println("DELETE");
        delete(0);
        delete(0);
    }

    void add(int n) {
        heap.add(n);
        int index = heap.size()-1; // 추가한 값 인덱스
        while (true) {
            int parentIndex = index / 2;
            // System.out.println("index : " + index + ", parentIndex: " + parentIndex);
            if (heap.get(index) < heap.get(parentIndex)) {
                int temp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                index = parentIndex;
            } else {
                break;
            }
            System.out.println(heap.toString());
        }
    }

    void delete() {
        int index = 1;
        heap.set(index, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        while (true) {
            int left = index * 2;
            int right = left + 1;
            if (right < heap.size()) {
                if (heap.get(left) <= heap.get(right)) {
                    if (!change(index, left)) {
                        break;
                    }
                } else {
                    if (!change(index, right)) {
                        break;
                    }
                }
            } else if (left < heap.size()) {
                if (!change(index, left)) {
                    break;
                }
            } else {
                break;
            }
            System.out.println(heap.toString());
        }
        System.out.println();
    }


    void delete(int n) {
        int index = 1;
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        // System.out.println("before : " + heap.toString());
        while (true) {
            int left = index * 2;
            int right = left + 1;
            int target = 0;
            // System.out.println("left : " + left + ", right : " + right + ", heap.size : " + heap.size());
            if (right < heap.size()) {
                if (heap.get(left) <= heap.get(right))
                    target = left;
                else
                    target = right;
            } else if (left < heap.size()) {
                target = left;
            } else {
                break;
            }
            if (change(index, target))
                index = target;
            else
                break;
            System.out.println(heap.toString());
        }
    }

    boolean change(int source, int target) {
        boolean flag = false;
        if (heap.get(source) > heap.get(target)) {
            int temp = heap.get(target);
            heap.set(target, heap.get(source));
            heap.set(source, temp);
            flag = true;
            // System.out.println("change : " + heap.toString());
        }
        return flag;
    }

    void init() {
        heap = new ArrayList<>();
        heap.add(0);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(7);
        heap.add(9);
        heap.add(10);
    }

}
