package org.genug.algorithm;

import org.genug.algorithm.cls.Class1;
import org.genug.algorithm.cls.Class2;
import org.genug.algorithm.cls.Class3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {


    @Test
    @DisplayName("1008 - A/B")
    public void test_1008() {
        Class1 class1 = new Class1();
        // assertEquals(0.33333333333333333333333333333333, class1.devide(1, 3));
        // assertEquals(0.8, class1.devide(4, 5));
    }

    @Test
    @DisplayName("1152 - 단어의개수")
    public void test_1152() {
        Class1 class1 = new Class1();
        assertEquals(0, class1
                  .countWords(" "));
        assertEquals(1, class1.countWords(" A"));
    }

    @Test
    @DisplayName("1157 - 단어공부")
    public void test_1157() {
        Class1 class1 = new Class1();
        assertEquals('?', class1.studyWords("Mississipi"));
        assertEquals('Z', class1.studyWords("zZa"));
        assertEquals('Z', class1.studyWords("Z"));
        assertEquals('A', class1.studyWords("baaa"));
    }

    @Test
    @DisplayName("1330 - 두 수 비교하기")
    public void test_1330() {
        Class1 class1 = new Class1();
        assertEquals("<", class1.compareTwoNumbers(1, 2));
        assertEquals(">", class1.compareTwoNumbers(10, 2));
        assertEquals("==", class1.compareTwoNumbers(5, 5));
    }

    @Test
    @DisplayName("1546 - 평균")
    public void test_1546() {
        Class1 class1 = new Class1();
        assertEquals(75.0, class1.average("40 80 60"));
        assertEquals(66.66666666666667, class1.average("10 20 30"));
        assertEquals(75.25, class1.average("1 100 100 100"));
        assertEquals(38.75, class1.average("1 2 4 8 16"));
        assertEquals(65.0, class1.average("3 10"));
        assertEquals(32.5, class1.average("10 20 0 100"));
        assertEquals(100.0, class1.average("50"));
        assertEquals(55.55555555555556, class1.average("10 20 30 40 50 60 70 80 90"));
    }

    @Test
    @DisplayName("1259 - 팰린드롬수")
    public void test_1259() {
        Class2 class2 = new Class2();
        assertEquals("yes", class2.palindromeNumber("121"));
        assertEquals("no", class2.palindromeNumber("1231"));
        assertEquals("yes", class2.palindromeNumber("12421"));
    }

    @Test
    @DisplayName("2775 - 부녀회장이 될테야")
    public void test_2775() {
        Class2 class2 = new Class2();
        assertEquals(6, class2.willBeWomenPresident(1, 3));
        System.out.println();
        assertEquals(10, class2.willBeWomenPresident(2, 3));
        System.out.println();
        assertEquals(1, class2.willBeWomenPresident(14, 1));
    }

    @Test
    @DisplayName("1012 - 유기농 배추")
    public void test_1012() {
        Class3 class3 = new Class3();
        class3.organicCabbage(10, 8);

    }

    @Test
    @DisplayName("2839 - 설탕배달")
    public void test_2839() {
        Class2 class2 = new Class2();
        assertEquals(0, class2.deliverySugar(0));
        assertEquals(1, class2.deliverySugar(5));
        assertEquals(1, class2.deliverySugar(3));
        assertEquals(4, class2.deliverySugar(18));
        assertEquals(-1, class2.deliverySugar(4));
        assertEquals(2, class2.deliverySugar(6));
        assertEquals(3, class2.deliverySugar(9));
        assertEquals(3, class2.deliverySugar(11));
        /*
         */
    }

    @Test
    @DisplayName("10845 - 큐")
    public void test_10845() {
        Class2 class2 = new Class2();

    }

    @Test
    @DisplayName("1260 - DFS 와 BFS")
    public void test_1260() {
        Class3 class3 = new Class3();
//        class3.dfsTest();
//        class3.bfsTest();
        class3.main();
    }
}
