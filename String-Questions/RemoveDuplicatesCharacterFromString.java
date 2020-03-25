package com.string.problems;

import java.util.LinkedHashSet;

/**
 * @author vinayak.nair
 *
 */
public class RemoveDuplicatesCharacterFromString {

	static String removeDuplicateFromString(String inputString) {

		String newString = "";
		LinkedHashSet<String> set = new LinkedHashSet<>();
		inputString = inputString.toUpperCase();
		for (int i = 0; i < inputString.length(); i++) {
			set.add(inputString.charAt(i) + "");
		}
		for (Object obj : set.toArray()) {
			newString += (String) obj;
		}
		return newString;
	}

	static String removeDuplicatesSecondMethod(String inputString) {

		StringBuffer newString = new StringBuffer();
		inputString = inputString.toUpperCase();
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if (newString.indexOf(ch + "") < 0) {
				newString.append(ch + "");
			}
		}
		return newString.toString();
	}

	public static void main(String[] args) {
		System.out.println("Before removing duplicates: " + "Malayalam");
		System.out.println("String after removing duplicates: " + removeDuplicateFromString("Malayalam"));
		System.out.println("String after removing duplicates second way: " + removeDuplicatesSecondMethod("malayalam"));
	}

}
