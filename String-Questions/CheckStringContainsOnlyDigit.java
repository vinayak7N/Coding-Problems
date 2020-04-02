package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class CheckStringContainsOnlyDigit {

	static boolean checkStringDigits(String string) {

		if (string.isEmpty() || string == null)
			return false;
		return string.matches("[0-9]*");
	}

	public static void main(String[] args) {
		System.out.println("Is the input string contains only digits: "+checkStringDigits("Qwe2345"));

	}

}
