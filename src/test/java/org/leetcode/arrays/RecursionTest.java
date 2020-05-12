package org.leetcode.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecursionTest {

    @Test
    @DisplayName("reverseString(char[]): throw NPE, when input array is null")
    public void testReverseString_whenInputArrayIsNull_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> Recursion.reverseString(null));
    }

    @Test
    @DisplayName("reverseString(char[]): don't throw exception if array is empty")
    public void testReverseString_whenInputArrayIsEmpty_thenNotChangeArray() {
        char[] str = new char[0];
        assertDoesNotThrow(() -> Recursion.reverseString(str));
    }

    @Test
    @DisplayName("reverseString(char[]): don't change array if it consists from one element")
    public void testReverseString_whenInputArrayConsistsFromOneElement_thenNotChangeArray() {
        char[] str = {'s'};
        char[] expectedResult = {'s'};

        Recursion.reverseString(str);
        assertArrayEquals(expectedResult, str);
    }

    @Test
    @DisplayName("reverseString(char[]): reverse two elements in array")
    public void testReverseString_whenInputArrayConsistsFromTwoElements_thenReverseThem() {
        char[] str = {'h', 'e'};
        char[] expectedResult = {'e', 'h'};

        Recursion.reverseString(str);
        assertArrayEquals(expectedResult, str);
    }

    @Test
    @DisplayName("reverseString(char[]): reverse string which consists from three elements")
    public void testReverseString_whenInputArrayConsistsFromThreeElements_thenReverseThem() {
        char[] str = {'h', 'e', 'l'};
        char[] expectedResult = {'l', 'e', 'h'};

        Recursion.reverseString(str);
        assertArrayEquals(expectedResult, str);
    }

}
