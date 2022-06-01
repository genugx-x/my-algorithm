package org.genug.algorithm;

import java.util.*;

public class Main {

    static Queue<Queue<int[]>> queue = new LinkedList<>();
    static int zeroCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[][] storage = new int[n][m];
        Queue<int[]> iarrs = new LinkedList<>(); // 시작점 기록
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                int t = scanner.nextInt();
                storage[i][j] = t;
                if (t == 1)
                    iarrs.add(new int[]{i, j});
                else if (t == 0)
                    zeroCount++;

            }
        }
        queue.add(iarrs);
        start(storage);
    }


    public static void start(int[][] storage) {
        int day = 0;
        while (!queue.isEmpty()) {

            System.out.println("day : " + day +", zeroCount : " + zeroCount);
            for (int[] ints : storage) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("=====================");

            Queue<int[]> q = queue.poll();
            Queue<int[]> next = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] coordinate = q.poll();
                search(coordinate[0], coordinate[1], storage, next);
            }
            if (next.size() > 0) {
                queue.add(next);
                day++;
            } else
                break;

            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {}
        }
        if (zeroCount > 0)
            day = -1;
        System.out.println(day);
    }

    public static void search(int i, int j, int[][] storage, Queue<int[]> next) {
        int n = storage.length;
        int m = storage[0].length;

        if (i+1 < n && storage[i+1][j] == 0) {
                storage[i+1][j] = 1;
                zeroCount--;
                next.add(new int[] {i+1, j});
        }

        if (j+1 < m && storage[i][j+1] == 0) {
            storage[i][j+1] = 1;
            zeroCount--;
            next.add(new int[] {i, j+1});
        }

        if (i-1 >= 0 && storage[i-1][j] == 0) {
            storage[i-1][j] = 1;
            zeroCount--;
            next.add(new int[] {i-1, j});
        }

        if (j-1 >= 0 && storage[i][j-1] == 0) {
            storage[i][j-1] = 1;
            zeroCount--;
            next.add(new int[] {i, j-1});
        }
    }
}