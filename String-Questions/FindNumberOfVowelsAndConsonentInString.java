package com.string.problems;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * @author vinayak.nair
 *
 */
public class FindNumberOfVowelsAndConsonentInString {

	static void findVowelsAndConsonent(String string) {
		if (string.isEmpty() || string == null)
			return;
		ArrayList<Character> vowelsList = new ArrayList<>(
				Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		int vowelCount = 0, consonentCount = 0;

		for (int index = 0; index < string.length(); index++) {
			if (vowelsList.contains(string.charAt(index))) {
				vowelCount++;
			} else {
				consonentCount++;
			}
		}
		System.out.println("Vowels count: " + vowelCount + "\t" + "Consonent count: " + consonentCount);
	}

	public static void main(String[] args) {
		findVowelsAndConsonent("Java");
	}

}
