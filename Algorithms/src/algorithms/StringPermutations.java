/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given a string S. Calculate all permutations of a given string.
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
 *
 * @author Mathew Wright
 */
public class StringPermutations {

    /**
     * Reads formulated console input for input strings, prints to console all
     * permutations of string s (lexicographically increasing order).
     *
     * Input: The first line of input contains an integer T, denoting the number
     * of test cases. Each test case contains a single string S in capital
     * letter.
     *
     * Output: For each test case, print all permutations of a given string S
     * with single space and all permutations should be in lexicographically
     * increasing order.
     *
     * Example: 
     * Input: 
     * 2 
     * ABC 
     * ABSG
     *
     * Output: 
     * ABC ACB BAC BCA CAB CBA 
     * 
     * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB 
     * GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {


            String str[] = br.readLine().trim().split(" ");
            System.out.print("output: ");
            LinkedList<String> res = permeate(str[0]);
            for (String s : res) {
                System.out.print(s + " ");
            }
            System.out.println();
            t--;
        }
    }

    /**
     * Given a string str, return all permutations of str 
     * in lexicographically increasing order
     * @param str string to permeate
     * @return all permutations of str in lexicographically increasing order
     */
    private static LinkedList<String> permeate(String str) {
        LinkedList<String> prevPermutations = new LinkedList<>();
        
        if (str.length() == 0) {//edge case, empty string input
            return prevPermutations;
        }

        LinkedList<String> buffer = new LinkedList<>();

        //add last char in string to prev permutations
        String s = String.valueOf(str.charAt(str.length() - 1));
        prevPermutations.add(s);

        //for each char, except last char in string
        for (int i = str.length() - 2; i >= 0; i--) {
            s = String.valueOf(str.charAt(i));

            //for each permutation in previous iteration (or inital setup)
            for (String perm : prevPermutations) {

                //create new permutations by adding current char in every index
                //in current previous permutation
                for (int placement = 0; placement < perm.length(); placement++) {
                    buffer.add(perm.substring(0, placement) + s + perm.substring(placement));

                }
                buffer.add(perm + s);

            }

            //deep-clone buffer into prevPermutations, then empty buffer
            prevPermutations = new LinkedList<>();
            for (String si : buffer) {

                prevPermutations.add(si);
            }
            buffer = new LinkedList<>();

        }

        Collections.sort(prevPermutations);//lexicographically increasing order.
        return prevPermutations;

    }
}
