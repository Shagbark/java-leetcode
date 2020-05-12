package org.leetcode.arrays;

import java.util.Objects;

public final class Recursion {

    private Recursion() {}

    /**
     * Reverse string. Method doesn't allocate extra space for another array, it modifies
     * the input array in-place with O(1) extra memory.
     *
     * @param str string given as an array of characters.
     */
    public static void reverseString(char[] str) {
        Objects.requireNonNull(str, "Input array must be not null");

        reverseChars(0, str);
    }

    private static void reverseChars(int index, char[] str) {
        if (index == str.length / 2) {
            return;
        }

        char symbol = str[str.length - index - 1];
        str[str.length - index - 1] = str[index];
        str[index] = symbol;

        reverseChars(++index, str);
    }

}
