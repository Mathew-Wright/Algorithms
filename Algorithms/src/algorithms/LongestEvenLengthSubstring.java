/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;

/**
 * For given string ‘str’ of digits, find length of the longest substring of ‘str’, 
 * such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 * 
 * https://practice.geeksforgeeks.org/problems/longest-even-length-substring/0
 * @author Mathew Wright
 */
public class LongestEvenLengthSubstring {

    /**
     * Reads formulated console input for the array and prints to console
     * the max (even) length of substring which sum of LHS equals sum of RHS.
     * 
     * Input:
     * 
     * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
     * Each test case contains a string string of length N.
     * 
     * Output:
     * 
     * Print length of the longest substring of length 2k such that sum of left k elements is equal to right k elements and if there is no such substring print 0.
     * 
     * 
     * 
     * Example:
     * 
     * Input:
     * 2
     * 000000
     * 1234123
     * 
     * Output:
     * 6
     * 4  
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String str = br.readLine().trim();

            System.out.println("output: "+longestEvenLengthSubstringHandler(str));

            t--;
        }
    }

    /**
     * Handler method, given a string which represents an array of int digits (0-9),
     * return the the max (even) length of substring which sum of LHS equals sum of RHS.
     * @param str digits to check
     * @return max (even) length of substring which sum of LHS equals sum of RHS.
     */
    private static int longestEvenLengthSubstringHandler(String str) {
        int[] strInt = new int[str.length()];
        int maxD = 0;
        for (int i = 0; i < str.length(); i++) {
            strInt[i] = Character.getNumericValue(str.charAt(i));
        }

        //for each possible mid point
        for (int mp = 0; mp < str.length() - 1; mp++) {
            int lhs = 0;
            int rhs = 0;

            //for each possible distance from mp
            for (int d = 0; d <= mp && mp + d + 1 < str.length(); d++) {
                lhs += strInt[mp - d];
                rhs += strInt[mp + d + 1];

                if (lhs == rhs) {
                    maxD = Math.max(maxD, (d + 1) * 2);
                }
            }

        }
        return maxD;

    }
}
