package org.leetcode.recursion;

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

    @Test
    @DisplayName("swapPairs(ListNode): throw NPE if head is null")
    public void testSwapPairs_whenHeadIsNull_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> Recursion.swapPairs(null));
    }

    @Test
    @DisplayName("swapPairs(ListNode): return the same object, when list contains only one element")
    public void testSwapPairs_whenLintContainsOneElement_thenReturnHead() {
        ListNode head = new ListNode(10);

        ListNode result = Recursion.swapPairs(head);
        assertSame(head, result);
    }

    @Test
    @DisplayName("swapPairs(ListNode): swap two elements in list and return new head")
    public void testSwapPairs_whenListContainsTwoElements_thenSwapAndReturnNewHead() {
        ListNode second = new ListNode(15);
        ListNode first = new ListNode(10, second);

        ListNode result = Recursion.swapPairs(first);
        assertSame(second, result);
        assertSame(first, result.getNext());
    }

    @Test
    @DisplayName("swapPairs(ListNode): don't swap last element, when list contains odd count of elements")
    public void testSwapPairs_whenListContainsOddCountOfElements_thenDoNotSwapTheLastElement() {
        ListNode third = new ListNode(20);
        ListNode second = new ListNode(15, third);
        ListNode first = new ListNode(10, second);

        ListNode result = Recursion.swapPairs(first);
        assertSame(second, result);
        assertSame(first, result.getNext());
        assertSame(third, result.getNext().getNext());
    }

    @Test
    @DisplayName("swapPairs(ListNode): swap all elements, when list contains even count of elements")
    public void testSwapPairs_whenListContainsEvenCountOfElements_thenSwapAllElements() {
        ListNode forth = new ListNode(25);
        ListNode third = new ListNode(20, forth);
        ListNode second = new ListNode(15, third);
        ListNode first = new ListNode(10, second);

        ListNode result = Recursion.swapPairs(first);
        assertSame(second, result);
        assertSame(second, result);
        assertSame(first, result.getNext());
        assertSame(forth, result.getNext().getNext());
        assertSame(third, result.getNext().getNext().getNext());
    }

}
