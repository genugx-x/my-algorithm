package org.genug.algorithm.cls;

import java.util.Arrays;

public class Class2 {

    public String palindromeNumber(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " " + chars[chars.length-1-i]);
            if (chars[i] != chars[chars.length-1-i])
                return "no";
        }
        return "yes";
    }

    public int willBeWomenPresident(int k, int n) {
        int[] currentFloor = new int[n];
        int[] downStairs = null;
        for (int i = 0; i <= k; i++) {
            if (i == 0) {
                for (int j = 0; j < currentFloor.length; j++) {
                    currentFloor[j] = j+1;
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
        System.out.println("currentFloor : " + Arrays.toString(currentFloor));
        System.out.println("downStairs : " + Arrays.toString(downStairs));
        return currentFloor[currentFloor.length-1];
    }
}