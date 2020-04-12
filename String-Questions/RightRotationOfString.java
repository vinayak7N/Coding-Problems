package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class RightRotationOfString {

	static String rightRotate(String string, int numRotate) {

		if (string == null || string.isEmpty() || numRotate <= 0)
			return string;
		int n = numRotate % string.length();
		if (n == 0)
			return string;
		char[] charArray = string.toCharArray();
		int m = charArray.length - 1;

		for (int index = 0; index < n; index++) {
			char ch = charArray[m];
			for (int j = m; j > 0; j--) {
				charArray[j] = charArray[j - 1];
			}
			charArray[0] = ch;
		}
		return new String(charArray);
	}

	static String rightRotateSecondWay(String string, int numRotate) {

		if (string == null || string.isEmpty() || numRotate <= 0)
			return string;
		int n = numRotate % string.length();
		if (n == 0)
			return string;
		StringBuilder sb = new StringBuilder(string);

		for (int index = 0; index < n; index++) {
			char ch = sb.charAt(string.length() - 1);
			sb.deleteCharAt(string.length() - 1);
			sb.insert(0, ch);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("Input: " + "ABCDEFGHI" + ",right rotation: " + 7);
		System.out.println("Output: " + rightRotateSecondWay("ABCDEFGHI", 7));
	}

}
