package org.genug.algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int inven = Integer.parseInt(line[2]);

        Map<Integer, Integer> map = new TreeMap<>();
        // Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            String[] blocks = scanner.nextLine().split("\\s+"); // 두번째 줄 입력받기
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(blocks[j]);
                if (map.containsKey(height)) {
                    map.replace(height, map.get(height) + 1);
                } else {
                    map.put(height, 1);
                }
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int blockAmount = inven;
            Map.Entry<Integer, Integer> entry = iterator.next();
            while (iterator.hasNext()) {
                entry.getValue();
            }
        }
        System.out.println(map.toString());
    }
}