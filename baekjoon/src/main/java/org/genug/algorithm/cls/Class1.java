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

    public void constant() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        sb.append(scanner.next()).reverse();
        a = Integer.parseInt(sb.toString());
        sb.setLength(0);
        sb.append(scanner.nextInt()).reverse();
        b = Integer.parseInt(sb.toString());
        System.out.println(Math.max(a, b));
    }

    public void scale() {
        String message = null;
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        int[] scales = new int[8];
        for (int i = 0; i < line.length; i++) {
            scales[i] = Integer.parseInt(line[i]);
        }
        for (int i = 0; i < scales.length; i++) {
            if (scales[0] == 1) {
                message = "ascending";
                if (scales[i] != i+1) {
                    message = null;
                    break;
                }
            } else if (scales[0] == 8) {
                message = "descending";
                if (scales[i] != scales.length-i) {
                    message = null;
                    break;
                }
            }
        }
        if (message == null)
            message = "mixed";
        System.out.println(message);
    }

    public void remain() {
        int[] remains = new int[10];
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (count < 10) {
            remains[count] = Integer.parseInt(scanner.nextLine()) % 42;
            count++;
        }
        for (int i = 0; i < remains.length; i++) {
            for (int j = 0; j < remains.length; j++) {
                if (i == j)
                    continue;
                if (remains[i] == remains[j]) {
                    remains[i] = -1;
                    break;
                }
            }
        }
        int result = 0;
        for (int remain : remains) {
            if (remain > -1)
                result++;
        }
        System.out.println(result);
    }

    // 괄호 문자열(Parenthesis String, PS)
    // 올바른 괄호 문자열 (Valid PS, VPS)
    public void vps() {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        while (count > 0) {
            String message = "NO";
            char[] ps = scanner.nextLine().toCharArray();
            try {
                Stack<Boolean> stack = new Stack<>();
                for (char p : ps) {
                    if (p == '(')
                        stack.push(true);
                    else
                    if (stack.peek()) stack.pop();
                }
                // System.out.println(stack.toString());
                if (stack.isEmpty())
                    message = "YES";
            } catch (EmptyStackException e) {
                // e.printStackTrace();
                message = "NO";
            }
            System.out.println(message);
            count--;
        }
    }

    public void organicCabbage() {

    }

}
