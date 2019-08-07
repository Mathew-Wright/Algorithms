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
 * Given an array of numbers 1-n, where one number is replaced by another
 * number(1-n), find the missing and repeating number.
 *
 * @author Malter
 */
public class FindRepeatingMissing {

    /**
     * Reads formulated console input for array, prints to console repeating
     * number followed by missing number.
     *
     * Input: The first line of input contains an integer T denoting the number
     * of test cases. The description of T test cases follows. The first line of
     * each test case contains a single integer N denoting the size of array.
     * The second line contains N space-separated integers A1, A2, ..., AN
     * denoting the elements of the array.
     *
     * Output: Print B, the repeating number followed by A which is missing in a
     * single line.
     *
     *
     * Example: 
     * Input: 
     * 2 
     * 2 
     * 2 2 
     * 3 
     * 1 3 3
     *
     * Output: 
     * 2 1 
     * 3 2
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];

            StringBuilder sb = new StringBuilder();
            String str[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {

                arr[Integer.parseInt(str[i]) - 1]++;
            }

            int mis = 0, rep = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    mis = i + 1;
                } else if (arr[i] == 2) {
                    rep = i + 1;
                }

            }

            System.out.println("output: "+rep + " " + mis);

            t--;
        }
    }
}
