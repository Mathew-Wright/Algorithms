/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Given two ints, returns the min number of bits that would need to be flipped
 * to make the two int equal.
 * https://practice.geeksforgeeks.org/problems/bit-difference/0
 * @author Mathew Wright
 */
public class BitDifference {

    /**
     * Reads formulated console input for ints n and k,
     * prints to console the min number of bits that would need to be flipped to
     * make n == k.
     * 
     * Input: The first line of input contains an integer T denoting the number
     * of test cases. T test cases follow. The first line of each test case is A
     * and B separated by a space.

     * Output: For each test case, in a new line, print the number of bits needed
     * to be flipped.
     * 
     * 
     * Example:
     * Input:
     * 1
     * 10 20
     * Output:
     * 4
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);

            System.out.println("output: "+bitDifference(n, k));

            t--;
        }
    }

    /**
     * Given two ints n and k, returns min number of bits that need to be flipped
     * to make n equal to k.
     * @param n 
     * @param k
     * @return min number of bits that need to be flipped to make n == k
     */
    private static int bitDifference(int n, int k) {

        return Integer.bitCount(n ^ k);

    }
}
