package com.slidingwindow;

public class MaxSumSubArrayOfGivenSize {

    /* Find the maximum sum from each subarray with size K(subarray size).
    */

    public static int[] findSubArrayWithMaxSum(int[] array, int k) {

        if (array.length == 0 || k > array.length)
            return array;
        int check = Integer.MIN_VALUE;
        if (k == array.length) {
            return array;
        }
        int[] outArray = new int[k];

        for (int i = 0; i < array.length; i++) {
            if (i + k <= array.length) {
                int sum = 0;
                for (int j = i; j < i + k; j++) {
                    sum += array[j];
                }
                if (sum > check) {
                    int m = 0;
                    check = sum;
                    for (int l = i; l < i + k; l++) {
                        outArray[m] = array[l];
                        m++;
                    }
                }
            }
        }
        System.out.println("Maximum sum of K array: "+check);
        return outArray;
    }

    public static void findMaxSumSubArrayUsingSlidingWindow(int[] nums, int k) {

        int maxEndHere = 0;
        int maxSoFar = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            maxEndHere += nums[end];
            if (end >= k - 1) {
                maxSoFar = Math.max(maxSoFar, maxEndHere);
                maxEndHere -= nums[start];
                start++;
            }
            end++;
        }
        System.out.println("\nMaximum sum: "+maxSoFar);
    }


    public static void main(String[] args) {
       /* int[] displayArr = findSubArrayWithMaxSum(new int[]{2, 1, 5, 1, 3, 2}, 3);
        System.out.println("Array: ");
        for (int i = 0; i < displayArr.length; i++) {
            System.out.print(displayArr[i] + " ");
        }*/
        findMaxSumSubArrayUsingSlidingWindow(new int[]{2, 1, 5, 1, 3, 2}, 3);
    }
}
