/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given an input string and a dictionary of words, find out if the input string
 * can be segmented into a space-separated sequence of dictionary words. See
 * following examples for more details.
 *
 *Example:
 *Input:
 *2
 *12
 *i like sam sung samsung mobile ice cream icecream man go mango
 *ilike
 *12
 *i like sam sung samsung mobile ice cream icecream man go mango
 *idontlike
 *Output:
 *1
 *0
 *
 * https://practice.geeksforgeeks.org/problems/word-break/0
 *
 * @author Mathew Wright
 */
class WordBreak {

    /**
     * Takes input from console and calls handler method for WordBreak problem.
     * 
     * Input:
     * First line is integer T denoting number of test cases. 1<=T<=100.
     * Every test case has 3 lines.
     * First line is N number of words in dictionary. 1<=N<=12.
     * Second line contains N strings denoting the words of dictionary. Length of each word is less than 15.
     * Third line contains a string S of length less than 1000.
     * 
     * Output:
     * Print 1 is possible to break words, else print 0.
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

            String words = scan.next();

            System.out.println("output: "+(wordBreak(dict, words) ? 1 : 0));

            testCases--;
        }
    }

    /**
     * Handler method for word break problem.
     * Given a dictionary and a string, find out of the given word can be
     * segmented to fit the words in the dictionary
     * 
     * 
     * @param dict the dictionary of words
     * @param words the word/string that you wish to attempt to segment
     * @return 
     */
    private static boolean wordBreak(String[] dict, String words) {
        //System.out.println("w:"+words+",len,"+words.length());
        if (words.length() == 0) {//base case
            return true;
        }
        //for each word in the dictionary, attempt to match it to the start
        //of the word we wish to segment, then reduce size of word and call self recursivly
        for (String s : dict) {
            for (int i = 0; i < words.length() && i < s.length(); i++) {

                if (!String.valueOf(words.charAt(i)).equals(String.valueOf(s.charAt(i)))) {
                    break;
                } else if (i == s.length() - 1) {//at end of dictionary word
                    if (wordBreak(dict, words.substring(i + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
