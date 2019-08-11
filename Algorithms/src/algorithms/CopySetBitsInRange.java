/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given two numbers x and y, and a range [l, r] , For each set bits of y in
 * range [l, r], set these bits in x also.
 * https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range/0
 *
 * @author Mathew Wright
 */
public class CopySetBitsInRange {

    /**
     * Reads formulated console input for x,lsb,msb,y values.
     *
     * x = int to copy set bits into lsb = least significant bit to start from
     * msb = most significant bit to end on y = int to copy bits from
     *
     *
     * Input: The first line of input contains an integer T denoting the number
     * of test cases. Each test case contains space separated values of x, lsb,
     * msb and y in a single line.
     *
     * Output: Print modified value of x.
     *
     * Example:
     *
     * Input: 3 44 1 5 3 16 1 3 2 999 1 32 1023
     *
     * Output: 47 18 1023
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {

            int x = scanner.nextInt();
            int lsb = scanner.nextInt();
            int msb = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println("output: " + copySetBitsInRange(x, lsb, msb, y));

            t--;
        }
    }

    private static int copySetBitsInRange(int x, int lsb, int msb, int y) {
        if (lsb < 1 || msb > 32) {
            return 0;
        }
        
        int unplacedMask = (int) ((1L << (msb - lsb + 1)) - 1); //no lossy as r max = 32
        int placedMask = unplacedMask << (lsb - 1);
        int yMask = placedMask & y;

        return (x | yMask);
        
        //V1 - iterate through bits
        //for (int i = lsb - 1; i < msb + 1; i++) {
        //
        //    if ((y & (1 << i)) != 0) {//if y bit is set at i
        //        x = x | (1 << i);
        //    }
        //}
        //return x;

        

    }
}
