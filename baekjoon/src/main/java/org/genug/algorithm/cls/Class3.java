package org.genug.algorithm.cls;

import org.genug.algorithm.Main;

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

    // 2606 - 바이러스
    public void virus() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int m = Integer.parseInt(scanner.nextLine());
        Computer[] computers = new Computer[n+1];
        for (int i = 1; i < computers.length; i++) {
            computers[i] = new Computer(i);
        }
        while (m > 0) {
            String[] inputs = scanner.nextLine().split("\\s+");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            if (!computers[a].networks.contains(b))
                computers[a].networks.add(b);
            if (!computers[b].networks.contains(a))
                computers[b].networks.add(a);
            m--;
        }

        int result = dfs(1, computers)-1; // 1번 제외
        System.out.println(result);
    }

    public int dfs(int n, Computer[] computers) {
        int result = 1;
        Computer com = computers[n];
        com.visitFlag = true;
        for (int i = 0; i < com.networks.size(); i++) {
            int network = com.networks.get(i);
            if (!computers[network].visitFlag)
                result += dfs(network, computers);
        }
        return result;
    }

    class Computer {
        Integer number;
        Boolean visitFlag;
        List<Integer> networks;

        public Computer(int number) {
            this.number = number;
            this.visitFlag = false;
            this.networks = new ArrayList<>();
        }
    }


    // static Queue<Queue<int[]>> queue = new LinkedList<>();
    static int zeroCount = 0;
    public void tomato () {
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


    public void start(int[][] storage) {
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

    public void search(int i, int j, int[][] storage, Queue<int[]> next) {
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

    Queue<int[]> queue1697 = new LinkedList<>();
    public void hideAndSeek() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] visited = new boolean[100001];

        visited[n] = true;
        queue1697.add(new int[]{n, 0});
        while (!queue1697.isEmpty()) {
            int[] info = queue1697.poll();
            if (info[0] == k) {
                System.out.println(info[1]);
                break;
            }
            dfs(info, visited);
        }
    }

    public void dfs(int[] info, boolean[] visited) {
        int x = info[0];
        int count = info[1]+1;

        // 걷기 -1
        if (x-1 >= 0 && !visited[x-1]) {
            visited[x-1] = true;
            queue1697.add(new int[] {x-1, count});
        }

        // 걷기 +1
        if (x+1 < visited.length && !visited[x+1]) {
            visited[x+1] = true;
            queue1697.add(new int[] {x+1, count});
        }

        // 순간이동
        if (x*2 < visited.length && !visited[x*2]) {
            visited[x*2] = true;
            queue1697.add(new int[] {x*2, count});
        }
    }
    
}
