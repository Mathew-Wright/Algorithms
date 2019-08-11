/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given a positive integer N, print count of set bits in it. 
 * For example, if the given number is 6(binary: 110), output should be 2 as there are two set bits in it.
 * https://practice.geeksforgeeks.org/problems/set-bits/0
 * @author Mathew Wright
 */
public class SetBits {

    /**
     * Reads formulated console input for the integer x, prints out the number of
     * set bits in the integer x in binary form.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. 
     * Then T test cases follow. Each test case contains single line of input containing the N.
     * 
     * Output:
     * For each test case, in a new line, print count of set bits in it.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 6
     * 11
     * Output:
     * 2
     * 3
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            System.out.println("output: "+setBits(n));

            t--;
        }
    }

    /**
     * Given an integer n, returns the number of set bits
     * in the binary form of the integer.
     * @param n number to count bits for
     * @return number of bits in binary form of given integer
     */
    private static int setBits(int n) {
        int highestBitValue = 1;
        int c = 0;

        while (highestBitValue < n) {
            highestBitValue = highestBitValue * 2;
        }

        
        int currentBitValue = highestBitValue;
        while (currentBitValue > 0) {
            if (currentBitValue <= n) {

                n -= currentBitValue;
                c++;
            }
            currentBitValue = currentBitValue / 2;
        }

        return c;
    }
}
