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

    public void dfsBfs() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = br.readLine().split("\\s+");
            int count = Integer.parseInt(line[0]);
            int inputCount = Integer.parseInt(line[1]);
            int startPoint = Integer.parseInt(line[2]);
            Map<Integer, SearchInfo> dfsMap = new HashMap<>();
            Map<Integer, SearchInfo> bfsMap = new HashMap<>();
            List<int[]> list = new ArrayList<>();
            while (inputCount > 0) {
                line = br.readLine().split("\\s+");
                int[] numbers = {Integer.parseInt(line[0]), Integer.parseInt(line[1])};

                int f = numbers[0];
                int b = numbers[1];

                dfsMap.putIfAbsent(f, new SearchInfo());
                dfsMap.putIfAbsent(b, new SearchInfo());
                dfsMap.get(f).list.add(b);
                dfsMap.get(b).list.add(f);

                bfsMap.putIfAbsent(f, new SearchInfo());
                bfsMap.putIfAbsent(b, new SearchInfo());
                bfsMap.get(f).list.add(b);
                bfsMap.get(b).list.add(f);

                list.add(numbers);
                inputCount--;

            }
            List<Integer> result = new ArrayList<>();
            dfs(startPoint, dfsMap, result);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size()-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            result = new ArrayList<>();
            result.add(startPoint);
            bfsMap.get(startPoint).flag = true;
            bfs(startPoint, bfsMap, result, count);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size()-1) {
                    System.out.print(" ");
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch(IOException ioe) {}
        }
    }
    void dfs(int searchPoint, Map<Integer, SearchInfo> map, List<Integer> result) {
        SearchInfo info = map.get(searchPoint);
        info.flag = true;
        result.add(searchPoint);
        while(!info.list.isEmpty()) {
            int next = info.list.get(0);
            info.list.remove(0);
            if (!map.get(next).flag) {
                dfs(next, map, result);
            }
        }
    }

    void bfs(int searchPoint, Map<Integer, SearchInfo> map, List<Integer> result, int count) {
        SearchInfo info = map.get(searchPoint);
        Collections.sort(info.list);
        info.list.forEach(next -> {
            if (!map.get(next).flag) {
                map.get(next).flag = true;
                result.add(next);
            }
        });
        while(result.size() < count && !info.list.isEmpty()) {
            int next = info.list.get(0);
            info.list.remove(0);
            bfs(next, map, result, count);
        }
    }

    class SearchInfo {
        List<Integer> list;
        Boolean flag;

        public SearchInfo() {
            this.list = new ArrayList<>();
            this.flag = false;
        }
    }
}
