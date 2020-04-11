package com.string.problems;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * @author vinayak.nair
 *
 */
public class AppendAStringToTextFile {

	static void appendStringToFile(String string) {
		if (string == null || string.isEmpty())
			return;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("string-text-file.txt");

			for (int index = 0; index < string.length(); index++) {
				fileOutputStream.write(string.charAt(index));
			}
			fileOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static String readTextFile() {
		String output = "";
		try {
			FileInputStream fileInputStream = new FileInputStream("string-text-file.txt");
			char ch = (char) fileInputStream.read();
			while (ch != '!') {
				output += ch;
				ch = (char) fileInputStream.read();
			}
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}

	public static void main(String[] args) {
		System.out.println("String added to file!");
		appendStringToFile("Hello World!");
		System.out.println("String read from file: " + readTextFile());
	}

}
