package org.genug.algorithm;
import java.util.*;

public class Main {
    public static void main(String[] args) {
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
}