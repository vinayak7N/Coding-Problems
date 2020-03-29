package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class RemoveGivenCharacterFromString {

	static String removeCharOccurrence(String string, char ch) {

		if (string.isEmpty() || string == null)
			return string;
		string = string.toLowerCase();
		StringBuilder sb = new StringBuilder(string);
		while (sb.indexOf(ch + "") >= 0) {
			sb.deleteCharAt(sb.indexOf(ch + ""));
		}
	
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("Input String: " + "Programming" + " character to remove - m");
		System.out.println("After removing character m " + removeCharOccurrence("Programming", 'm'));
	}

}
