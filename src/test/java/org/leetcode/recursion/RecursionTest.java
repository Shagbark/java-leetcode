package org.leetcode.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

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

    @Test
    @DisplayName("reverseList(ListNode): throw NullPointerException if passed head is null")
    public void testReverseList_whenHeadIsNull_thenNullPointerException() {
        assertThrows(NullPointerException.class, () -> Recursion.reverseList(null));
    }

    @Test
    @DisplayName("reverseList(ListNode): return the same head, if list contains only one element")
    public void testReverseList_whenListContainsOnlyOneElement_thenReturnTheSameHead() {
        ListNode head = new ListNode(20);

        ListNode result = Recursion.reverseList(head);
        assertSame(head, result);
    }

    @Test
    @DisplayName("reverseList(ListNode): swap elements in list, when it contains only two elements")
    public void testReverseList_whenListContainsTwoElements_thenTheyMustBeSwapped() {
        ListNode second = new ListNode(25);
        ListNode first = new ListNode(20, second);

        ListNode result = Recursion.reverseList(first);
        assertSame(second, result);
        assertSame(first, result.getNext());
    }

    @Test
    @DisplayName("reverseList(ListNode): reverse all elements, when list contains odd count of elements")
    public void testReverseList_whenListContainsOddCountOfElements_thenDoNotSwapTheLastElement() {
        ListNode third = new ListNode(20);
        ListNode second = new ListNode(15, third);
        ListNode first = new ListNode(10, second);

        ListNode result = Recursion.reverseList(first);
        assertSame(third, result);
        assertSame(second, result.getNext());
        assertSame(first, result.getNext().getNext());
    }

    @Test
    @DisplayName("reverseList(ListNode): reverse all elements, when list contains even count of elements")
    public void testReverseList_whenListContainsEvenCountOfElements_thenSwapAllElements() {
        ListNode forth = new ListNode(25);
        ListNode third = new ListNode(20, forth);
        ListNode second = new ListNode(15, third);
        ListNode first = new ListNode(10, second);

        ListNode result = Recursion.reverseList(first);
        assertSame(forth, result);
        assertSame(third, result.getNext());
        assertSame(second, result.getNext().getNext());
        assertSame(first, result.getNext().getNext().getNext());
    }

    @Test
    @DisplayName("searchBST(TreeNode,int): throw NullPointerException, when root node is null")
    public void testSearchBST_whenRootNodeIsNull_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> Recursion.searchBST(null, 0));
    }

    @Test
    @DisplayName("searchBST(TreeNode,int): return the root node, when it contains the passed value")
    public void testSearchBST_whenRootNodeContainsPassedValue_thenReturnRootNode() {
        int value = 10;
        TreeNode rootNode = new TreeNode(value);

        TreeNode result = Recursion.searchBST(rootNode, value);
        assertSame(rootNode, result);
    }

    @Test
    @DisplayName("searchBST(TreeNode,int): return the left leaf of root node, because it contains the passed value")
    public void testSearchBST_whenNodeWithSuchValueInLeftLeaf_thenReturnLeftLeaf() {
        int value = 5;

        TreeNode left = new TreeNode(value);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(10, left, right);

        TreeNode result = Recursion.searchBST(root, value);
        assertSame(left, result);
        assertEquals(left.getVal(), result.getVal());
    }

    @Test
    @DisplayName("searchBST(TreeNode,int): return the right leaf of root node, because it contains the passed value")
    public void testSearchBST_whenNodeWithSuchValueInRightLeaf_thenReturnRightLeaf() {
        int value = 15;

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(value);
        TreeNode root = new TreeNode(10, left, right);

        TreeNode result = Recursion.searchBST(root, value);
        assertSame(right, result);
        assertEquals(right.getVal(), result.getVal());
    }

    @Test
    @DisplayName("searchBST(TreeNode,int): find node, which is in the second level of tree")
    public void testSearchBST_whenNodeWithValueInTheSecondLevelOfTree_thenReturnThisNode() {
        int value = 3;

        TreeNode secondLevelLeftLeaf = new TreeNode(value);
        TreeNode secondLevelRightLeaf = new TreeNode(4);
        TreeNode firstLevelLeftLeaf = new TreeNode(5, secondLevelLeftLeaf, secondLevelRightLeaf);
        TreeNode root = new TreeNode(10, firstLevelLeftLeaf, null);

        TreeNode result = Recursion.searchBST(root, value);
        assertSame(secondLevelLeftLeaf, result);
        assertEquals(secondLevelLeftLeaf.getVal(), value);
    }

    @Test
    @DisplayName("searchBST(TreeNode, int): return null, if node with such value doesn't exist")
    public void testSearchBST_whenNoNodeWithSuchValue_thenReturnNull() {
        TreeNode secondLevelLeftLeaf = new TreeNode(3);
        TreeNode secondLevelRightLeaf = new TreeNode(4);
        TreeNode firstLevelLeftLeaf = new TreeNode(5, secondLevelLeftLeaf, secondLevelRightLeaf);
        TreeNode root = new TreeNode(10, firstLevelLeftLeaf, null);

        TreeNode result = Recursion.searchBST(root, 2);
        assertNull(result);
    }

    @Test
    @DisplayName("getRowInPascalTriangle(int): throw IllegalArgumentException, when row index is negative")
    public void testGetRowInPascalTriangle_whenRowIndexIsNegative_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Recursion.getRowInPascalTriangle(-1));
    }

    @Test
    @DisplayName("getRowInPascalTriangle(int): throw IllegalArgumentException, when row index is more than 33")
    public void testGetRowInPascalTriangle_whenRowIndexIsMoreThan33_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Recursion.getRowInPascalTriangle(34));
    }

    @Test
    @DisplayName("getRowInPascalTriangle(int): return [1], when row index is 0")
    public void testGetRowInPascalTriangle_whenRowIndexIs0_thenReturnListFromOneElement() {
        List<Integer> result = Recursion.getRowInPascalTriangle(0);
        assertEquals(1, result.size());
        assertEquals(Integer.valueOf(1), result.get(0));
    }

    @Test
    @DisplayName("getRowInPascalTriangle(int): return [1, 1], when row index is 1")
    public void testGetRowInPascalTriangle_whenRowIndexIs1_thenReturnListWithTwoUnits() {
        List<Integer> result = Recursion.getRowInPascalTriangle(1);
        assertEquals(2, result.size());
        assertEquals(Integer.valueOf(1), result.get(0));
        assertEquals(Integer.valueOf(1), result.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(PascalTriangleArgumentsProvider.class)
    @DisplayName("getRowInPascalTriangle(int): return a list of numbers on a particular line of the triangle")
    public void testGetRowInPascalTriangle_whenRowIndexIs2_thenReturnListOfElements(int rowIndex, List<Integer> expected) {
         List<Integer> result = Recursion.getRowInPascalTriangle(rowIndex);

         for (int i = 0; i < result.size(); i++) {
             assertEquals(expected.get(i), result.get(i));
         }
    }

    static class PascalTriangleArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(2, Arrays.asList(1, 2, 1)),
                    Arguments.of(3, Arrays.asList(1, 3, 3, 1)),
                    Arguments.of(4, Arrays.asList(1, 4, 6, 4, 1)),
                    Arguments.of(5, Arrays.asList(1, 5, 10, 10, 5, 1)),
                    Arguments.of(6, Arrays.asList(1, 6, 15, 20, 15, 6, 1))
            );
        }
    }


}
