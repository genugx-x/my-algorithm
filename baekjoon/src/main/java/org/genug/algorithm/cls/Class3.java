package org.genug.algorithm.cls;

import org.genug.algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Class3 {
    public void organicCabbage() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        while (testCaseCount > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            int width = Integer.parseInt(line[0]);
            int depth = Integer.parseInt(line[1]);
            int[][] field = new int[depth][width];
            int[][] visitCounts = new int[depth][width];
            boolean[][] checkedField = new boolean[depth][width];
            int pointCount = Integer.parseInt(line[2]);
            while (pointCount > 0) {
                String[] point = scanner.nextLine().split("\\s+");
                width = Integer.parseInt(point[0]);
                depth = Integer.parseInt(point[1]);
                field[depth][width] = 1;
                pointCount--;
            }

            int result = 0;
            boolean flag = false;
            for (int d = 0; d < field.length; d++) {
                for (int w = 0; w < field[d].length; w++) {
                    visitCounts[d][w]++;
                    if (!checkedField[d][w]) {
                        if (field[d][w] == 1) {
                            result++;
                            System.out.println("field[" + d + "]["+ w + "]");
                            search(checkedField, field, d, w);
                        }
                    }
                    // checkedField[d][w] = true;
                }
            }
            System.out.println("result : " + result);

            testCaseCount--;
        }
    }

    void search(int[][] visitCounts, boolean[][] checkedField, int[][] field, int d, int w) {
        if (d < checkedField.length) {
            for (; w < checkedField[d].length; w++) {
                visitCounts[d][w]++;
                checkedField[d][w] = true;
                if (field[d][w] == 1) {
                    search(visitCounts, checkedField, field, d+1, w);
                } else {
                    return;
                }
            }
        }
    }

    void search(boolean[][] checkedField, int[][] field, int d, int w) {
        if (w > 0) {
            if (!checkedField[d][w-1]) {
                checkedField[d][w-1] = true;
                if (field[d][w-1] == 1) {
                    search(checkedField, field, d, w-1);
                }
            }
        }
        if (w < field[0].length - 1) {
            if (!checkedField[d][w+1]) {
                checkedField[d][w+1] = true;
                if (field[d][w+1] == 1) {
                    search(checkedField, field, d, w+1);
                }
            }
        }
        if (d > 0) {
            if (!checkedField[d-1][w]) {
                checkedField[d-1][w] = true;
                if (field[d-1][w] == 1) {
                    search(checkedField, field, d-1, w);
                }
            }
        }
        if (d < field.length - 1) {
            if (!checkedField[d+1][w]) {
                checkedField[d+1][w] = true;
                if (field[d+1][w] == 1) {
                    search(checkedField, field, d+1, w);

                }
            }
        }
    }

    // 1260 - DFS와 BFS (완료)
    // BFS의 로직의 흐름을 잘못 구현한 것과 문제의 설명이 부족하다고 생각
    // 1. 주어진 시작지점 v 부터 탐색 지점이 끝나면 다른 연결되지 않은 간선은 필요없었다.
    // 2. m개 만큼 입력된 간선에 v는 없을 수도 있다. 따라서 입력 간선들에 v가 없다면 v만 출력하면 된다.
    public void dfsAndBfs() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();

        Map<Integer, Node> dfsMap = new HashMap<>();
        Map<Integer, Node> bfsMap = new HashMap<>();
        List<Integer> inputs = new ArrayList<>();
        inputs.add(v);
        while (m > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (!dfsMap.containsKey(a)) {
                dfsMap.put(a, new Node(a));
                bfsMap.put(a, new Node(a));
            }
            if (!dfsMap.containsKey(b)) {
                dfsMap.put(b, new Node(b));
                bfsMap.put(b, new Node(b));
            }
            if (!inputs.contains(a))
                inputs.add(a);

            dfsMap.get(a).neighbors.add(b);
            dfsMap.get(b).neighbors.add(a);
            bfsMap.get(a).neighbors.add(b);
            bfsMap.get(b).neighbors.add(a);
            m--;
        }
        for (Map.Entry<Integer, Node> entry : dfsMap.entrySet()) {
            entry.getValue().sort();
            bfsMap.get(entry.getKey()).sort();
        }
        if (dfsMap.get(v) == null) {
            System.out.print(v + "\n" + v);
            return;
        }
        dfs(dfsMap, v);
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();

        bfsMap.get(v).visitFlag = true;
        queue.add(v);
        System.out.print(v);
        bfs(bfsMap, queue);
    }

    void dfs(Map<Integer, Node> map, int n) {
        Node node =  map.get(n);
        if (node != null && !node.visitFlag) {
            System.out.print(n);
            node.visitFlag = true;
        } else {
            return;
        }
        System.out.print(" ");
        for (int i : map.get(n).neighbors) {
            dfs(map, i);
        }
    }

    void bfs(Map<Integer, Node> map, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : map.get(n).neighbors) {
                Node neighbor = map.get(i);
                if (neighbor != null && !neighbor.visitFlag) {
                    System.out.print(" " + i);
                    neighbor.visitFlag = true;
                    queue.add(i);
                }
            }
        }
    }

    class Node {
        Integer number;
        List<Integer> neighbors;
        Boolean visitFlag;


        public Node(int number) {
            this.number = number;
            this.neighbors = new ArrayList<>();
            this.visitFlag = false;
        }

        void sort() {
            Collections.sort(neighbors);
        }
    }

    // 11724 - 연결 요소의 개수
    public void numberOfConnectingElements() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[n+1];
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        while (m > 0) {
            input = scanner.nextLine().split("\\s+");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            map.get(a).add(b);
            map.get(b).add(a);
            m--;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result++;
                visited[i] = true;
                dfs(visited, map, i);
            }
        }
        System.out.println(result);
    }

    public void dfs(boolean[] visited, Map<Integer, List<Integer>> map, int n) {
        if (!visited[n])
            visited[n] = true;
        if (map.get(n) == null)
            return;
        for (Integer i : map.get(n)) {
            if (!visited[i])
                dfs(visited, map, i);
        }

    }

    // 2667 - 단지번호 붙이기
    public void apartmentComplexNumbering() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean[][] visited = new boolean[n][n];
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < arr.length; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (chars[j] == '1');
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (arr[i][j]) {
                        int result = search(i, j, visited, arr) + 1;
                        System.out.println("startpoint : " + i + " " + j + " : " + result);
                        results.add(result);
                        System.out.println();
                        System.out.println();
                    }
                }
            }
        }

//        for (boolean[] barr : visited) {
//            System.out.println(Arrays.toString(barr));
//        }
        System.out.println(results.size());
        Collections.sort(results);
        for (int result : results) {
            System.out.println(result);
        }
    }
    public int search(int i, int j, boolean[][] visited, boolean[][] arr) {
        int result = 0;
        int length = visited.length;
        // 좌
        if (j-1 >= 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            if (arr[i][j-1]) {
                result++;
                result += search(i, j-1, visited, arr);
            }
        }
        // 우
        if (j+1 < length && !visited[i][j+1]) {
            visited[i][j+1] = true;
            if (arr[i][j+1]) {
                result++;
                result += search(i, j+1, visited, arr);
            }
        }
        // 상
        if (i-1 >= 0 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            if (arr[i-1][j]) {
                result++;
                result += search(i-1, j, visited, arr);
            }
        }
        // 하
        if (i+1 < length && !visited[i+1][j]) {
            visited[i+1][j] = true;
            if (arr[i+1][j]) {
                result++;
                result += search(i+1, j, visited, arr);
            }
        }
        return result;
    }


    // 2178 - 미로탐색
    public void eploreTheMaze() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[][] arr = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (chars[j] == '1');
            }
        }
        start(visited, arr);
    }

    Queue<Queue<int[]>> queue = new LinkedList<>();
    public void start(boolean[][] visited, boolean[][] arr) {
        Queue<int[]> temp = new LinkedList<>();
        temp.add(new int[] {0, 0, 0});
        queue.add(temp);

        while (!queue.isEmpty()) {
            Queue<int[]> inner = queue.poll();
            Queue<int[]> next = new LinkedList<>();
            while (!inner.isEmpty()) {
                int[] iarr = inner.poll();
                int i = iarr[0];
                int j = iarr[1];
                int count = iarr[2];
                search(i, j, visited, arr, next, count);
            }
            if (!next.isEmpty())
                queue.add(next);
        }
    }

    public void search(int i, int j, boolean[][] visited, boolean[][] arr, Queue<int[]> next, int count) {
        int n = visited.length;
        int m = visited[0].length;

        count++;

        if (i+1 == n && j+1 == m) {
            System.out.println(count);
            return;
        }
        // 하
        if (i+1 < n && !visited[i+1][j]) {
            if (arr[i+1][j]) {
                visited[i+1][j] = true;
                next.add(new int[] {i+1, j, count});
            }
        }
        // 우
        if (j+1 < m && !visited[i][j+1]) {
            if (arr[i][j+1]) {
                visited[i][j+1] = true;
                next.add(new int[] {i, j+1, count});
            }
        }
        // 상
        if (i-1 >= 0 && !visited[i-1][j]) {
            if (arr[i-1][j]) {
                visited[i-1][j] = true;
                next.add(new int[] {i-1, j, count});
            }
        }
        // 좌
        if (j-1 >= 0 && !visited[i][j-1]) {
            if (arr[i][j-1]) {
                visited[i][j-1] = true;
                next.add(new int[] {i, j-1, count});
            }
        }
    }
    
}
