package com.genug.programmers.dfsbfs.lv2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class Network {

    @Test
    void main() {
        int[][] computers = new int[][] {
                {1, 1, 0, 1, 1},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
//        assertEquals(solution(computers.length, computers), mySolution(computers.length, computers));
        computers = new int[][] {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1}};
        assertEquals(solution(computers.length, computers), mySolution(computers.length, computers));
    }

    int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            System.out.println(i + "번 시작 탐색");
            if (!check[i]) {
                dfs(computers, -1, i, check);
                answer++;
            }
            System.out.println();
            System.out.println(i + "번 탐색 결과 : " + Arrays.toString(check));
            System.out.println("----------------------------------");
        }
        System.out.println();
        return answer;
    }
    boolean[] dfs(int[][] computers, int before, int i, boolean[] check) {
        check[i] = true;
        System.out.print(" --> " + i );
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !check[j]) {
                check = dfs(computers, i, j, check);
            }
        }
        return check;
    }

    int mySolution(int n, int[][] computers) {
        int answer = 0;
        List<Queue<Integer>> networks = new ArrayList<>();
        for (int current = 0; current < n; current++) {
            Queue<Integer> network = new LinkedList<>();
            network.add(current);
            for (int target = current; target < n; target++) {
                if (target != current) {
                    if (computers[current][target] == 1 && computers[target][current] == 1) {
                    // if (computers[current][target] == 1) {
                        System.out.println("computers["+current+"]["+target+"] : true ");
                        network.add(target);
                    } else {
                        System.out.println("computers["+current+"]["+target+"]");
                    }
                }
            }
            networks.add(network);
        }
        System.out.println();
        System.out.println("-----Before update-----");
        print(networks);
        networks = updateNetwork(networks);
        System.out.println();
        System.out.println("-----After update-----");
        print(networks);
        return networks.size();
    }

    void print(List<Queue<Integer>> networks) {
        int count = 1;
        for (Queue<Integer> network : networks) {
            System.out.print(count++ + ". network list: ");
            for (Integer computer : network) {
                System.out.print(computer + ", ");
            }
            System.out.println();
        }
    }

    List<Queue<Integer>> updateNetwork(List<Queue<Integer>> networks) {
        Queue<Integer> currentNetwork = new LinkedList<>();
        for (int current = 0; current < networks.size(); current++) {
            for (int target = current+1; target < networks.size(); target++) {
                currentNetwork.addAll(networks.get(current));
                for (int currentComputer : currentNetwork) {
                    int targetNetworkSize = networks.get(target).size();
                    int count = 0;
                    while(count++ < targetNetworkSize) {
                        Integer targetComputer = networks.get(target).poll();
                        if (targetComputer != null && currentComputer == targetComputer) {
                            while (!networks.get(target).isEmpty()) {
                                Integer targetComputerToRemove = networks.get(target).poll();
                                if (!networks.get(current).contains(targetComputerToRemove)) {
                                    networks.get(current).add(targetComputerToRemove);
                                }
                            }
                            break;
                        } else {
                            networks.get(target).add(targetComputer);
                        }
                    }
                }
                currentNetwork.clear();
            }
        }
        return networks.stream().filter( network -> !network.isEmpty())
                .collect(Collectors.toList());
    }

}
