package com.searchAlgo;

/*
 * @author Vinayak Nair$
 *
 */
public class BinarySearch {

	/*
	 * Time Complexity: O(logn) Binary Search only works for sorted set...
	 */

	public static int binarySearchIteratively(int[] array, int data) {
		  
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == data) {
				return mid + 1;
			} else if (array[mid] > data) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearchRecursively(int[] array, int data, int low, int high) {
		
		int mid = (low + high) / 2;
		if (low > high)
			return -1;
		if (array[mid] == data)
			return mid + 1;
		else if (array[mid] > data) {
			return binarySearchRecursively(array, data, low, mid - 1);
		} else {
			return binarySearchRecursively(array, data, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] array = { 23, 34, 45, 56, 67, 78, 89, 90, 109, 120, 123, 345 };
		// int pos = binarySearchIteratively(array, 345);
		int pos = binarySearchRecursively(array, 345, 0, array.length - 1);
		if (pos != -1) {
			System.out.println("Element found at position: " + pos);
		} else {
			System.out.println("Element not found!!!");
		}

	}

}
