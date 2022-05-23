package org.genug.algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long max = 0;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long input = scanner.nextLong();
            max = Math.max(input, max);
            list.add(input);
        }
        list.sort(Collections.reverseOrder());

        long temp = 0;
        List<Long> ranges = new ArrayList<>();
        for (Long i : list) {
            if (temp > 0)
                ranges.add(temp - i);
            temp = i;
        }
        ranges.add(temp);

        long multiple = 0;
        for (Long range : ranges) {
            multiple++;
            long treesCount = multiple * range;
            if(treesCount > m) {
                long t = m/multiple;
                if (m%multiple > 0) {
                    t++;
                }
                max -= t;
                break;
            } else {
                m -= treesCount;
                max -= range;
            }
        }
        System.out.println(max);
    }
}