
package com.ds.programs;

/**
 * Program to reverse a {@link String}
 */
public class ReverseString {

    public static String solution(String input) {
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[end];
            chars[end--] = chars[start];
            chars[start++] = temp;
        }
        return new String(chars);
    }
}
