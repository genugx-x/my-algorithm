package org.genug.algorithm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int m = Integer.parseInt(scanner.nextLine());
        Computer[] computers = new Computer[n+1];
        for (int i = 1; i < computers.length; i++) {
            computers[i] = new Computer(i);
        }
        while (m > 0) {
            String[] inputs = scanner.nextLine().split("\\s+");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            if (!computers[a].networks.contains(b))
                computers[a].networks.add(b);
            if (!computers[b].networks.contains(a))
                computers[b].networks.add(a);
            m--;
        }

        int result = dfs(1, computers)-1; // 1번 제외
        System.out.println(result);
    }

    public static int dfs(int n, Computer[] computers) {
        int result = 1;
        Computer com = computers[n];
        com.visitFlag = true;
        for (int i = 0; i < com.networks.size(); i++) {
            int network = com.networks.get(i);
            if (!computers[network].visitFlag)
                result += dfs(network, computers);
        }
        return result;
    }

    static class Computer {
        Integer number;
        Boolean visitFlag;
        List<Integer> networks;

        public Computer(int number) {
            this.number = number;
            this.visitFlag = false;
            this.networks = new ArrayList<>();
        }
    }
}