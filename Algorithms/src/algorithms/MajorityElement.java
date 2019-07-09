/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * 
 * Given an array A of N elements. Find the majority element in the array. 
 * A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 * https://practice.geeksforgeeks.org/problems/majority-element/0
 * @author Mathew Wright
 */
class MajorityElement {

    
    /**
     * Takes formulated console inputs and returns the majority element from the integer array, -1 if no majority element
     * 
     * Input:  
     * The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.
     * 
     * Output: 
     * For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 3 1 3 3 2
     * 3
     * 1 2 3
     * 
     * Output:
     * 3
     * -1
     * 
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

            MajorityElement gfg = new MajorityElement();
            int result = gfg.majorityElement(arr);

            System.out.println("output: "+result);

            testCases--;
        }
    }

    /**
     * Given an array of integers, returns the majority element from array, -1 if no majority.
     * @param arr the array to search
     * @return majority element from array, -1 if no majority element
     */
    private int majorityElement(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int threshhold = arr.length / 2;
        for (int i : arr) {
            int count = freq.containsKey(i) ? freq.get(i) + 1 : 1;
            freq.put(i, count);
            if (count > threshhold) {
                return i;
            }
        }
        return -1;
    }
}
