package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class ReverseAString {

	static String reverseUsingIteratively(String string) {

		if (string.isEmpty() || string == null)
			return string;

		String reversed = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			reversed += "" + string.charAt(i);
		}
		return reversed;
	}

	static String reverseUsingStringBuffer(String string) {

		if (string.isEmpty() || string == null)
			return string;

		StringBuffer sb = new StringBuffer(string);
		sb.reverse();
		return sb.toString();
	}

	static String reverseRecursively(String string, int len) {

		if (len == 0)
			return "";
		return string.charAt(len - 1) + "" + reverseRecursively(string, len - 1);
	}

	public static void main(String[] args) {

		System.out.println("Orginal String: " + "Vinayak");
		System.out.println("Reversed String: " + reverseRecursively("Vinayak", 7));
	}

}
