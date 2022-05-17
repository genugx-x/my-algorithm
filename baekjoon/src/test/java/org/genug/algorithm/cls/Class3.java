package org.genug.algorithm.cls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
