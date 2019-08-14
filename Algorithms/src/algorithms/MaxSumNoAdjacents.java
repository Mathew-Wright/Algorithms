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
 * Given an array A of positive integers. Find the maximum sum of a subsequence
 * such that no two numbers in the sequence should be adjacent in the array.
 * https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents/0
 * @author Mathew Wright
 */
public class MaxSumNoAdjacents {

    /**
     * Reads formulated console input for array values,
     * prints to console max sum from array where elements used in array cannot
     * be adjacent to each other.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number
     * of test cases. The first line of each test case is N, size of array. The
     * second line of each test case contains N elements.
     *
     * Output:
     * Print the maximum sum of a subsequence.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 6
     * 5 5 10 100 10 5
     * 4
     * 3 2 7 10
     * 
     * Output:
     * 110
     * 13
     * 
     * Explanation:
     * Test case 2 : 3 and 10 forms a non-continuous subsequence with maximum sum.
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
                arr[i] = Integer.parseInt(str[i]);
            }

            System.out.println("output: "+sumNonAdjacent(arr));

            t--;
        }
    }

    /**
     * Given an array, returns max sum from sequence formed from non adjacent
     * array elements.
     * @param arr array to search
     * @return max sum from sequence formed from non adjacent array elements .
     */
    private static int sumNonAdjacent(int[] arr) {
        int[][] dp = new int[2][arr.length + 1];

        //dp[0] = used
        //dp[1] = 'skipped'
        for (int i = 0; i < arr.length; i++) {
            dp[0][i + 1] = dp[1][i] + arr[i];//use current val by adding to prev itteration skip
            dp[1][i + 1] = Math.max(dp[0][i], dp[1][i]);//skip current val by getting max prev itteration

        }

        return Math.max(dp[0][arr.length], dp[1][arr.length]);

    }
}
