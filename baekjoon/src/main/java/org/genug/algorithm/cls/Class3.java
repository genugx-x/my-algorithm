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

    // 1260 - DFS??? BFS (??????)
    // BFS??? ????????? ????????? ?????? ????????? ?????? ????????? ????????? ??????????????? ??????
    // 1. ????????? ???????????? v ?????? ?????? ????????? ????????? ?????? ???????????? ?????? ????????? ???????????????.
    // 2. m??? ?????? ????????? ????????? v??? ?????? ?????? ??????. ????????? ?????? ???????????? v??? ????????? v??? ???????????? ??????.
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

        Integer parent;

        public Node() {
            this.neighbors = new ArrayList<>();
            this.visitFlag = false;
        }

        public Node(int number) {
            this.number = number;
            this.neighbors = new ArrayList<>();
            this.visitFlag = false;
        }

        void sort() {
            Collections.sort(neighbors);
        }
    }

    // 11724 - ?????? ????????? ??????
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

    // 2667 - ???????????? ?????????
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
        // ???
        if (j-1 >= 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            if (arr[i][j-1]) {
                result++;
                result += search(i, j-1, visited, arr);
            }
        }
        // ???
        if (j+1 < length && !visited[i][j+1]) {
            visited[i][j+1] = true;
            if (arr[i][j+1]) {
                result++;
                result += search(i, j+1, visited, arr);
            }
        }
        // ???
        if (i-1 >= 0 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            if (arr[i-1][j]) {
                result++;
                result += search(i-1, j, visited, arr);
            }
        }
        // ???
        if (i+1 < length && !visited[i+1][j]) {
            visited[i+1][j] = true;
            if (arr[i+1][j]) {
                result++;
                result += search(i+1, j, visited, arr);
            }
        }
        return result;
    }


    // 2178 - ????????????
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
        // ???
        if (i+1 < n && !visited[i+1][j]) {
            if (arr[i+1][j]) {
                visited[i+1][j] = true;
                next.add(new int[] {i+1, j, count});
            }
        }
        // ???
        if (j+1 < m && !visited[i][j+1]) {
            if (arr[i][j+1]) {
                visited[i][j+1] = true;
                next.add(new int[] {i, j+1, count});
            }
        }
        // ???
        if (i-1 >= 0 && !visited[i-1][j]) {
            if (arr[i-1][j]) {
                visited[i-1][j] = true;
                next.add(new int[] {i-1, j, count});
            }
        }
        // ???
        if (j-1 >= 0 && !visited[i][j-1]) {
            if (arr[i][j-1]) {
                visited[i][j-1] = true;
                next.add(new int[] {i, j-1, count});
            }
        }
    }

    // 2606 - ????????????
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

        int result = dfs(1, computers)-1; // 1??? ??????
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
        Queue<int[]> iarrs = new LinkedList<>(); // ????????? ??????
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

        // ?????? -1
        if (x-1 >= 0 && !visited[x-1]) {
            visited[x-1] = true;
            queue1697.add(new int[] {x-1, count});
        }

        // ?????? +1
        if (x+1 < visited.length && !visited[x+1]) {
            visited[x+1] = true;
            queue1697.add(new int[] {x+1, count});
        }

        // ????????????
        if (x*2 < visited.length && !visited[x*2]) {
            visited[x*2] = true;
            queue1697.add(new int[] {x*2, count});
        }
    }

    // 4963 - ?????? ??????
    public void numberOfIslands() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if (w+h == 0) {
                break;
            }
            boolean[][] map = new boolean[h][w];
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                input = scanner.nextLine().split("\\s+");
                for (int j = 0; j < w; j++) {
                    map[i][j] = input[j].equals("1");
                }
            }
            int result = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (!visited[i][j]) {
                        if (map[i][j]) {
                            visited[i][j] = true;
                            dfs(i, j, map, visited);
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
    void dfs(int h, int w, boolean[][] map, boolean[][] visited) {

        int n = visited.length;
        int m = visited[0].length;

        // ???????????? ??????
        // ??????
        if (h+1 < n && !visited[h+1][w]) {
            visited[h+1][w] = true;
            if (map[h+1][w])
                dfs(h+1, w, map, visited);
        }
        // ?????????
        if (w+1 < m && !visited[h][w+1]) {
            visited[h][w+1] = true;
            if (map[h][w+1])
                dfs(h, w+1, map, visited);
        }
        // ???
        if (h-1 >= 0 && !visited[h-1][w]) {
            visited[h-1][w] = true;
            if (map[h-1][w])
                dfs(h-1, w, map, visited);
        }
        // ??????
        if (w-1 >= 0 && !visited[h][w-1]) {
            visited[h][w-1] = true;
            if (map[h][w-1])
                dfs(h, w-1, map, visited);
        }

        // ????????? ??????
        // ????????? ??????
        if (h+1 < n && w+1 < m && !visited[h+1][w+1]) {
            visited[h+1][w+1] = true;
            if (map[h+1][w+1])
                dfs(h+1, w+1, map, visited);
        }
        // ?????? ??????
        if (h+1 < n  && w-1 >= 0 && !visited[h+1][w-1]) {
            visited[h+1][w-1] = true;
            if (map[h+1][w-1])
                dfs(h+1, w-1, map, visited);
        }
        // ????????? ???
        if (h-1 >= 0 && w+1 < m && !visited[h-1][w+1]) {
            visited[h-1][w+1] = true;
            if (map[h-1][w+1])
                dfs(h-1, w+1, map, visited);
        }
        // ?????? ???
        if (h-1 >= 0 && w-1 >= 0 && !visited[h-1][w-1]) {
            visited[h-1][w-1] = true;
            if (map[h-1][w-1])
                dfs(h-1, w-1, map, visited);
        }
    }

    List<Integer> results = new ArrayList<>();

    // 1987 - ?????????
    public void alphabet() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        char[][] alphabets = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < r; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < c; j++) {
                alphabets[i][j] = chars[j];
                if (!map.containsKey(chars[j]))
                    map.put(chars[j], false);
            }
        }
        search(0, 0, alphabets, visited, map, 0);

        results.sort(Collections.reverseOrder());
        System.out.println(results.get(0));
    }

    public void search(int r, int c, char[][] alphabets, boolean[][] visited, Map<Character, Boolean> map, int result) {
        boolean flag = false;
        int n = visited.length;
        int m = visited[0].length;

        result++;
        visited[r][c] = true;
        map.replace(alphabets[r][c], true);

        if (r +1 < n && !visited[r + 1][c]) {
            if (!map.get(alphabets[r + 1][c])) {
                search(r + 1, c, alphabets, visited, map, result);
                flag = true;
            }
        }
        if (c + 1 < m && !visited[r][c + 1]) {
            if (!map.get(alphabets[r][c + 1])) {
                search(r, c + 1, alphabets, visited, map, result);
                flag = true;
            }
        }
        if (r - 1 >= 0 && !visited[r - 1][c]) {
            if (!map.get(alphabets[r - 1][c])) {
                search(r - 1, c, alphabets, visited, map, result);
                flag = true;
            }
        }
        if (c - 1 >= 0 && !visited[r][c - 1]) {
            if (!map.get(alphabets[r][c - 1])) {
                search(r, c - 1, alphabets, visited, map, result);
                flag = true;
            }
        }

        map.replace(alphabets[r][c], false);
        visited[r][c] = false;
        if(!flag)
            results.add(result);
    }

    // 10026 - ????????????
    public void redGreenColorWeakness() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] painting = new char[n][n];
        char[][] blindnessPainting = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] blindnessVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] line = scanner.nextLine().toCharArray();
            painting[i] = line;
            for (int j = 0; j < blindnessPainting[i].length; j++) {
                blindnessPainting[i][j] = (line[j] == 'G') ? 'R' : line[j];
            }

        }

        int result = 0;
        int bResult = 0;
        for (int i = 0; i < painting.length; i++) {
            for (int j = 0; j < painting[i].length; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, painting, visited);
                    result++;
                }
                if (!blindnessVisited[i][j]) {
                    dfs(i, j, blindnessPainting, blindnessVisited);
                    bResult++;
                }
            }
        }
        System.out.println(result);
        System.out.println(bResult);
    }

    public void dfs(int i, int j, char[][] painting, boolean[][] visited) {
        int n = visited.length;
        visited[i][j] = true;

        if (i+1 < n && !visited[i+1][j]) {
            if (painting[i][j] == painting[i+1][j])
                dfs(i+1, j, painting, visited);
        }

        if (j+1 < n && !visited[i][j+1]) {
            if (painting[i][j] == painting[i][j+1])
                dfs(i, j+1, painting, visited);
        }

        if (i-1 >= 0 && !visited[i-1][j]) {
            if (painting[i][j] == painting[i-1][j])
                dfs(i-1, j, painting, visited);
        }

        if (j-1 >= 0 && !visited[i][j-1]) {
            if (painting[i][j] == painting[i][j-1])
                dfs(i, j-1, painting, visited);
        }
    }

    // 2583 - ???????????????
    public void findArea() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        boolean[][] area = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        while (k > 0) {
            input = scanner.nextLine().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int xx = Integer.parseInt(input[2]);
            int yy = Integer.parseInt(input[3]);

            for (int i = y; i < yy; i++) {
                for (int j = x; j < xx; j++) {
                    area[i][j] = true;
                }
            }
            k--;
        }
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (!area[i][j] && !visited[i][j])
                    results.add(dfs_2583(i, j, area, visited));
            }
        }
        Collections.sort(results);
        System.out.println(results.size());
        for (Integer result : results) {
            System.out.print(result + " ");
        }
    }

    public int dfs_2583(int i, int j, boolean[][] area, boolean[][] visited) {
        int n = visited.length;
        int m = visited[0].length;

        int result = 1;
        visited[i][j] = true;
        boolean flag = false;

        if (i+1 < n && !visited[i+1][j]) {
            if (!area[i+1][j]) {
                result += dfs_2583(i + 1, j, area, visited);
                flag = true;
            }
        }
        if (j+1 < m && !visited[i][j+1]) {
            if (!area[i][j+1]) {
                result += dfs_2583(i, j + 1, area, visited);
                flag = true;
            }
        }
        if (i-1 >= 0 && !visited[i-1][j]) {
            if (!area[i-1][j]) {
                result += dfs_2583(i - 1, j, area, visited);
                flag = true;
            }
        }
        if (j-1 >= 0 && !visited[i][j-1]) {
            if (!area[i][j-1]) {
                result += dfs_2583(i, j - 1, area, visited);
                flag = true;
            }
        }
        return result;
    }

    boolean flag;
    public void countFamily() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        int[] resultCase = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        int m = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            if (!map.containsKey(x))
                map.put(x, new Node(x));
            if (!map.containsKey(y))
                map.put(y, new Node(y));
            map.get(x).neighbors.add(y);
            map.get(y).neighbors.add(x);
        }
        int result = 0;
        dfs(resultCase[0], resultCase[1], map, 0);
        if (!flag)
            System.out.println(-1);
    }
    void dfs(int source, int target, HashMap<Integer, Node> map, int result) {
        Node node = map.get(source);
        node.visitFlag = true;
        List<Integer> neighbors = node.neighbors;
        result++;

        if (neighbors.contains(target))
            if (!flag) {
                System.out.println(result);
                flag = true;
                return;
            }
        // ??????
        for (int neighbor : node.neighbors) {
            if (!map.get(neighbor).visitFlag) {
                dfs(neighbor, target, map, result);
            }
        }
    }


    int k;
    int v;
    int e;
    Map<Integer, BipartiteNode> map;
    List<Boolean> resultFlags;

    public void bipartiteGraph() {
        Scanner scanner = new Scanner(System.in);
        k = Integer.parseInt(scanner.nextLine());
        while (k > 0) {
            resultFlags = new ArrayList<>();
            String[] input = scanner.nextLine().split("\\s+");
            v = Integer.parseInt(input[0]);
            e = Integer.parseInt(input[1]);
            map = new HashMap<>();
            queue = new LinkedList<>();
            int start = 0;
            while(e > 0) {
                input = scanner.nextLine().split("\\s+");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                if (start == 0)
                    start = a;

                if (!map.containsKey(a))
                    map.put(a, new BipartiteNode(a));
                if (!map.containsKey(b))
                    map.put(b, new BipartiteNode(b));

                map.get(a).neighbors.add(b);
                map.get(b).neighbors.add(a);
                e--;
            }

            for (int i = 1; i <= v; i++) {
                BipartiteNode node = map.get(i);
                if (node != null && node.flag == null) {
                    node.flag = true;
                    dfs(i, map);
                }
            }
            System.out.println(results.isEmpty() ? "YES" : "NO");
            k--;
        }
    }

    void dfs(int i, Map<Integer, BipartiteNode> map) {
        BipartiteNode node = map.get(i);
        for (int neighbor : node.neighbors) {
            if (map.get(neighbor).flag == null) {
                map.get(neighbor).flag = !node.flag;
                dfs(neighbor, map);
            } else {
                if (map.get(neighbor).flag == node.flag) {
                    resultFlags.add(true);
                }
            }
        }
    }

    class BipartiteNode {
        Integer number;
        List<Integer> neighbors;
        Boolean flag;

        public BipartiteNode(int number) {
            this.number = number;
            this.neighbors = new ArrayList<>();
        }
    }

    private Map<Integer, Node> mapFor11725;
    public void findParentsOfTree() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapFor11725 = new HashMap<>();
        try {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n-1; i++) {
                String[] input = br.readLine().split("\\s+");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                if (!mapFor11725.containsKey(a))
                    mapFor11725.put(a, new Node());
                if (!mapFor11725.containsKey(b))
                    mapFor11725.put(b, new Node());
                mapFor11725.get(a).neighbors.add(b);
                mapFor11725.get(b).neighbors.add(a);
            }

            dfs(1);
            System.out.println(mapFor11725.toString());

            for (int i = 2; i <= n; i++) {
                System.out.println(mapFor11725.get(i).parent);
            }

        } catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }
    void dfs(int n) {
        Node node = mapFor11725.get(n);
        node.visitFlag = true;
        for (int i : node.neighbors) {
            Node neighbor = mapFor11725.get(i);
            if (!neighbor.visitFlag) {
                neighbor.parent = n;
                dfs(i);
            }
        }
    }

    // 2573 - ?????? (?????? ???)
    public void iceberg() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[][] arr = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < arr.length; i++) {
                input = br.readLine().split("\\s+");
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            // 1 ???

        }catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }

}
