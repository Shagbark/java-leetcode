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

    private static int countDigitsInNumber(int number) {
        int digitCount = 0;
        while (number != 0) {
            number = number / 10;
            digitCount++;
        }

        return digitCount;
    }


}
