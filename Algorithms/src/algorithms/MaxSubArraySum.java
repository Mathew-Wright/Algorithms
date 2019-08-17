/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;


/**
 * Given an array arr of N integers. Find the sum of the contiguous sub-array with maximum sum
 * 
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 * @author Mathew Wright
 */
class MaxSubArraySum {

    /**
     * Takes formulated console input for an array and prints out the maximum
     * sum of the contiguous sub-array with the largest sum from the array.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
     * 
     * Output:
     * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
     * 
     * Example:
     * Input
     * 2
     * 5
     * 1 2 3 -2 5
     * 4
     * -1 -2 -3 -4
     * Output
     * 9
     * -1
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases > 0) {

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int n = Integer.parseInt(strs[0]);

            line = br.readLine();
            strs = line.trim().split("\\s+");

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }

            MaxSubArraySum gfg = new MaxSubArraySum();
            int result = gfg.maxSubArraySum(arr);

            System.out.println("output: "+result);

            testCases--;
        }
    }

    /**
     * Given an array of integers, return the maximum
     * sum of the contiguous sub-array with the largest sum from the array.
     * 
     * @param arr array to check for sub-arrays
     * @return maximum sum of the contiguous sub-array with the largest sum from the array
     */
    private int maxSubArraySum(int[] arr) {

        if (arr.length == 0) {
            return -Integer.MIN_VALUE;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
            max = Math.max(arr[i], max);

        }
        return max;

    }
}
