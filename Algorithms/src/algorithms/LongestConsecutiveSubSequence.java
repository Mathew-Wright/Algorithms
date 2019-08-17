/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given an array arr[] of positive integers. Find the length of the longest
 * sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order
 *
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence/0
 * @author Mathew Wright
 */
public class LongestConsecutiveSubSequence {

    
    /**
     * Reads formulated console input for array values, prints to console 
     * longest subsequence in array which follows natural number sequence,
     * order of elements does not matter, array only needs to contains them.
     * 
     * 
     * 
     * Input:
     * The first line of input contains T, number of test cases. 
     * First line of line each test case contains a single integer N.
     * Next line contains N integer array.
     * 
     * Output:
     * Print the output of each test case in a separate line.
     * 
     * 
     * 
     * Example:
     * Input:
     * 2
     * 7
     * 2 6 1 9 4 5 3
     * 7
     * 1 9 3 10 4 20 2
     * 
     * Output:
     * 6
     * 4
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

            System.out.println("output: "+longestConsecutiveSubSequence(arr));

            t--;
        }
    }

    /**
     * Given array of ints, returns longest subsequence in array which follows 
     * natural number sequence order of elements does not matter, 
     * array only needs to contains them.
     * @param arr array to search
     * @return longest subsequence in array which follows natural number 
     * sequence. order of elements does not matter, array only needs to contains 
     * them
     */
    private static int longestConsecutiveSubSequence(int[] arr) {
        if (arr.length == 0) {//edge case empty array
            return 0;
        }
        
        Arrays.sort(arr);//sorting array also covers edge case where an int is
        //Integer.MAX_VALUE or MIN_VALUE
        //System.out.println(Arrays.toString(arr));
        int result = 1;
        int temp = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == (arr[i + 1] - 1)) {
                temp += 1;
            } else if (arr[i] == arr[i+1]){
                //do nothing when array contains duplicate values
                
            } else {
                result = Math.max(result, temp);
                temp = 1;
            }
        }
        return Math.max(result, temp);

    }
}
