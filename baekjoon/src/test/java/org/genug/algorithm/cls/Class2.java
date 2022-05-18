package org.genug.algorithm.cls;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    public int deliverySugar(int sugar) {
        int count = 0;
        boolean flag = false;
        while (true) {
            if (sugar == 0) {
                break;
            } else if (sugar >= 5 && !flag) {
                count = sugar/5;
                if ((sugar % 5) == 0) {
                    break;
                } else {
                    while (count > 0) {
                        int temp = sugar;
                        temp -= (count * 5);
                        temp %= 3;
                        if (temp == 0) {
                            count += (sugar - count*5) / 3;
                            sugar = 0;
                            break;
                        }
                        count--;
                    }
                }
                flag = true;
            } else {
                count = sugar/3;
                if ((sugar % 3) > 0) {
                    count = -1;
                }
                break;
            }
        }
        return count;
    }

    public int queue(String[] commands) {
        Queue<Integer> queue = new LinkedList<>();
        String command = commands[0];
        int output = 0;
        switch (command) {
            case "push":
                queue.add(Integer.parseInt(commands[1]));
                break;
            case "pop":
                output = -1;
                if (!queue.isEmpty())
                    output = queue.poll();
                System.out.println(output);
                break;
            case "size":
                System.out.println(queue.size());
                break;
            case "empty":
                output = 0;
                if (queue.isEmpty())
                    output = 1;
                System.out.println(output);
                break;
            case "front":
                output = -1;
                if (!queue.isEmpty())
                    output = queue.peek();
                System.out.println(output);
                break;
            case "back":
                output = -1;
                if (!queue.isEmpty()) {
                    int size = queue.size();
                    while (size > 0) {
                        if (size == 0)
                            System.out.println(queue.peek());
                        queue.add(queue.poll());
                        size--;
                    }
                }
                System.out.println(output);
                break;
        }
        return 0;
    }
}