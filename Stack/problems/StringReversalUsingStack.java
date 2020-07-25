package com.stack.problems;

import java.util.Stack;

public class StringReversalUsingStack {

    private static String reversString(String input) {

        if (input == null || input.isEmpty())
            return input;
        Stack<Character> charStack = new Stack<>();
        for (int index = 0; index < input.length(); index++) {
            charStack.push(input.charAt(index));
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println("Original String: Java is Awesome " + "\n Reversed String: " + reversString("Java is Awesome"));
    }
}
