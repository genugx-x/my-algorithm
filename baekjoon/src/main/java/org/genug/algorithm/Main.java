package org.genug.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
        } catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }

}