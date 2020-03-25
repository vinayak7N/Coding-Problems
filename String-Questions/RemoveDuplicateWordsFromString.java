package com.string.problems;

import java.util.LinkedHashSet;

/**
 * @author vinayak.nair
 *
 */
public class RemoveDuplicateWordsFromString {

	static String removeDuplicateWords(String inputString) {

		String[] strArray = inputString.split(" ");
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for (int i = 0; i < strArray.length; i++) {
			if (!set.add(strArray[i])) {
				System.out.println("Duplicate word: " + strArray[i]);
			}
		}
		String outputString = "";
		for (String s : set) {
			outputString += s + " ";
		}
		return outputString;
	}

	public static void main(String[] args) {
		System.out.println("After removing duplicates: " + removeDuplicateWords("Java is Java "));
	}
}
