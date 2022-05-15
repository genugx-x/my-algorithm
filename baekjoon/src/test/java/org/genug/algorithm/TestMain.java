package org.genug.algorithm;

import org.genug.algorithm.class1.Class1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {


    @DisplayName("1008 - A/B")
    @Test
    public void test_1008() {
        Class1 class1 = new Class1();
        assertEquals(0.33333333333333333333333333333333, class1.devide(1, 3));
        assertEquals(0.8, class1.devide(4, 5));
    }

    @DisplayName("1152 - 단어의개수")
    @Test
    public void test_1152() {
        Class1 class1 = new Class1();
        assertEquals(0, class1.countWords(" "));
        assertEquals(1, class1.countWords(" A"));
    }

    @DisplayName("1157 - 단어공부")
    @Test
    public void test_1157() {
        Class1 class1 = new Class1();
        assertEquals('?', class1.studyWords("Mississipi"));
        assertEquals('Z', class1.studyWords("zZa"));
        assertEquals('Z', class1.studyWords("Z"));
        assertEquals('A', class1.studyWords("baaa"));
    }
}
