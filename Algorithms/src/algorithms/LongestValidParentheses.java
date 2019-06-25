/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Stack;

/**
 *
 * Given a string S consisting of opening and closing parenthesis '(' and ')'.
 * Find length of the longest valid parenthesis substring.
 * https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0
 *
 * @author Mathew Wright
 */
public class LongestValidParentheses {

    /**
     * Gets the length of the longest valid parentheses in the given string
     *
     * @param args the string to search
     */
    public static void main(String[] args) {

        System.out.println("string to search: " + args[0]);

        System.out.println("output: "+(findLongestValidParentheses(args[0])));

    }

    /**
     * Gets the length of the longest valid parentheses in the given string
     *
     * @param arr the string to search in for longest valid parentheses
     * @return the length of the longest valid parentheses in given string
     */
    private static int findLongestValidParentheses(String arr) {
        //System.out.println(arr);
        int open = 0;
        int close = 1;
        Stack<int[]> stack = new Stack<>();
        int curMax = 0;
        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);

            switch (c) {

                case '(':
                    stack.push(new int[]{i, open});
                    break;

                case ')':
                    if (!stack.empty() && stack.peek()[1] == open) {
                        stack.pop();

                        int lastNonPoppedIndex = stack.empty() ? -1 : stack.peek()[0];
                        curMax = i - lastNonPoppedIndex > curMax ? i - lastNonPoppedIndex : curMax;

                    } else {
                        stack.push(new int[]{i, close});
                    }
                    break;

            }
        }

        return curMax;
    }
}
