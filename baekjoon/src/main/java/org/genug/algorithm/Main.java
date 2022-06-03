package org.genug.algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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

    public static void dfs(int i, int j, char[][] painting, boolean[][] visited) {
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
}