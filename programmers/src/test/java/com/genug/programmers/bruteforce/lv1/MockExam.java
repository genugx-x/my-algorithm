package com.genug.programmers.bruteforce.lv1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MockExam {

    @Test
    void main() {

        // assertEquals(null, test());
        assertArrayEquals(new int[] {1}, solution(new int[] {1, 2, 3, 4, 5}));
        // assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 3, 2, 4, 2});
    }

    String test() {
        int count = 0;
        while(count < 100) {
            System.out.println(count%5);
            count++;
        }
        return null;
    }

    /*
        1번 수포자가 찍는 방식: [1, 2, 3, 4, 5], [1, 2, 3, 4, 5], ... 5
        2번 수포자가 찍는 방식: [2, 1, 2, 3, 2, 4, 2, 5], [2, 1, 2, 3, 2, 4, 2, 5], ... 8
        3번 수포자가 찍는 방식: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], ... 10
     */
    int[] solution(int[] answers) {
        int[] answer = null;

        MathGiver mathGiver = new MathGiver(1, 0, new int[] {1, 2, 3, 4, 5});
        int[] giver2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giver3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        /*
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == giver1[i % giver1.length]) {
                answerCounts[0] = answerCounts[0]+1;
            }
            if (answers[i] == giver2[i % giver2.length]) {
                answerCounts[1] = answerCounts[1]+1;
            }
            if (answers[i] == giver3[i % giver3.length]) {
                answerCounts[2] = answerCounts[2]+1;
            }
        }

        Arrays.sort(answerCounts);
        System.out.println(Arrays.toString(answerCounts));
        int answerMaxCount = 0;
        for (int i = answerCounts.length - 1; i >= 0; i--) {
            if (answerCounts[answerCounts.length - 1] == answerCounts[i]) {
            }
        }
        answer = new int[answerMaxCount];
        for (int i = answerCounts.length - 1; i >= 0; i--) {
            if (answerCounts[answerCounts.length - 1] == answerCounts[i]) {
                answerMaxCount += 1;
            }
        }
        
         */
        return answer;
    }

    static class MathGiver {
        Integer number;
        Integer answerCount;
        int[] answers;

        public MathGiver(int number, int answerCount, int[] answers) {
            this.number = number;
            this.answerCount = answerCount;
            this.answers = answers;
        }
    }
}
