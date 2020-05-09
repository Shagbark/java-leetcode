package org.leetcode.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    @DisplayName("Count elements which contain even number of digits")
    public void testCountNumberWithEvenDigitsInArray() {
        int[] array = { 34, 343, 6566, 75654, 3455 };

        int result = ArrayUtils.countNumbersWithEvenDigitsInArray(array);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Throw IllegalArgumentException if array is not valid")
    public void testCountNumbersWithEvenDigitsInArray_whenArrayIsInvalid_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.countNumbersWithEvenDigitsInArray(null));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.countNumbersWithEvenDigitsInArray(new int[0]));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.countNumbersWithEvenDigitsInArray(new int[500]));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.countNumbersWithEvenDigitsInArray(new int[] { -1 }));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.countNumbersWithEvenDigitsInArray(new int[] { 100_001 }));
    }

    @Test
    @DisplayName("Return array of squared elements sorted in non-decreasing order")
    public void testSquareAndSortArray() {
        int[] array = { -4, -2, 0, 2, 5, 6 };
        int[] expectedResult = { 0, 4, 4, 16, 25, 36 };

        int[] result = ArrayUtils.squareAndSortArray(array);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Throw exception, when passed null array into removeElements() method")
    public void testRemoveElements_whenNullArrayPassed_thenThrowException() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.removeElements(null, 0));
    }

    @Test
    @DisplayName("Return 0, when empty array passed into removeElements() method")
    public void testRemoveElements_whenEmptyArrayPassed_thenReturn0() {
        int result = ArrayUtils.removeElements(new int[0], 0);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Remove one element from the array that is in the middle")
    public void testRemoveElements() {
        int[] array = { 1, 2, 4, 6, 5 };
        int value = 4;
        int expectedLength = array.length - 1;

        assertElementsWereRemoved(array, value, expectedLength);
    }

    @Test
    @DisplayName("Remove one element which is the first in array")
    public void testRemoveElements_whenElementIsTheFirst() {
        int[] array = {1, 2, 4, 5};
        int value = 1;
        int expectedLength = array.length - 1;

        assertElementsWereRemoved(array, value, expectedLength);
    }

    @Test
    @DisplayName("Remove one element, which is the last in array")
    public void testRemoveElements_whenElementIsTheLast() {
        int[] array = {1, 2, 4, 5};
        int value = 5;
        int expectedLength = array.length - 1;

        assertElementsWereRemoved(array, value, expectedLength);
    }

    @Test
    @DisplayName("Remove all elements in array")
    public void testRemoveElements_whenNeedToRemoveAllElementsInArray_returnZeroLength() {
        int[] array = {5, 5, 5, 5};
        int value = 5;
        int expectedLength = 0;

        assertElementsWereRemoved(array, value, expectedLength);
    }

    @Test
    @DisplayName("Remove the two elements that are found in the neighboring indices")
    public void testRemoveElements_whenTwoElementsAreOnAdjacentIndexes() {
        int[] array = {1, 5, 5, 4};
        int value = 5;
        int expectedLength = 2;

        assertElementsWereRemoved(array, value, expectedLength);
    }

    @Test
    @DisplayName("Remove the two elements")
    public void testRemoveElements_whenTwoElementsEqualToValue() {
        int[] array = {1, 4, 5, 6, 4};
        int value = 4;
        int expectedLength = array.length - 2;

        assertElementsWereRemoved(array, value, expectedLength);
    }

    private void assertElementsWereRemoved(int[] array, int value, int expectedLength) {
        int result = ArrayUtils.removeElements(array, value);
        assertEquals(expectedLength, result);

        boolean containsValue = Arrays.stream(array).limit(result).anyMatch(el -> el == value);
        assertFalse(containsValue);
    }

    @Test
    @DisplayName("Throw NullPointerException when array in method checkIfDoubleValuesExist() is null")
    public void testCheckIfDoubleValuesExist_whenArrayIsNull_thenThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> ArrayUtils.checkIfDoubleValuesExist(null));
    }

    @Test
    @DisplayName("Return false when array in method checkIfDoubleValuesExist() is empty")
    public void testCheckIfDoubleValuesExist_whenArrayIsEmpty_thenReturnFalse() {
        boolean result = ArrayUtils.checkIfDoubleValuesExist(new int[0]);
        assertFalse(result);
    }

    @Test
    @DisplayName("Return false when no double values in array, which was passed to method checkIfDoubleValuesExist()")
    public void testCheckIfDoubleValuesExist_whenArrayDoesNotContainDoubleValues_thenReturnFalse() {
        int[] array = {43, 5, 4, 6, 59};

        boolean result = ArrayUtils.checkIfDoubleValuesExist(array);
        assertFalse(result);
    }

    @Test
    @DisplayName("Return true when double values exist in an array, which was passed to method checkIfDoubleValuesExist()")
    public void testCheckIfDoubleValuesExist_whenArrayContainsDoubleValues_thenReturnTrue() {
        int[] array = {2, 5, 4, 6, 59};

        boolean result = ArrayUtils.checkIfDoubleValuesExist(array);
        assertTrue(result);
    }

    @Test
    @DisplayName("Return true when no double values in an array (array contains negative values), which was passed to method checkIfDoubleValuesExist()")
    public void testCheckIfDoubleValuesExist_whenArrayContainsNegativeValues_thenReturnFalse() {
        int[] array = {-2, 0, 10, 19, 4, 6, -8};

        boolean result = ArrayUtils.checkIfDoubleValuesExist(array);
        assertFalse(result);
    }

    @Test
    @DisplayName("Return true when double values exist in an array, which was passed to method checkIfDoubleValuesExist()")
    public void testCheckIfDoubleValuesExist_whenArrayContainsSeveralZeros_thenReturnTrue() {
        int[] array = {-2, 0, 10, 19, 4, 0, -8};

        boolean result = ArrayUtils.checkIfDoubleValuesExist(array);
        assertTrue(result);
    }

    @Test
    @DisplayName("Throw exception when passed invalid array into isMountainArray() method")
    public void testIsMountainArray_whenArrayIsNotValid_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.isMountainArray(null));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.isMountainArray(new int[1]));
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.isMountainArray(new int[2]));
    }

    @Test
    @DisplayName("Return true, when array is a mountain array")
    public void testIsMountainArray_whenArrayIsValid_whenReturnTrue() {
        int[] array = { 1, 2, 5, 6, 5, 3};

        boolean result = ArrayUtils.isMountainArray(array);
        assertTrue(result);
    }

    @Test
    @DisplayName("Return false, when array is not a mountain array (invalid order in decreasing part")
    public void testIsMountainArray_whenArrayHasInvalidOrderInDecreasingPart_whenReturnFalse() {
        int[] array = { 1, 2, 5, 6, 1, 3};

        boolean result = ArrayUtils.isMountainArray(array);
        assertFalse(result);
    }

    @Test
    @DisplayName("Return false, when array is not a mountain array (invalid order in increasing part")
    public void testIsMountainArray_whenArrayHasInvalidOrderInIncreasingPart_whenReturnFalse() {
        int[] array = { 1, 34, 5, 56, 4, 3};

        boolean result = ArrayUtils.isMountainArray(array);
        assertFalse(result);
    }

    @Test
    @DisplayName("Return false for an array, which elements are always increase")
    public void testIsMountainArray_whenElementsInArrayAlwaysIncrease_whenReturnFalse() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        boolean result = ArrayUtils.isMountainArray(array);
        assertFalse(result);
    }

    @Test
    @DisplayName("Return false for an array, which elements are always decrease")
    public void testIsMountainArray_whenElementsInArrayAlwaysDecrease_whenReturnFalse() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        boolean result = ArrayUtils.isMountainArray(array);
        assertFalse(result);
    }

}