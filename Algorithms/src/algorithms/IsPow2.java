/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;
/**
 * Given a positive integer N. The task is to check if N is a power of 2.
 * https://practice.geeksforgeeks.org/problems/power-of-2/0
 * @author Mathew Wright
 */
public class IsPow2 {

    /**
     * Reads formulated console input for int n, prints to console
     * YES if n is a power of 2, else NO
     * 
     * Input:
     * The first line contains T denoting the number of test cases. Each test case contains a single positive integer N.
     * 
     * Output:
     * Print "YES" if it is a power of 2 else "NO" (Without the double quotes).
     * 
     * 
     * 
     * Example:
     * Input :
     * 2
     * 1
     * 98
     * 
     * Output :
     * YES
     * NO
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            StringBuilder sb = new StringBuilder();
            String str[] = br.readLine().trim().split(" ");

            long n = Long.parseLong(str[0]);

            System.out.println("output: "+(isPow2(n) ? "YES" : "NO"));

            t--;
        }
    }

    /**
     * Given an long n, returns true if n is a power of 2, else false
     * @param n number to check
     * @return true if n is power of 2, else false
     */
    private static boolean isPow2(long n) {

        return n != 0 && (n & (n - 1)) == 0;
    }
}
