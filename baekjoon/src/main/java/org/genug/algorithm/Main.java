package org.genug.algorithm;
import java.util.*;

public class Main {

    static List<Integer> roots = new ArrayList<>();
    public static void main(String[] args) {
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
        search(0, 0, visited, arr, 0);
        System.out.println(roots.toString());
        Collections.sort(roots);
        System.out.println(roots.get(0));

    }

    public static void search(int i, int j, boolean[][] visited, boolean[][] arr, int count) {
        int n = visited.length;
        int m = visited[0].length;

        count++;
        visited[i][j] = true;
        System.out.println(i + " " + j);

        // 끝점
        if (i+1 == n && j+1 == m) {
            visited[i][j] = false;
            roots.add(count);
            System.out.println();
            System.out.println();
            return;
        }

        boolean flag = false;
        if (i == 0 && j == 21) {
            flag = true;
            for (boolean[] b : visited) {
                for (boolean b1 : b) {
                    System.out.print((b1 ? "O" : "X") + " ");
                }
                System.out.println();
            }
        }


        // 우
        if (j+1 < m && !visited[i][j+1]) {
            if (arr[i][j+1]) {
                search(i, j+1, visited, arr, count);
            }
        }
        // 하
        if (i+1 < n && !visited[i+1][j]) {
            if (arr[i+1][j]) {
                if (flag) {
                    System.out.println("===> " + (i+1) + " " + j);
                }
                search(i+1, j, visited, arr, count);
            }
        }
        // 좌
        if (j-1 >= 0 && !visited[i][j-1]) {
            if (arr[i][j-1]) {
                search(i, j-1, visited, arr, count);
            }
        }
        // 상
        if (i-1 >= 0 && !visited[i-1][j]) {
            if (arr[i-1][j]) {
                search(i-1, j, visited, arr, count);
            }
        }
    }
}