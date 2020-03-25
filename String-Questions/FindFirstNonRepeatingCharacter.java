package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class FindFirstNonRepeatingCharacter {

	static char findFirstNonRepeatingCharacter(String inputString) {

		StringBuffer newString = new StringBuffer();
		inputString = inputString.toUpperCase();
		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if (newString.indexOf(ch + "") < 0) {
				newString.append(ch + "");
			} else {
				newString.deleteCharAt(newString.indexOf(ch + ""));
			}
		}
		return newString.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println("Original String: " + "JAVAJ");
		System.out.println("First non-repeating character: " + findFirstNonRepeatingCharacter("JAVAJ"));

	}

}
