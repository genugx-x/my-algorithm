package org.genug.algorithm;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                try {
                    String line = br.readLine();
                    String[] numbers = line.split("\\s+");
                    int a = Integer.parseInt(numbers[0]);
                    int b = Integer.parseInt(numbers[1]);
                    System.out.println(a + b);
                } catch(NullPointerException ne) {
                    break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch(IOException ioe) {}
        }
    }
}