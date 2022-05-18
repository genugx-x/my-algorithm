package org.genug.algorithm.cls;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
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
            System.out.println(currentFloor[currentFloor.length - 1]);
            testCaseCount--;
        }
    }

    public void deliverySugar() {
        Scanner scanner = new Scanner(System.in);
        int sugar = scanner.nextInt();
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
        System.out.println(count);
    }

    public void queue() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int back = 0;
            while(count > 0) {
                String[] commands = br.readLine().split("\\s+");
                switch (commands[0]) {
                    case "push":
                        back = Integer.parseInt(commands[1]);
                        queue.add(back);
                        break;
                    case "pop":
                        if (queue.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(queue.poll() + "\n");
                        break;
                    case "size":
                        bw.write(queue.size() + "\n");
                        break;
                    case "empty":
                        if (queue.isEmpty())
                            bw.write(1 + "\n");
                        else
                            bw.write(0 + "\n");
                        break;
                    case "front":
                        if (queue.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(queue.peek() + "\n");
                        break;
                    case "back":
                        if (queue.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(back + "\n");
                        break;
                }
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch (IOException ioe) {};
            try { bw.close(); } catch (IOException ioe) {};
        }
    }

    public void deque() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            int back = 0;
            while(count > 0) {
                String[] commands = br.readLine().split("\\s+");
                switch (commands[0]) {
                    case "push_front":
                        deque.addFirst(Integer.parseInt(commands[1]));
                        break;
                    case "push_back":
                        deque.addLast(Integer.parseInt(commands[1]));
                        break;
                    case "pop_front":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.removeFirst() + "\n");
                        break;
                    case "pop_back":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.removeLast() + "\n");
                        break;
                    case "size":
                        bw.write(deque.size() + "\n");
                        break;
                    case "empty":
                        if (deque.isEmpty())
                            bw.write(1 + "\n");
                        else
                            bw.write(0 + "\n");
                        break;
                    case "front":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.peekFirst() + "\n");
                        break;
                    case "back":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.peekLast() + "\n");
                        break;
                    case "list":
                        bw.write(deque.toString());
                        break;
                }
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch (IOException ioe) {};
            try { bw.close(); } catch (IOException ioe) {};
        }
    }
}
