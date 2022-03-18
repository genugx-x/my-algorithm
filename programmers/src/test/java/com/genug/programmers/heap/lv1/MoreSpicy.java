package com.genug.programmers.heap.lv1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 더 맵게
// 채점 완료 코드
public class MoreSpicy {

    @Test
    public void main () {
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        assertEquals(2, solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
        assertEquals(5, solution(new int[] {1, 0, 1, 1, 0, 0}, 7));
        assertEquals(-1, solution(new int[] {1, 0, 1, 0, 0, 0}, 7));
        assertEquals(0, solution(new int[] {11, 8, 7, 9, 10, 35}, 7));
        assertEquals(1, solution(new int[] {53, 8, 4, 9, 10, 35}, 7));
    }

    int solution(int[] scoville, int K) {
        int answer = 0;
        Heap heap = new Heap(scoville);
        int min = heap.poll();
        while (min < K) {
            if (heap.isEmpty())
                return -1;
            int nextMin = heap.poll();
            heap.add(min + (nextMin * 2));
            answer++;
            min = heap.poll();
        }
        return answer;
    }

    /*
    // 재귀함수를 자주 사용하게 되면 메모리 부족 문제 발생하여 Runtime오류가 발생.
    int mix(Heap heap, int K, int min) {
        int result = 0;
        if (min < K) {
            if (heap.isEmpty()) {
                System.out.println(heap.heap.toString());
                result = -1; // 마지막 poll 값이 K보다 낮고 heap이 비어있는 상태가 된다면 스코빌 지수를 만들 수 없음.
            } else {
                int nextMin = heap.poll();
                heap.add(min + (nextMin * 2));
                result++;
                int temp = mix(heap, K, heap.poll());
                result = (temp > -1) ? result + temp : temp;
                // System.out.println("[MIX] min : " + min + ", nextMin : " + nextMin + ", value : " + newValue);
            }
        }
        return result;
    }
     */

    static class Heap {
        List<Integer> heap;

        Heap (int[] array) {
            this.heap = new ArrayList<>();
            heap.add(0);
            for (int i : array) {
                add(i);
            }
            // System.out.println(heap.toString());
        }

        boolean isEmpty() {
            return heap.size() < 2;
        }

        int poll() {
            return delete();
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
                // System.out.println(heap.toString());
            }
        }

        int delete() {
            int index = 1;
            int result = heap.get(index);
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
                // System.out.println(heap.toString());
            }
            return result;
        }

        public boolean change(int source, int target) {
            boolean flag = false;
            if (heap.get(source) > heap.get(target)) {
                int temp = heap.get(target);
                heap.set(target, heap.get(source));
                heap.set(source, temp);
                flag = true;
            }
            return flag;
        }
    }

}
