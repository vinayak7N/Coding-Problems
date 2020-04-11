package com.string.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @author vinayak.nair
 *
 */
public class SortStringOnLength {

	static String[] sortStringOnLength(String[] strArray) {

		if (strArray == null || strArray.length == 0)
			return strArray;
		List<String> myList = Arrays.asList(strArray);
		Collections.sort(myList, new Comparator<String>() {

			@Override
			public int compare(String first, String second) {
				return first.length() - second.length();
			}
		});
		int index = 0;
		for (String s : myList) {
			strArray[index] = s;
			index++;
		}
		return strArray;
	}

	public static void main(String[] args) {
		String[] strArray = { "Java", "Python", "C", "Ruby", "GO" };
		strArray = sortStringOnLength(strArray);
		System.out.println("Sorted array based on length: ");
		for (String s : strArray) {
			System.out.println(s);
		}
	}

}
