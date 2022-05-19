package org.genug.algorithm.cls;

import java.util.*;
import java.util.stream.Collectors;

public class Class3 {
    public void organicCabbage(int width, int depth) {
        int[][] field = new int[depth][width];
        boolean[][] checkedField = new boolean[depth][width];
        int[][] visitCounts = new int[depth][width];
        List<Point> points = getPoint();
        for (Point point : points) {
            field[point.depth][point.width] = 1;
        }
        long start = System.currentTimeMillis();
        int result = 0;
        boolean flag = false;
        for (int d = 0; d < field.length; d++) {
            for (int w = 0; w < field[d].length; w++) {
                visitCounts[d][w]++;
                if (!checkedField[d][w]) {
                    checkedField[d][w] = true;
                    if (field[d][w] == 1) {
                        result++;
                        System.out.println("field[" + d + "]["+ w + "]");
                        // search(visitCounts, checkedField, field, d, w);
                        search(checkedField, field, d, w);
                    }
                }
            }
        }
        long end = System.currentTimeMillis();

//        System.out.println("================================================================");
//        for (int[] line : field) {
//            System.out.println(Arrays.toString(line));
//        }
//        System.out.println();
//        for (boolean[] area : checkedField) {
//            System.out.println(Arrays.toString(area));
//        }
//        System.out.println();
//        for (int[] area : visitCounts) {
//            System.out.println(Arrays.toString(area));
//        }
        System.out.println("result(" + ((double)end-start) + ") : " + result);

    }
    static void search(int[][] visitCounts, boolean[][] checkedField, int[][] field, int d, int w) {
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

    static void search(boolean[][] checkedField, int[][] field, int d, int w) {
        // 1. 범위 바깥인지 확인
        // 2. 이미 탐색한 지역인지 확인
        // 3. 배추가 심어졌는지 확인
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


    class Point {
        int width;
        int depth;

        public Point(int width, int depth) {
            this.width = width;
            this.depth = depth;
        }
    }

    public List<Point> getPoint() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        points.add(new Point(1, 0));
        points.add(new Point(1, 1));
        points.add(new Point(4, 2));
        points.add(new Point(4, 3));
        points.add(new Point(4, 5));
        points.add(new Point(2, 4));
        points.add(new Point(3, 4));
        points.add(new Point(7, 4));
        points.add(new Point(8, 4));
        points.add(new Point(9, 4));
        points.add(new Point(7, 5));
        points.add(new Point(8, 5));
        points.add(new Point(9, 5));
        points.add(new Point(7, 6));
        points.add(new Point(8, 6));
        points.add(new Point(9, 6));
        return points;
    }

    public List<Point> getPoint2() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        return points;
    }

    public int[] dfsTest() {
        int count = 0;
        int startpoint = 0;
        List<Integer> dfsResults = new ArrayList<>();
        List<Integer> bfsResults = new ArrayList<>();
        List<int[]> inputs = getDfsEx3Input();
        // Map<Integer, SearchInfo> map = new HashMap<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (i == 0) {
                count = inputs.get(i)[0];
                startpoint = inputs.get(i)[2];
                continue;
            }
            for (int j : inputs.get(i)) {
                map.putIfAbsent(j, false);
            }
        }
        inputs.remove(0);
        System.out.println(map.toString());
        map.replace(startpoint, true);
        dfsResults.add(startpoint);
        while (dfsResults.size() < count) {
            dfs(startpoint, inputs, map, dfsResults);
            if (!map.containsValue(false))
                break;
        }
        System.out.println("dfs : " + dfsResults.toString());
        return null;
    }

    public void bfsTest() {
        int count = 0;
        int startpoint = 0;
        List<Integer> bfsResults = new ArrayList<>();
        List<int[]> inputs = getDfsEx3Input();
        // Map<Integer, SearchInfo> map = new HashMap<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (i == 0) {
                count = inputs.get(i)[0];
                startpoint = inputs.get(i)[2];
                continue;
            }
            for (int j : inputs.get(i)) {
                map.putIfAbsent(j, false);
            }
        }
        inputs.remove(0);
        System.out.println(map.toString());
        map.replace(startpoint, true);
        bfsResults.add(startpoint);
        while (bfsResults.size() < count) {
            bfs(startpoint, inputs, map, bfsResults);
            if (!map.containsValue(false))
                break;
        }
        System.out.println("bfs : " + bfsResults.toString());
    }

    public void dfs(int searchPoint, List<int[]> inputs, Map<Integer, Boolean> map, List<Integer> results) {
        List<Integer> nextPoints = new ArrayList<>();
        for (int[] input : inputs) {
            if (input[0] == searchPoint)
                nextPoints.add(input[1]);
            else if(input[1] == searchPoint)
                nextPoints.add(input[0]);
        }
        // System.out.println(nextPoints.toString());
        try {
            int min = nextPoints.stream()
                    .filter(p -> !map.get(p))
                    .mapToInt(p -> p)
                    .min()
                    .getAsInt();
            results.add(min);
            map.replace(min, true);
            // System.out.println("min : " + min + ", map : " + map.toString());
            dfs(min, inputs, map, results);
        } catch (NoSuchElementException e) {
            return;
        }
    }

    public void bfs(int searchPoint, List<int[]> inputs, Map<Integer, Boolean> map, List<Integer> results) {
        List<Integer> nextPoints = new ArrayList<>();
        for (int[] input : inputs) {
            if (input[0] == searchPoint)
                nextPoints.add(input[1]);
            else if(input[1] == searchPoint)
                nextPoints.add(input[0]);
        }
        // System.out.println(nextPoints.toString());
        nextPoints = nextPoints.stream()
                .filter(p -> !map.get(p))
                .sorted()
                .collect(Collectors.toList());
        for (Integer nextPoint : nextPoints) {
            results.add(nextPoint);
            map.replace(nextPoint, true);
            // System.out.println("nextPoint : " + nextPoint + ", map : " + map.toString());
        }
        for (Integer nextPoint : nextPoints) {
            bfs(nextPoint, inputs, map, results);
        }
        // System.out.println();
    }

    public List<int[]> getDfsEx1Input() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {4, 5, 1});
        inputs.add(new int[] {1, 2});
        inputs.add(new int[] {1, 3});
        inputs.add(new int[] {1, 4});
        inputs.add(new int[] {2, 4});
        inputs.add(new int[] {3, 4});
        return inputs;
    }

    public List<int[]> getDfsEx2Input() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {5, 5, 3});
        inputs.add(new int[] {5, 4});
        inputs.add(new int[] {5, 2});
        inputs.add(new int[] {1, 2});
        inputs.add(new int[] {3, 4});
        inputs.add(new int[] {3, 1});
        return inputs;
    }

    public List<int[]> getDfsEx3Input() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {1000, 1, 1000});
        inputs.add(new int[] {999, 1000});
        return inputs;
    }

    static class SearchInfo {
        Queue<Integer> queue;
        List<Integer> list;
        Boolean flag;

        public SearchInfo() {
            this.list = new ArrayList<>();
            this.queue = new PriorityQueue<>();
            this.flag = false;
        }
        public String toString() {
            return "[" + this.flag + "::" + queue.toString() + "]";
        }

    }

    public void main() {
        int count = 0;
        int startPoint = 0;
        // List<int[]> inputs = getDfsEx3Input();
        List<int[]> inputs = getSearchEx4Input();
        Map<Integer, SearchInfo> dfsMap = new HashMap<>();
        Map<Integer, SearchInfo> bfsMap = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (i == 0) {
                count = inputs.get(i)[0];
                startPoint = inputs.get(i)[2];
                continue;
            }
            int f = inputs.get(i)[0];
            int b = inputs.get(i)[1];

            dfsMap.putIfAbsent(f, new SearchInfo());
            dfsMap.putIfAbsent(b, new SearchInfo());
            dfsMap.get(f).queue.add(b);
            dfsMap.get(b).queue.add(f);
            dfsMap.get(f).list.add(b);
            dfsMap.get(b).list.add(f);

            bfsMap.putIfAbsent(f, new SearchInfo());
            bfsMap.putIfAbsent(b, new SearchInfo());
            bfsMap.get(f).queue.add(b);
            bfsMap.get(b).queue.add(f);
            bfsMap.get(f).list.add(b);
            bfsMap.get(b).list.add(f);
        }

        inputs.remove(0);
        List<Integer> result = new ArrayList<>();
        int c = dfs(startPoint, dfsMap, result, 0);
        System.out.println("dfs(" + c + ") : " + dfsMap.toString());
        System.out.println("dfs(" + c + ") : " + result.toString());

        result = new ArrayList<>();
        result.add(startPoint);
        bfsMap.get(startPoint).flag = true;
        c = 0;
        c = bfs(startPoint, bfsMap, result, 0, count);
        System.out.println("bfs(" + c + ") : " + result.toString());
        System.out.println("bfs(" + c + ") : " + bfsMap.toString());
    }
    public int dfs(int searchPoint, Map<Integer, SearchInfo> map, List<Integer> result, int c) {
        SearchInfo info = map.get(searchPoint);
        info.flag = true;
        result.add(searchPoint);
        while(!info.queue.isEmpty()) {
            int next = info.queue.poll();
            if (!map.get(next).flag) {
                c = dfs(next, map, result, ++c);
            }
        }
        return c;
    }

    public int bfs(int searchPoint, Map<Integer, SearchInfo> map, List<Integer> result, int c, int count) {
        SearchInfo info = map.get(searchPoint);
//        info.queue.forEach(next -> {
//            if (!map.get(next).flag) {
//                map.get(next).flag = true;
//                result.add(next);
//            }
//        });
        Collections.sort(info.list);
        info.list.forEach(next -> {
            if (!map.get(next).flag) {
                map.get(next).flag = true;
                result.add(next);
            }
        });
        while(result.size() < count && !info.list.isEmpty()) {
        // while(result.size() < count && !info.queue.isEmpty()) {
            // int next = info.queue.poll();
            int next = info.list.get(0);
            info.list.remove(0);
            c = bfs(next, map, result, ++c, count);
        }
        return c;
    }

    public List<int[]> getSearchExInput() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {7, 7, 5});
        inputs.add(new int[] {5, 4});
        inputs.add(new int[] {5, 2});
        inputs.add(new int[] {1, 2});
        inputs.add(new int[] {3, 4});
        inputs.add(new int[] {3, 1});
        inputs.add(new int[] {5, 6});
        inputs.add(new int[] {1, 4});
        inputs.add(new int[] {7, 7});
        return inputs;
    }

    public List<int[]> getSearchEx2Input() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {4, 3, 1});
        inputs.add(new int[] {1, 2});
        inputs.add(new int[] {1, 3});
        inputs.add(new int[] {1, 4});
        return inputs;
    }

    public List<int[]> getSearchEx3Input() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {100, 3, 50});
        inputs.add(new int[] {50, 100});
        inputs.add(new int[] {1, 50});
        inputs.add(new int[] {1, 100});
        return inputs;
    }

    public List<int[]> getSearchEx4Input() {
        List<int[]> inputs = new ArrayList<>();
        inputs.add(new int[] {3, 2, 1});
        inputs.add(new int[] {2, 3});
        inputs.add(new int[] {1, 2});
        return inputs;
    }
}
