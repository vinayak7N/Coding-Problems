
package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class ReplaceEachCharacterWithGivenCharacter {

	static String replaceCharacter(String string, char givenChar, char replaceChar) {
		
		if (string.isEmpty() || string == null)
			return string;
		if (string.indexOf(givenChar) < 0) {
			return string;
		}
		StringBuilder sb = new StringBuilder(string);
		int index = sb.indexOf(givenChar + "");
		while (index >= 0) {
			sb.setCharAt(index, replaceChar);
			index = sb.indexOf(givenChar + "");
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println("Input string: " + "Java is great replacing space with new line!");
		System.out.println("Output string: \n" + replaceCharacter("Java is great", ' ', '\n'));
	}

}
