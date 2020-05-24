package org.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    /**
     * Swap every two adjacent nodes in linked list and returns its head.
     * Values won't be modified in nodes; nodes will be replaced only.
     *
     * @param head first element of linked list.
     * @return new head of linked list.
     */
    public static ListNode swapPairs(ListNode head) {
        Objects.requireNonNull(head, "Head of linked list must be not null");

        return swapNodes(head);
    }

    private static ListNode swapNodes(ListNode currentHead) {
        if (currentHead == null || currentHead.getNext() == null) {
            return currentHead;
        }

        ListNode newHead = currentHead.getNext();
        ListNode next = newHead.getNext();

        newHead.setNext(currentHead);
        currentHead.setNext(swapNodes(next));

        return newHead;
    }

    /**
     * Reverse a singly linked list recursively.
     *
     * @param head first element of the list
     * @return a new head of list.
     */
    public static ListNode reverseList(ListNode head) {
        Objects.requireNonNull(head, "Head of linked list must be not null");

        return reverseListRecursively(head);
    }

    private static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode el = reverseListRecursively(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return el;
    }

    /**
     * Find a node in binary search tree that the node's value equals the given
     * value.
     *
     * @param root root node of binary search tree
     * @param val value which node must contain
     * @return the subtree rooted with node, which value equals to passed val or null
     *         if such no doesn't exist.
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        Objects.requireNonNull(root, "The root of binary search tree must be not null");

       return searchSubtreeInBST(root, val);
    }

    private static TreeNode searchSubtreeInBST(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (node.getVal() == val) {
            return node;
        }

        return val < node.getVal() ?
                searchSubtreeInBST(node.getLeft(), val) :
                searchSubtreeInBST(node.getRight(), val);
    }

    /**
     * Return a list of numbers that are on the transmitted line of Pascal's triangle.
     *
     * @param rowIndex row number in Pascal's Triangle. Must be non-negative value and less than 33 (inclusive)
     * @return values in the row in Pascal's Triangle
     * @throws IllegalArgumentException if row index is negative or more than 33
     */
    public static List<Integer> getRowInPascalTriangle(int rowIndex) {
        if (rowIndex < 0 || rowIndex > 33) {
            throw new IllegalArgumentException("Row index must be non-negative value and less than 33");
        }

        return getRow(rowIndex);
    }

    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            //noinspection ArraysAsListWithZeroOrOneArgument
            return Arrays.asList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1, 1);
        }

        // go to the previous row
        List<Integer> previousRow = getRow(rowIndex - 1);
        List<Integer> currentRow = new ArrayList<>();

        currentRow.add(1); // first value in row is always equals to 1
        for (int i = 1; i < previousRow.size(); i++) {
            currentRow.add(previousRow.get(i) + previousRow.get(i-1));
        }
        currentRow.add(1); // second value in row is always equals to 1

        return currentRow;
    }

}
