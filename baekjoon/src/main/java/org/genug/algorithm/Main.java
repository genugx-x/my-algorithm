package org.genug.algorithm;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
        }catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }
}