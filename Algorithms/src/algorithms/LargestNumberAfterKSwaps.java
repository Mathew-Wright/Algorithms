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
 * 
 * Given a number K and string S of digits denoting a positive integer, build
 * the largest number possible by performing swap operations on the digits of S
 * at most K times.
 *
 * https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps/0
 * @author Mathew Wright
 */
public class LargestNumberAfterKSwaps {

    String max = "";

    public LargestNumberAfterKSwaps(String n) {
        max = n;
    }

    /**
     * Reads formulated console input for number n and int k, returns max number
     * after k swaps of digits in number n.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number
     * of test cases. Then T test cases follow. The first line of each test case
     * contains a positive integer K. The second line of each test case contains
     * a string of digits denoting a positive integer.
     *
     * Output:
     * Print out the largest number possible.
     * 
     * Examples :
     * Input:
     * 3
     * 4
     * 1234567
     * 3
     * 3435335
     * 2
     * 1034
     * 
     * Output:
     * 7654321
     * 5543333
     * 4301
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int k = Integer.parseInt(br.readLine().trim());
            String n = br.readLine().trim();

            LargestNumberAfterKSwaps g = new LargestNumberAfterKSwaps(n);
            System.out.println("output: "+g.maxAfterKSwaps(n, k));

            t--;
        }
    }
    /**
     * Given a String n that represents a number and an int k,
     * returns max number formed after at most k swaps between digits in n.
     * 
     * @param n number to swap digits in
     * @param k number of max swaps
     * 
     * @return returns max number formed after at most k swaps between digits in n.
     */
    private String maxAfterKSwaps(String n, int k) {
        return maxAfterKSwaps(n,k,0);
    }
    
    /**
     * Given a String n that represents a number and an int k,
     * returns max number formed after at most k swaps between digits in n.
     * 
     * @param n number to swap digits in
     * @param k number of max swaps
     * @param offset internal state variable, initialie as 0 or call method 
     * that does not include offset variable
     * @return returns max number formed after at most k swaps between digits in n.
     */
    private String maxAfterKSwaps(String n, int k, int offset) {

        //no more swaps left
        if (k <= 0) {
            return max;
        }
        
        for (int i = offset; i < n.length() - 1; i++) {
            //no more swaps at length()-1
            //ints at index <offset have allready been swaped
            for (int j = i + 1; j < n.length(); j++) {//for each index after i
                if (n.charAt(i) < n.charAt(j)) {//only swap if number will increase
                    n = swap(n, i, j);//swap
                    if (n.compareTo(max) > 0) {//calc if new max value
                        max = n;

                    }
                    //recursivly check for k-1 future steps
                    maxAfterKSwaps(n, k - 1, i + 1);
                    n = swap(n, i, j);//backtrace
                }

            }
        }
        return max;

    }

    /**
     * Given a string s, int i and int j,
     * swaps chars at indices i and j and returns resultant string after swap
     * @param s string to perform swap inside
     * @param i first index to swap
     * @param j second index to swap
     * @return string after swapping chars at indices i and j
     */
    private String swap(String s, int i, int j) {
        StringBuilder str = new StringBuilder(s);
        str.setCharAt(i, s.charAt(j));
        str.setCharAt(j, s.charAt(i));

        return str.toString();
    }
}
