package com.stack.problems;

import java.util.HashMap;
import java.util.Stack;

public class ParenthesisChecker {

    /*  Given an expression: [()]{}{[()()]()}, examine whether the pairs are in correct order.
     * */

    private static boolean isBalancedParenthesis(String input) {

        if (input == null || input.isEmpty())
            return false;
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
                continue;
            } else if (stack.isEmpty()) {
                return false;
            }
            char check = stack.peek();
            if ((ch == ']' && check == '[') || (ch == '}' && check == '{') || (ch == ')' && check == '(')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isBalancedParenthesisSecondWay(String input) {

        if (input == null || input.isEmpty())
            return false;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> paraMap = getMap();

        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);
            if (paraMap.containsKey(ch)) {
                stack.push(ch);
                continue;
            } else if (stack.isEmpty()) {
                return false;
            }
            if (paraMap.get(stack.peek()).equals(ch)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static HashMap<Character, Character> getMap() {

        HashMap<Character, Character> paraMap = new HashMap<>();
        paraMap.put('{', '}');
        paraMap.put('(', ')');
        paraMap.put('[', ']');
        return paraMap;
    }


    public static void main(String[] args) {

        System.out.println("Parenthesis Checker......");
        System.out.println("Input: [()]{}{[()()]()} \t valid: " + isBalancedParenthesis("[()]{}{[()()]()}"));
        System.out.println("Input: [(]) \t valid: " + isBalancedParenthesis("[(])"));
        System.out.println("Input: [[[(]) \t valid: " + isBalancedParenthesis("[[[(])"));
        System.out.println("Input: {([])} \t valid: " + isBalancedParenthesisSecondWay("{([])}"));
        System.out.println("Input: () \t valid: " + isBalancedParenthesisSecondWay("()"));
        System.out.println("Input: ([] \t valid: " + isBalancedParenthesisSecondWay("([]"));
        System.out.println("Input: ([])) \t valid: " + isBalancedParenthesisSecondWay("([]))"));

    }
}
