package org.genug.algorithm.cls;

import java.util.Arrays;

public class Class2 {

    public String palindromeNumber(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] + " " + chars[chars.length-1-i]);
            if (chars[i] != chars[chars.length-1-i])
                return "no";
        }
        return "yes";
    }
}