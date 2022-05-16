package org.genug.algorithm.cls;

import java.util.Scanner;

public class Class2 {
    public void palindromeNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0"))
                break;
            char[] chars = input.toCharArray();
            boolean flag = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != chars[chars.length-1-i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("no");
                continue;
            }
            System.out.println("yes");
        }
    }

    public void willBeWomenPresident() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        while (testCaseCount > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[] currentFloor = new int[n];
            int[] downStairs = null;
            for (int i = 0; i <= k; i++) {
                if (i == 0) {
                    for (int j = 0; j < currentFloor.length; j++) {
                        currentFloor[j] = j + 1;
                    }
                } else {
                    downStairs = currentFloor;
                    currentFloor = new int[n];
                    for (int t = 0; t < currentFloor.length; t++) {
                        for (int l = 0; l <= t; l++) {
                            currentFloor[t] += downStairs[l];
                        }
                    }
                }
            }
//            System.out.println("currentFloor : " + Arrays.toString(currentFloor));
//            System.out.println("downStairs : " + Arrays.toString(downStairs));
            System.out.println(currentFloor[currentFloor.length - 1]);
            testCaseCount--;
        }
    }
}
