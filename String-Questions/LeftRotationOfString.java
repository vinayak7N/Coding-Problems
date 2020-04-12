package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class LeftRotationOfString {

	static String leftRotate(String string, int numRotate) {

		if (string == null || string.isEmpty() || numRotate <= 0)
			return string;
		int n = numRotate % string.length();
		if (n == 0)
			return string;
		char[] charArray = string.toCharArray();

		for (int index = 0; index < n; index++) {
			char ch = charArray[0];
			for (int j = 0; j < charArray.length - 1; j++) {
				charArray[j] = charArray[j + 1];
			}
			charArray[charArray.length - 1] = ch;
		}
		return new String(charArray);
	}

	static String leftRotateSecondWay(String string, int numRotate) {

		if (string == null || string.isEmpty() || numRotate <= 0)
			return string;
		int n = numRotate % string.length();
		if (n == 0)
			return string;
		StringBuilder sb = new StringBuilder(string);

		for (int index = 0; index < n; index++) {
			char ch = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(ch);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("Input: " + "ABCD" + ",left rotation: " + 7);
		System.out.println("Output: " + leftRotateSecondWay("ABCD", 7));
	}

}
