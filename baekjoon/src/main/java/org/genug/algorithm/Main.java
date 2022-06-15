package org.genug.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int m;
    static boolean[][] map;
    static boolean[][] visited;
    static Queue<Queue<int[]>> queue;
    static Queue<int[]> next;
    static boolean resultFlag;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split("\\s+");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            map = new boolean[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    map[i][j] = chars[j] == '1';
                }
            }

            queue = new LinkedList<>();
            Queue<int[]> tasks = new LinkedList<>();
            tasks.add(new int[] {0, 0, 0, 1});
            queue.add(tasks);

//            while (!queue.isEmpty()) {
//                tasks = queue.poll();
//                Queue<int[]> next = new LinkedList<>();
//                while (!tasks.isEmpty()) {
//                    int[] task = tasks.poll();
//                    bfs(task, next);
//                }
//
//
//
////                for (int i = 0; i < visited.length; i++) {
////                    System.out.println();
////                    for (int j = 0; j < visited[i].length; j++) {
////
////                        if (map[i][j]) {
////                            if (visited[i][j])
////                                System.out.print('/');
////                            else
////                                System.out.print('|');
////                            continue;
////                        }
////                        System.out.print(visited[i][j] ? 'O' : 'X');
////                    }
////                }
////                System.out.println();
////                Thread.sleep(500);
//
//                if (!next.isEmpty())
//                    queue.add(next);
//            }


            next = new LinkedList<>();
            next.add(new int[] {0, 0, 0, 1});
            while (!next.isEmpty()) {
                bfs(next.poll());
            }

            if (!resultFlag)
                System.out.println(-1);

        } catch (IOException ignored) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }

    static void bfs (int[] task
                     //Queue<int[]> next
    ) throws InterruptedException {
        int i = task[0];
        int j = task[1];
        int count = task[2];
        boolean flag = task[3] == 1;
        visited[i][j] = true;
        count++;

        System.out.println();
        System.out.println(i + " " + j + " " + flag);
        for (int v = 0; v < visited.length; v++) {
            for (int p = 0; p < visited[v].length; p++) {
                if (v == i && p == j) {
                    System.out.print('H');
                    continue;
                }
                if (map[v][p]) {
                    if (visited[v][p])
                        System.out.print('/');
                    else
                        System.out.print('|');
                    continue;
                }
                System.out.print(visited[v][p] ? 'O' : 'X');
            }
            System.out.println();
        }
        System.out.println();
        Thread.sleep(500);

        if (resultFlag)
            return;

        if (i+1 == n && j+1 == m) {
            System.out.println(count);
            resultFlag = true;
            return;
        }
        if (i+1 < n && !visited[i+1][j]) {
            if (!map[i+1][j]) {
                visited[i+1][j] = true;
                next.add(new int[] {i+1, j, count, flag ? 1 : 0});
            } else {
                if (flag) {
                    visited[i+1][j] = true;
                    next.add(new int[] {i+1, j, count, 0});
                }
            }
        }
        if (j+1 < m && !visited[i][j+1]) {
            if (!map[i][j+1]) {
                visited[i][j+1] = true;
                next.add(new int[] {i, j+1, count, flag ? 1 : 0});
            } else {
                if (flag) {
                    visited[i][j+1] = true;
                    next.add(new int[] {i, j+1, count, 0});
                }
            }
        }
        if (i-1 >= 0 && !visited[i-1][j]) {
            if (!map[i-1][j]) {
                visited[i-1][j] = true;
                next.add(new int[] {i-1, j, count, flag ? 1 : 0});
            } else {
                if (flag) {
                    visited[i-1][j] = true;
                    next.add(new int[] {i-1, j, count, 0});
                }
            }
        }
        if (j-1 >= 0 && !visited[i][j-1]) {
            if (!map[i][j-1]) {
                visited[i][j-1] = true;
                next.add(new int[] {i, j-1, count, flag ? 1 : 0});
            } else {
                if (flag) {
                    visited[i][j-1] = true;
                    next.add(new int[]{i, j-1, count, 0});
                }
            }
        }
    }
}