package org.leetcode.arrays;

import java.util.Arrays;

public class ArrayUtils {

    /**
     * Count how many elements in array {@param numbers} contain an even
     * number of digits.
     * Constraints:
     *  - each number in an array must be more than 1 and less than 10^5.
     *  - the min length of an array is 1, the max is 500.
     *
     * @param numbers an array of numbers
     * @return amount of elements, which contain even number of digits.
     */
    public static int countNumbersWithEvenDigitsInArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must be not empty");
        }

        boolean isArrayValid = Arrays.stream(numbers)
                .allMatch(number -> number > 0 && number < 100_000);
        if (numbers.length > 500 || !isArrayValid) {
            throw new IllegalArgumentException("Array is not valid");
        }

        return (int) Arrays.stream(numbers)
                .filter(number -> countDigitsInNumber(number) % 2 == 0)
                .count();
    }

    /**
     * Returns array of squared elements.
     * NOTE: incomming array is sorted!
     *
     * @param array an array of integers sorted in non-decreasing order
     * @return an array of the squares of each number, also in sorted non-decreasing order.
     */
    public static int[] squareAndSortArray(int[] array) {
        int[] result = new int[array.length];

        int p = 0; // positive element index
        // find the first positive element in array
        while (p < array.length && array[p] < 0) {
            p++;
        }

        int n = p - 1; // last negative element index
        int r = 0; // result element index

        // loop array until find all positive or all negative elements
        while (n >= 0 && p < array.length) {
            if (array[n] * array[n] < array[p] * array[p]) {
                result[r++] = array[n] * array[n];
                n--;
            } else {
                result[r++] = array[p] * array[p];
                p++;
            }
        }

        // put the last elements into result array
        while (n >= 0) {
            result[r++] = array[n] * array[n];
            n--;
        }

        while (p < array.length) {
            result[r++] = array[p] * array[p];
            p++;
        }

        return result;
    }

    private static int countDigitsInNumber(int number) {
        int digitCount = 0;
        while (number != 0) {
            number = number / 10;
            digitCount++;
        }

        return digitCount;
    }


}
