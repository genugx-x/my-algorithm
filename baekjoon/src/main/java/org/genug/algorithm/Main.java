package org.genug.algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        while (testCaseCount > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            line = scanner.nextLine().split("\\s+");
            Queue<Document> queue = new LinkedList<>();
            Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                int p = Integer.parseInt(line[i]);
                queue.add(new Document(p, i == m));
                priorityQueue.add(p);
            }

            int result = 0;
            while (!priorityQueue.isEmpty()) {
                int i = priorityQueue.peek(); // 출력되어야 할 문서 중요도
                Document document = queue.poll();
                if (document.importance == i) {
                    priorityQueue.poll();
                    result++;
                    if (document.flag)
                        break;
                } else {
                    queue.add(document);
                }
            }

            System.out.println(result);
            testCaseCount--;
        }

    }

    static class Document {
        int importance;
        boolean flag;
        public Document (int importance, boolean flag) {
            this.importance = importance;
            this.flag = flag;
        }
    }

}