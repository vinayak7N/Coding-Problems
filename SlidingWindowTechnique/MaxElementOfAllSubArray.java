package com.slidingwindow;

import java.util.Arrays;

public class MaxElementOfAllSubArray {

    /* Find the max element in each K sized subarray.
     */

    public static void maxElement(int[] array, int k) {
        /* Time Complexity: O(n*k)
         * */
        if (array.length == 0 || k <= 0)
            return;
        if (k == array.length) {
            Arrays.sort(array);
            System.out.println("Maximum element: " + array[array.length - 1]);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            if (i + k <= array.length) {
                for (int j = i; j < i + k; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                System.out.println("Maximum element in " + (i + 1) + " subarray: " + max);
            }
        }
    }

    public static void maxElementSecondWay(int[] array, int k) {

        /* Time Complexity: O(n), Space Complexity: O(1)
         */
        if (array.length == 0 || k <= 0)
            return;
        if (k == array.length) {
            Arrays.sort(array);
            System.out.println("Maximum element: " + array[array.length - 1]);
            return;
        }
        int max = array[0], j = 1, l = 0;
        for (int i = 1; i < array.length; i++) {
            int check = array[i];
            if (max < check)
                max = check;
            if (j == k - 1) {
                System.out.println("Maximum element in " + (++l) + " subarray: " + max);
                i = i - j + 1;
                max = array[i];
                j = 1;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        maxElementSecondWay(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4);
    }
}
