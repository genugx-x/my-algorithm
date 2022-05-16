package org.genug.algorithm.cls;

import java.util.*;

public class Class1 {

    public double devide(int a, int b) {
        return (double) a/b;
    }

    public int countWords(String sentence) {
        if (sentence.equals(" ")) {
            return 0;
        }
        String[] words = sentence.strip().split("\\s+");
        return words.length;
    }

    // 가장 많이 사용된 알파벳을 대문자로 출력
    // 동일하게 사용된 알파벳이 있는 경우 ? 출력
    public char studyWords(String word) {
        char[] chars = word.toUpperCase().toCharArray();
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
        System.out.println("Result : k - " + result + ", v - " + resultValue);
        if (flag)
           return '?';
        return result;
    }

    public String compareTwoNumbers(int a, int b) {
        String result = null;
        if (a < b)
            result = "<";
        else if (a > b)
            result = ">";
        else
            result = "==";
        return result;
    }

    public double average(String line) {
        String[] words = line.split("\\s+");
        Integer[] points = new Integer[words.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = Integer.parseInt(words[i]);
        }
        Arrays.sort(points, Collections.reverseOrder());

        double max = points[0] * 1.0;
        double total = 0;
        for (int point : points) {
            total += point / max * 100;
        }

        return total / points.length;
    }

}
