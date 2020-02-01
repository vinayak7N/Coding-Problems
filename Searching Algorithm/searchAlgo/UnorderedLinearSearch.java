package com.searchAlgo;

/**
 * @author Vinayak Nair$
 *
 */
public class UnorderedLinearSearch {

	/**
	 * Time Complexity: O(n)
	 */
	public static int unorderedLinearSearch(int[] array, int data) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == data) {

				return i + 1;
			}
		}
		return -1;
	}

	public static int unorderedLinearSearchBidirectionalComparission(int[] array, int data) {
		/*
		 * Time Complexity: O(n/2) ===O(logn)
		 */
		int n = array.length - 1;
		for (int i = 0; i <= n / 2; i++) {
			if (array[i] == data || array[n - i] == data) {
				if (array[i] == data)
					return i + 1;
				else if (array[n - i] == data)
					return n - i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 45, 78, 12, 34, 44, 234, 982, 98, 23, 6, 11, 34, 6, 8, 33, 65 };

		int pos = unorderedLinearSearch(array, 98);
		// int pos = unorderedLinearSearchBidirectionalComparission(array, 982);
		if (pos != -1) {
			System.out.println("Element found at position: " + pos);
		} else {
			System.out.println("Element not found!!!");
		}

	}

}
