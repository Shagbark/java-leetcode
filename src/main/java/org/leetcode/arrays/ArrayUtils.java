package org.leetcode.arrays;

import java.util.Arrays;
import java.util.Objects;

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

    /**
     * Remove all instances of {@param val} in-place and return the new length of array.
     * Extra memory doesn't allocated inside the method.
     *
     * Note! Method modifies the input array. Method doesn't guarantee order of changed array.
     *
     * Since it is not possible in Java to resize an array, the elements that need to be removed
     * will be moved to the end of the array. If it were possible to use additional memory in this
     * method, then it was possible to delete elements from the array forever.
     *
     * @param numbers array, from which elements will be deleted
     * @param val value of elements, which will be deleted
     * @return new length of array
     */
    public static int removeElements(int[] numbers, int val) {
        Objects.requireNonNull(numbers, "An array must be not null");
        return numbers.length == 0 ? 0 : removeElementsFromArray(numbers, val);
    }

    /**
     * This method saves the order of elements in array during removing.
     * For example, given an array with such elements { 1, 4, 6, 7, 6, 8 }. After executing the method
     * result will be { 1, 4, 7, 8, 6, 6 }.
     *
     * @param array array, from which elements will be deleted
     * @param val value of elements, which will be deleted
     * @return new length of array
     */
    private static int removeElementsFromArray(int[] array, int val) {
        int size = array.length;
        for (int i = 0; i < size;) {
            if (array[i] == val) {
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                size--; // decrease size after "removing" element
            } else {
                i++;
            }
        }
        return size;
    }

    /**
     * This method updates order of elements during removing elements.
     * For example, given an array with such elements { 1, 4, 6, 7, 6, 8 }. After executing the method
     * result will be { 1, 4, 8, 7, 6, 6 }.
     *
     * @param array array, from which elements will be deleted
     * @param val value of elements, which will be deleted
     * @return new length of array
     */
    private static int removeElementsFromArrayUsingTwoPointers(int[] array, int val) {
        int i = 0;
        int lastIndexToCopy = array.length;

        while (i < lastIndexToCopy) {
            if (array[i] == val) {
                array[i] = array[lastIndexToCopy - 1];
                lastIndexToCopy--;
            } else {
                i++;
            }
        }
        return lastIndexToCopy;

    }

    /**
     * Checks if in the array exists two integers N and M such, that N is the double of M (i.e. N = 2 * M).
     * Array isn't sorted.
     *
     * @param arr array in which need to find double values
     * @return true, if such integers exist, false otherwise.
     */
    public static boolean checkIfDoubleValuesExist(int[] arr) {
        Objects.requireNonNull(arr, "Input array must be not null.");

        Arrays.sort(arr);

        if (containsSeveralZeros(arr)) {
            return true;
        }

        for (int value : arr) {
            if (value % 2 == 0 && value != 0) {
                int m = value / 2;
                if (binarySearch(arr, m)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean containsSeveralZeros(int[] arr) {
        int zeroCount = 0;
        for (int value : arr) {
            if (value == 0 && ++zeroCount == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == value) {
                return true;
            } else if (array[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    /**
     * Checks if array is a valid mountain array. Recall that array is a mountain array if and
     * only if:
     *  - arr.length > 3
     *  - there is some {@code i} with {@code 0 < i < arr.length - 1} such that:
     *      - arr[0] < arr[1] < ... < arr[i]
     *      - arr[i] > arr[i + 1] > ... arr[arr.length - 1]
     *
     * @param array array to check
     * @return true only if array is a mountain array, false otherwise.
     */
    public static boolean isMountainArray(int[] array) {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException("Array must not null and contains at least 3 elements");
        }

        int i = 0;
        while (array[i + 1] > array[i] && i != array.length - 1) {
            i++;
        }
        if (i == array.length - 1) {
            return false; // array is strictly increasing always
        }
        while (i != array.length - 1 && array[i] > array[i + 1]) {
            i++;
        }

        return i == array.length - 1;
    }

}
