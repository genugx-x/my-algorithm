package com.genug.algorithm.book.dsaa;

public class Search {
    public Integer binarySearch(int[] array, int value) {
        // 먼저 찾으려는 값이 있을 수 있는 상한선과 하한선 설정
        // 최초의 상한선 값 설정
        int lowerBound = 0; // 배열의 첫 번째 값
        int upperBound = array.length - 1; // 배열의 마지막

        // 상한선과 하한선 사이의 가운데 값을 계속해서 확인하는 루프
        while (lowerBound <= upperBound) {
            // 상한선과 하한선 사이에 중간 지점을 찾는다.)
            int midpoint = (upperBound + lowerBound) / 2;
            int midpointValue = array[midpoint];
            if (value < midpointValue)
                upperBound = midpoint - 1;
            else if (value > midpointValue)
                lowerBound = midpoint + 1;
            else if (value == midpointValue)
                return midpoint;
        }
        return null;
    }

    public void print() {
        String[] things = {"apples", "baboons", "cribs", "dulcimers"};
        for (String thing: things) {
            System.out.println("Here's a thing: " + thing);
        } // O(N)

        System.out.println("Hello world!"); // O(1)
    }

}
