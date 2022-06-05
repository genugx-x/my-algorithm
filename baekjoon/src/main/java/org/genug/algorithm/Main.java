package org.genug.algorithm;

import java.util.*;

public class Main {

    static boolean flag;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        int[] resultCase = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        int m = Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            input = scanner.nextLine().split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            if (!map.containsKey(x))
                map.put(x, new Node(x));
            if (!map.containsKey(y))
                map.put(y, new Node(y));
            map.get(x).neighbors.add(y);
            map.get(y).neighbors.add(x);
        }
        int result = 0;
        dfs(resultCase[0], resultCase[1], map, 0);
        if (!flag)
            System.out.println(-1);
    }
    static void dfs(int source, int target, HashMap<Integer, Node> map, int result) {
        Node node = map.get(source);
        node.visitFlag = true;
        List<Integer> neighbors = node.neighbors;
        result++;

        if (neighbors.contains(target))
            if (!flag) {
                System.out.println(result);
                flag = true;
                return;
            }
            // 종료
        for (int neighbor : node.neighbors) {
            if (!map.get(neighbor).visitFlag) {
                dfs(neighbor, target, map, result);
            }
        }
    }

    static class Node {
        Integer number;
        List<Integer> neighbors;
        Boolean visitFlag;

        public Node(int number) {
            this.number = number;
            this.neighbors = new ArrayList<>();
            this.visitFlag = false;
        }
    }
}