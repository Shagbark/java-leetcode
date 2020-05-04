package org.leetcode.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void testCountNumbersWithEvenDigitsInArray_thenArrayIsInvalid_whenThrowException() {
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

}