/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * Given three strings A, B and C your task is to complete the function isInterleave 
 * which returns true if C is an interleaving of A and B else returns false. 
 * C is said to be interleaving A and B, if it contains all characters of A and B 
 * and order of all characters in individual strings is preserved.
 * 
 * Example(To be used only for expected output):
 * Input:
 * 2
 * YX  X  XXY
 * XY X XXY
 * 
 * Output
 * 0
 * 1
 * @author Mathew Wright
 * https://practice.geeksforgeeks.org/problems/interleaved-strings/1
 */

import java.util.*;

class InterLeaveString {

    /**
     * Starts console scanner, prints out 1 if the inputted strings are interleaved, 0 otherwise
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            InterLeaveString interleaveString = new InterLeaveString();

            System.out.println("output: "+(interleaveString.isInterLeave(a, b, c) == true ? 1 : 0));
            t--;
        }
    }

    public boolean isInterLeave(String a, String b, String c) {

        if (a.length() == 0 && b.length() == 0 && c.length() == 0) {
            return true;
        }

        if (c.length() != 0) {
            if (a.length() != 0 && c.charAt(0) == a.charAt(0)) {

                //attempt to consume char in a
                if (isInterLeave(a.substring(1), b, c.substring(1))) {
                    return true;
                }
            }

            if (b.length() != 0 && c.charAt(0) == b.charAt(0)) {

                //attempt to consume char in b
                return isInterLeave(a, b.substring(1), c.substring(1));
            }
        }
        return false;
    }
}
