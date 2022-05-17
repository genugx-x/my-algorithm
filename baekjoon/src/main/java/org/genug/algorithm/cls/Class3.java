package org.genug.algorithm.cls;

import java.util.Scanner;

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
}
