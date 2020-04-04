package com.string.problems;

/*
 * @author vinayak.nair
 *
 */
public class RemoveDuplicateCharacter {

	static String removeDuplicateChar(String string) {
		
		if (string == null || string.isEmpty())
			return string;
		string = string.toLowerCase();
		String output = new String();
		for (int index = 0; index < string.length(); index++) {
			char ch = string.charAt(index);
			if (output.indexOf(ch) < 0)
				output += ch;
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println("Original string: "+"bananas");
		System.out.println("After removing dupliactes: "+removeDuplicateChar("bananas"));
	}

}
