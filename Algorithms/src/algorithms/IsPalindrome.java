/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Given a string, print to console yes if string is palindrome, no otherwise
 * https://practice.geeksforgeeks.org/problems/palindrome/0
 * @author Mathew Wright
 */
public class IsPalindrome {

    /**
     * Reads formulated console input for strings to check if they are palindromes.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. 
     * For each test case there will be single line containing single string.
     * 
     * Output:
     * Print "Yes" or "No" (without quotes) depending on whether the string is palindrome or not.
     * 
     * 
     * Example:
     * Input:
     * 3
     * 6
     * 167
     * racecar
     * 
     * Output:
     * Yes
     * No
     * Yes
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String str = br.readLine().trim();

            System.out.println("output: "+(isPalindrome(str) ? "Yes" : "No"));

            t--;
        }
    }

    /**
     * Given a string, return true if sting is palindrome, false otherwise.
     * @param s string to check
     * @return true if string is palindrome, else false.
     */
    private static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
