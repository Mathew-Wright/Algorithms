/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given a String of length S, reverse the whole string without reversing the individual words in it. 
 * Words are separated by dots.
 * 
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
 * @author Mathew Wright
 */
public class ReverseOrderWordsInString {

    /**
     * Reads formulated console input for the given string and reverses the order of the words in the string.
     * 
     * Input:
     * The first line contains T denoting the number of test cases. T test cases follow. 
     * Each case contains a string S containing characters.
     * 
     * Output:
     * For each test case, in a new line, output a single line containing the reversed String.
     * 
     * 
     * 
     * Example:
     * Input:
     * 2
     * i.like.this.program.very.much
     * pqr.mno
     * 
     * Output:
     * much.very.program.this.like.i
     * mno.pqr
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String str = br.readLine().trim();

            System.out.println("output: "+reverseWordsOrder(str));

            t--;
        }
    }

    /**
     * Given a string which contains words separated by dots ".",
     * reverse the order of the words in the string.
     * 
     * @param str string to for its words order to be reversed
     * @return reversed order of the words in the string
     */
    private static String reverseWordsOrder(String str) {
        String result = "";
        String word = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            String s = String.valueOf(str.charAt(i));
            if (s.equals(".")) {
                result += word + ".";
                word = "";
            } else {
                word = s + word;
            }
        }
        result += word;
        return result;

    }
}
