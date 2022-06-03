package org.genug.algorithm.cls;

import java.util.*;

public class Class7 {
    // 16903 - 수열과 쿼리 20
    public void sequencesAndQueries20(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        while (m > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            int q = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            switch (q) {
                case 1:
                    list.add(x);
                    if (!map.containsKey(list))
                        map.put(x, 0);
                    map.replace(x, map.get(x) + 1);
                    break;
                case 2:
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == x)
                            list.remove(i);
                    }
                    break;
                case 3:
                    int max = 0;
                    for (int i : list) {
                        max = Math.max(i ^ x, max);
                    }
                    System.out.println(max);
                    break;
            }
            m--;
        }
    }
}
