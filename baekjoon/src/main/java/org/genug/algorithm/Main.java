package org.genug.algorithm;

import java.util.*;

public class Main {

    static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) {
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

    static void search(int r, int c, char[][] alphabets, boolean[][] visited, Map<Character, Boolean> map, int result) {
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

}