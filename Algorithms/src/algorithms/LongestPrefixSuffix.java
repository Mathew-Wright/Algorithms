/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given a string of character, find the length of longest proper prefix which is also a proper suffix.
 * https://practice.geeksforgeeks.org/problems/longest-prefix-suffix/0
 * @author Mathew Wright
 */
public class LongestPrefixSuffix {

    /**
     * Reads formulated console input for string, returns length of longest
     * proper prefix which is also a proper suffix.
     * 
     * Input:
     * Each test case has one line denoting the string of length less than 100000.
     * 
     * Output:
     * Print length of longest proper prefix which is also a proper suffix.
     * 
     * Example:
     * Input:
     * 2
     * abab
     * aaaa
     * 
     * Output:
     * 2
     * 3
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String s = br.readLine().trim();

            System.out.println("output: "+longestPrefixSuffix(s));

            t--;
        }
    }

    /**
     * Given a string s, returns length of longest proper prefix which is also a
     * proper suffix.
     * 
     * //TODO: re implement using binary search
     * 
     * @param s string to search
     * @return length of longest proper prefix which is also a proper suffix.
     */
    private static int longestPrefixSuffix(String s) {

        String prefix = "";
        String suffix = "";
        int longest = -1;

        for (int i = 0; i < s.length() - 1; i++) {
            prefix += s.charAt(i);
            suffix = s.charAt(s.length() - 1 - i) + suffix;

            //System.out.println(prefix + ","+ suffix);
            if (prefix.equals(suffix)) {
                longest = i;
            }
        }
        return longest + 1;

    }
}
