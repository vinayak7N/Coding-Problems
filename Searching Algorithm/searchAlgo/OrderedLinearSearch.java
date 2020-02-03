package com.searchAlgo;

/**
 * @author Vinayak Nair$
 *
 */
public class OrderedLinearSearch {

	/**
	 * Time Complexity: O(n)
	 */
	public static int sortedArrayLinearSearch(int[] array, int data) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == data) {
				return i + 1;
			} else if (array[i] > data)
				return -1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 23, 34, 45, 56, 67, 78, 89, 90, 109, 120, 123, 345 };
		int pos = sortedArrayLinearSearch(array, 89);
		if (pos != -1) {
			System.out.println("Element found at position: " + pos);
		} else {
			System.out.println("Element not found!!!");
		}

	}

}
