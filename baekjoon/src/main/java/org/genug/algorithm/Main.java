package org.genug.algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = 0;
        int min = 0;
        if (n > m) {
            max = n;
            min = m;
        } else {
            max = m;
            min = n;
        }
        for (int i = min; i > 0; i--) {
            if (min % i == 0) {
                int t = min / i;
                if (max % i == 0) {
                    System.out.println("최대공약수 : " + i);
                    break;
                }
            }
        }

        int count = 1;
        while (true) {
            int multiple = count * max;
            if (multiple % min == 0) {
                System.out.println("최소공배수 : " + multiple);
                break;
            }
            count++;
        }

    }

}