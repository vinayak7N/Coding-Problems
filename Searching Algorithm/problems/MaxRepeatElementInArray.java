/**
 * 
 */
package com.searchAlgo.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Vinayak Nair$
 *
 */

public class MaxRepeatElementInArray {
	/*
	 * Find the maximum repeating element in an array and number of times it is
	 * repeated.
	 */
	
	/**
	 * Time Complexity: O(n^2)
	 */
	public static int[] findMostrepeatingElementBruteForce(int[] array) {
		int max = 0, counter = 0, element = -1;
		for (int i = 0; i < array.length; i++) {
			counter = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j])
					counter++;
			}
			if (counter > max) {
				max = counter;
				element = array[i];
			}
		}
		return new int[] { element, max };
	}

	/*
	 * Time Complexity: O(nlogn)
	 */
	public static int[] findMostrepeatingElementUsingSorting(int[] array) {
		int max = 0, counter = 1, element = -1, i = 0;
		Arrays.sort(array);
		for (; i < array.length - 1; i++) {
			if (array[i] == array[i + 1])
				counter++;
			else if (counter > max) {
				max = counter;
				element = array[i];
				i--;
				counter = 1;
			}
		}
		return new int[] { element, max };
	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public static int[] findMostrepeatingElementUsingHashing(int[] array) {
		int max = 0, element = -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i]) == null) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], map.get(array[i]) + 1);
			}
		}
		for (int i : map.keySet()) {
			if (map.get(i) > max) {
				max = map.get(i);
				element = i;
			}
		}
		return new int[] { element, max };
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 2, 2, 2, 2, 1, 3, 4, 3, 1, 3, 4, 2, 1, 2, 3, 2 };
		// array = findMostrepeatingElementBruteForce(array);
		// array = findMostrepeatingElementUsingSorting(array);
		array = findMostrepeatingElementUsingHashing(array);
		System.out.println("Most repeating element " + array[0] + " repeated " + array[1] + " times...");
	}

}
