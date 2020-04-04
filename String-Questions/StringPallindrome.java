package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class StringPallindrome {

	static boolean pallindromeChecker(String string) {

		if (string == null || string.isEmpty())
			return true;
		string = string.toLowerCase();
		for (int index = 0; index < string.length() / 2; index++) {
			if (string.charAt(index) != string.charAt(string.length() - 1 - index)) {
				return false;
			}
		}
		return true;
	}
	
	static boolean pallindromeCheckerSecondWay(String string) {

		if (string == null || string.isEmpty())
			return true;
		string = string.toLowerCase();
		StringBuilder sb=new StringBuilder(string);
		
		return string.equals(sb.reverse().toString());
	}

	public static void main(String[] args) {
		System.out.println("Is string is pallindrome: " + pallindromeChecker("radar"));
	}
}
