/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given an array of size n and integer k, check if array can be formed into pairs whose sum
 * is divisible by k. Each element can only be used in one pair.
 * https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem/0
 * @author Mathew Wright
 */
public class ArrayPairsSumDivisibleByK {

    /**
     * Reads formulated console input for array and integer k,
     * prints to console True if array elements can be placed into pairs where
     * each pair has a sum which is divisible by k.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. 
     * The T test cases follow. 
     * Each test case contains an integer n denoting the size of the array. 
     * The next line contains the n space separated integers forming the array. 
     * The last line contains the value of k.
     * 
     * Output:
     * Print "True" (without quotes) 
     * if given array can be divided into pairs 
     * such that sum of every pair is divisible by k or else "False" (without quotes).
     * 
     * 
     * Example:
     * Input:
     * 2
     * 4
     * 9 7 5 3
     * 6
     * 4
     * 91 74 66 48
     * 10
     * 
     * Output:
     * True
     * False
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);

            str = br.readLine().trim().split(" ");

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            str = br.readLine().trim().split(" ");
            int k = Integer.parseInt(str[0]);
            System.out.println("output: "+(pairDivisableSum(k, arr) ? "True" : "False"));

            t--;
        }
    }

    /**
     * Given an array and int k, return true 
     * if given array can be divided into pairs 
     * such that sum of every pair is divisible by k, else false
     * @param k value to divide pairs by
     * @param arr array to search for pairs
     * @return true if given array can be divided into pairs such that sum of every pair is divisible by k, else false
     */
    private static boolean pairDivisableSum(int k, int[] arr) {
        if (arr.length % 2 != 0) {//cannot form pairs
            return false;
        }

        //add remainder frequencies
        HashMap<Integer, Integer> remainder = new HashMap<>();
        for (int i : arr) {
            
            int r = i % k;
            remainder.put(r, remainder.containsKey(r) ? remainder.get(r) + 1 : 1);
        }

        for (Integer i : remainder.keySet()) {

            //calc the number that key needs to be paired with
            Integer paired = i == 0 ? 0 : k - i;

            //if paired with self
            if (paired == i) {

                //if odd occurences, cannot pair with self
                if (remainder.get(i) % 2 != 0) {
                    return false;
                }

            } else {

                //if occurences dont match up
                if (remainder.get(i) != remainder.get(paired)) {
                    return false;
                }
            }
        }

        return true;
    }

}
