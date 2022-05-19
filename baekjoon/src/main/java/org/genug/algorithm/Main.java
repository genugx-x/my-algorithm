package org.genug.algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
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
    static void dfs(int searchPoint, Map<Integer, SearchInfo> map, List<Integer> result) {
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

    static void bfs(int searchPoint, Map<Integer, SearchInfo> map, List<Integer> result, int count) {
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

    static class SearchInfo {
        List<Integer> list;
        Boolean flag;

        public SearchInfo() {
            this.list = new ArrayList<>();
            this.flag = false;
        }
    }
}