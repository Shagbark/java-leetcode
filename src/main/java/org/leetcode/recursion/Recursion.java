package org.leetcode.recursion;

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
    private static TreeNode searchBST(TreeNode root, int val) {
        Objects.requireNonNull(root, "The root of binary search tree must be not null");

       return null;
    }

}
