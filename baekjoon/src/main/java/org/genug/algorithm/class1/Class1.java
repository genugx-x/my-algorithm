package org.genug.algorithm.class1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Class1 {

    public void devide() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println();
        int b = scanner.nextInt();
        scanner.close();
        System.out.println((double) a/b);
    }

    public void countWords() {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String[] words = null;
        if (sentence.equals(" ")) {
            System.out.println(0);
        } else {
            words = sentence.trim().split("\\s+");
            System.out.println(words.length);
        }
        scanner.close();
    }

    public void studyWord() {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next().toUpperCase();
        scanner.close();

        char[] chars = word.toCharArray();
        Map<Character, Integer> alphabetUsingCountMap = new HashMap<>();
        for (char c : chars) {
            Integer count = alphabetUsingCountMap.computeIfPresent(c, (k,v) -> v+1);
            if (count == null)
                alphabetUsingCountMap.put(c, 1);
        }

        Character result = null;
        Integer resultValue = null;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : alphabetUsingCountMap.entrySet()) {
            if (resultValue == null) {
                result = entry.getKey();
                resultValue = entry.getValue();
            } else {
                if (entry.getValue() > resultValue) {
                    result = entry.getKey();
                    resultValue = entry.getValue();
                    flag = false;
                } else if (entry.getValue() == resultValue.intValue()) {
                    flag = true;
                }
            }
        }
        if (flag)
            result = '?';
        System.out.println(result);
    }

}
