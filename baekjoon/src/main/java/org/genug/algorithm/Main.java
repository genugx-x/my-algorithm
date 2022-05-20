package org.genug.algorithm;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        if (n%4 == 0 && (n%100 != 0 || n%400 == 0))
            result = 1;
        System.out.println(result);
    }
}