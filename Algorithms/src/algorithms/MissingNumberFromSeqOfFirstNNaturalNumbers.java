/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given an array C of size N-1 and given that there are numbers from 1 to N
 * with one element missing, the missing number is to be found.
 *
 *
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
 *
 * @author Mathew Wright
 */
public class MissingNumberFromSeqOfFirstNNaturalNumbers {

    /**
     * Takes formulated console input and returns the missing number from the array.
     * The array of size n should contain the numbers 1 to n with 1 missing value.
     * 
     * 
     * 
     * Output:
     * Print the missing number in array.
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 1 2 3 5
     * 10
     * 1 2 3 4 5 6 7 8 10
     * 
     * Output:
     * 4
     * 9
     * 
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
            int sum = 0;

            line = br.readLine();
            strs = line.trim().split("\\s+");

            for (int i = 0; i < n - 1; i++) {
                sum += Integer.parseInt(strs[i]);
            }

            MissingNumberFromSeqOfFirstNNaturalNumbers gfg = new MissingNumberFromSeqOfFirstNNaturalNumbers();
            int result = gfg.missingNumber(sum, n);

            System.out.println("output: "+result);

            testCases--;
        }
    }

    /**
     * Given the sum of an array and the length of the array +1,
     * returns the missing number from the array
     * @param sum sum of the array
     * @param n size of the array +1
     * @return missing number from the array
     */
    private int missingNumber(int sum, int n) {
        //sum of the first n natural numbers - sum
        return n * (n + 1) / 2 - sum;
    }
}
