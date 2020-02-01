/**
 * 
 */
package com.searchAlgo.problems;

import java.util.Arrays;

/**
 * @author Vinayak Nair$
 *
 */
public class FindMissingElement {

	/*
	 * Find the missing number in a given array of range 1-n
	 */

	public static int findMissingNumberBruteForce(int[] array) {
		/*
		 * Time Complexity: O(n^2)
		 */
		for (int i = 1; i <= array.length; i++) {
			boolean found = false;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i) {
					found = true;
				}
			}
			if (!found) {
				return i;
			}
		}
		return -1;
	}

	public static int findMissingNumberBySorting(int[] array) {
		/*
		 * Time Complexity: O(nlogn)
		 */
		Arrays.sort(array);
		boolean found = false;
		int k = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] == ++k) {
				found = true;
			} else {
				found = false;
				break;
			}
		}
		if (!found) {
			return k;
		}
		return -1;
	}

	public static int findMissingNumberBySumming(int[] array) {
		/*
		 * Time Complexity: O(n)
		 */
		int sum = 0;
		int n = array.length + 1;
		int requiredSum = (n * (n + 1)) / 2;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println(sum + " " + requiredSum);
		if (requiredSum - sum != 0)
			return requiredSum - sum;
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 6, 5, 3, 8 };
		// int missing = findMissingNumberBruteForce(array);
		// int missing = findMissingNumberBySorting(array);
		int missing = findMissingNumberBySumming(array);
		if (missing != -1) {
			System.out.println("Missing element: " + missing);
		}
	}

}
