package com.searchAlgo.problems;

import java.util.Arrays;
import java.util.HashMap;

/*
 * @author Vinayak Nair$
 *
 */
public class CheckDupliacteInArray {

	/*
	 * Given an array, check whether any duplicate exist!
	 */
	public static void checkDuplicateBruteForce(int[] array) {

		/*
		 * Time Complexity: O(n^2)
		 */
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j <= array.length - 1; j++) {
				if (array[i] == array[j]) {
					System.out.println("Duplicate exist!!!");
					return;
				}
			}
		}
		System.out.println("No Dupicate found!!!");
	}

	public static void checkDuplicateBySorting(int[] array) {

		/*
		 * Time Complexity: O(nlogn)
		 */
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				System.out.println("Duplicate exist!!!");
				return;
			}
		}
		System.out.println("No Dupicate found!!!");
	}

	public static void checkDuplicateUsingHashing(int[] array) {

		/*
		 * Time Complexity: O(n) Space Complexity: O(n)
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.put(array[i], 1) != null) {
				System.out.println("Duplicate exist!!!");
				return;
			}
		}
		System.out.println("No Dupicate found!!!");
	}

	public static void main(String[] args) {
		int array[] = { 12, 23, 34, 45, 11, 9, 4, 44, 34 };
		checkDuplicateBruteForce(array);
		checkDuplicateBySorting(array);
		checkDuplicateUsingHashing(array);
	}

}
