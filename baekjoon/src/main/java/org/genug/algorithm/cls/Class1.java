package org.genug.algorithm.cls;

import java.util.*;

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

    public void compareTwoNumbers() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        String[] split = line.split("\\s+");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        if (a < b)
            System.out.println('<');
        else if (a > b)
            System.out.println('>');
        else
            System.out.println("==");
    }

    public void average() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = Integer.valueOf(line);
        line = scanner.nextLine();
        scanner.close();

        String[] words = line.split("\\s+");
        Integer[] points = new Integer[count];
        for (int i = 0; i < points.length; i++) {
            points[i] = Integer.parseInt(words[i]);
        }
        Arrays.sort(points, Collections.reverseOrder());

        double max = points[0] * 1.0;
        double total = 0;
        for (int point : points) {
            total += point / max * 100;
        }
        System.out.println(total / count);
    }

}
