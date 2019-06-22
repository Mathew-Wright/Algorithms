/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;
import java.util.*;

/**
 * Giving a dictionary and a string ‘str’,
 * your task is to find the longest string in dictionary of size x 
 * which can be formed by deleting some characters of the given ‘str’.
 * 
 * https://practice.geeksforgeeks.org/problems/find-largest-word-in-dictionary/0
 * @author Mathew Wright
 */
class LongestMatch {

    /**
     * Takes console input and prints out the word from dictionary
     * which matches the 'str' via deleting the least amount of chars for 'str'
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while (testCases > 0) {
            int n = scan.nextInt();

            String[] dict = new String[n];

            for (int i = 0; i < n; i++) {
                dict[i] = scan.next();

            }

            String word = scan.next();

            System.out.println(longestMatch(dict, word));

            testCases--;
        }
    }

    /**
     * Handler method for LongestMatch problem
     * @param dict dictionary of words
     * @param word the word you wish to find a match for
     * @return the matched word (from dictionary)
     */
    private static String longestMatch(String[] dict, String word) {
        int mini = Integer.MAX_VALUE;
        String minS = "";
        for (String s : dict) {
            int result = matchByReducingWordB(s, word);
            if (result < mini) {
                mini = result;
                minS = s;
            }
        }
        return minS;
    }

    private static int matchByReducingWordB(String wordA, String wordB) {
        int p0 = 0, p1 = 0;

        while (p0 < wordA.length() && p1 < wordB.length()) {
            String a = String.valueOf(wordA.charAt(p0));
            String b = String.valueOf(wordB.charAt(p1));
            ;
            if (a.equals(b)) {
                p0++;
                p1++;
            } else {
                p1++;
            }
        }

        if (p0 == wordA.length()) {//all chars in wordA where matched
            return wordB.length() - wordA.length();
        }
        return Integer.MAX_VALUE;

    }
}
