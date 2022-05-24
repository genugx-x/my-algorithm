package org.genug.algorithm;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            br.readLine();
            bw.flush();
        } catch (IOException e) {
        } finally {
            try { br.close(); } catch (IOException e) {}
            try { bw.close(); } catch (IOException e) {}
        }
    }
}