/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given an array A of N positive integers and another number X. 
 * Determine whether or not there exist two elements in A whose sum is exactly X.
 * 
 * https://practice.geeksforgeeks.org/problems/key-pair/0
 * @author Mathew Wright
 */
class ContainsPairWithSum {

    /**
     * Takes formulated console input of an array and an integer X, prints Yes if
     * array contains a pair which sum is equal to X, No otherwise.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and X, N is the size of array. The second line of each test case contains N integers representing array elements A[i].
     * 
     * Output:
     * Print "Yes" if there exist two elements in A whose sum is exactly X, else "No" (without quotes).
     * 
     * 
     * Example:
     * Input:
     * 2
     * 6 16
     * 1 4 45 6 10 8
     * 5 10
     * 1 2 4 3 6
     * 
     * Output:
     * Yes
     * Yes
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
            int x = Integer.parseInt(strs[1]);

            line = br.readLine();
            strs = line.trim().split("\\s+");

            int[] values = new int[n];

            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(strs[i]);

            }

            ContainsPairWithSum gfg = new ContainsPairWithSum();
            String result = gfg.pairWithSum(values, x) ? "Yes" : "No";

            System.out.println("output: "+result);

            testCases--;
        }
    }

    /**
     * Given an array V and an integer X, return true if V contains a pair with
     * sum X, false otherwise
     * @param values array to check for pairs
     * @param x value which pair must sum too
     * @return true if array contains a pair with sum X, false otherwise
     */
    private boolean pairWithSum(int[] values, int x) {

        //add each int to hashmap along with its occurence count
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : values) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }

        }
        
        //for each value in array, check if there is a difference value which sums to x
        for (int i : values) {
            if (i + i == x) {
                //value's pair which sums to x is itself, so make sure that the occurence count of the value is greater than 1
                if (hashMap.get(i) > 1) {
                    return true;
                }
            } else if (hashMap.containsKey(x - i)) {
                return true;
            }
        }
        return false;

    }
}
