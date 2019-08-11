/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 * 
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
 * @author Mathew Wright
 */
public class SortArrayOf012 {

    /**
     * Reads formulated console input for the array containing {0,1,2} only,
     * prints out the array in ascending order.
     * 
     * Output: 
     * For each testcase, print the sorted array.
     * 
     * 
     * Example:
     * Input :
     * 2
     * 5
     * 0 2 1 2 0
     * 3
     * 0 1 0
     * 
     * Output:
     * 0 0 1 2 2
     * 0 0 1
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
                arr[i] = Integer.parseInt(str[i]);
            }

            System.out.println("output: "+sort012(arr));

            t--;
        }
    }

    /**
     * Given an array of ints (0,1,2 only),
     * return a space separated string of the array sorted in ascending order.
     * @param arr array to sort
     * @return space separated string of the array sorted in ascending order
     */
    private static StringBuffer sort012(int[] arr) {
        StringBuffer result = new StringBuffer();
        int[] freq = new int[]{0, 0, 0};

        for (int i : arr) {
            freq[i] = freq[i] + 1;
        }

        for (int i = 0; i <= 2; i++) {
            int count = freq[i];

            while (count > 0) {
                result.append(" ").append(i);
                count--;
            }
        }
        return result;

    }
}
