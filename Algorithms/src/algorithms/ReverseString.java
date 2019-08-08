/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 * Given a string s, reverse the string
 * https://practice.geeksforgeeks.org/problems/reverse-the-string/0
 * @author Mathew Wright
 */
public class ReverseString {

    /**
     * Reads formulated console input for string s,
     * prints to console the reverse of s.
     * 
     * First value T represents number of test cases.
     * Then T lines follow, one line for each string to be reversed.
     * 
     * Example:
     * Input:
     * 3
     * Geeks
     * GeeksforGeeks
     * GeeksQuiz
     * 
     * Output:
     * skeeG
     * skeeGrofskeeG
     * ziuQskeeG
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {

            System.out.println("output: "+reverse(scanner.next()));

            t--;
        }
    }

    /**
     * Given a string s, return reverse of s
     * @param s string to reverse
     * @return reverse of given string
     */
    private static String reverse(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
}
