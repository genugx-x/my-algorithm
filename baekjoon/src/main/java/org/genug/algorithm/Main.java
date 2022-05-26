package org.genug.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split("\\s+");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        int totalCableLength = 0;
        List<Integer> cables = new ArrayList<>();
        while (k > 0) {
            int cable = Integer.parseInt(br.readLine());
            totalCableLength += cable;
            cables.add(cable);
            k--;
        }
        int cuttingSize = (totalCableLength / n);
        System.out.println("cuttingSize (start): " + cuttingSize);
        int max = 0;
        int min = 0;

        int cuttedCableCount = 0;
        for (Integer cable : cables) {
            int eachCuttedCableCount = (cable / cuttingSize);
            cuttedCableCount += eachCuttedCableCount;
        }

        double newCuttingSize = cuttedCableCount

        br.close();
        bw.close();
    }
}