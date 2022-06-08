package org.genug.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) {
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

            // 1 분

        }catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }

}