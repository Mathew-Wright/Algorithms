/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array with positive number the task to find the largest subsequence
 * from array that contain elements which are Fibonacci numbers.
 *
 *
 * https://practice.geeksforgeeks.org/problems/largest-fibonacci-subsequence/0
 *
 * @author Mathew Wright
 */
class FibonacciSubsequence {

    /**
     * Takes console input for and finds largest fibonacci subsequence from formulated input.
     * 
     * Input: The first line of input contains an integer T denoting the no of test
     * cases. Then T test cases follow. Each test case contains an integer N
     * denoting the size of the array. Then in the next line are N space separated
     * values of the array.
     *
     * Output: For each test case in a new line print the space separated elements
     * of the longest fibonacci subsequence.
     *
     *
     * Example: 
     * Input: 
     * 2 
     * 7 
     * 1 4 3 9 10 13 7 
     * 9 
     * 0 2 8 5 2 1 4 13 23
     *
     * Output: 
     * 1 3 13 
     * 0 2 8 5 2 1 13
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        while (testCases > 0) {

            int n = scan.nextInt();
            int[] arr = new int[n];
            int max = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            System.out.println("output: ");
            for (Integer i : getLargestFibSequence(arr, max)) {
                System.out.print(i + " ");
            }
            System.out.println();
            testCases--;
        }
    }

    private static List<Integer> getLargestFibSequence(int[] seq, int max) {

        int previousNumber = 0;
        int nextNumber = 1;

        HashMap<Integer, Integer> fibNums = new HashMap<>();

        //add fib nums to hashmap upto max value in sequence
        while (previousNumber <= max) {

            //add prev number
            fibNums.put(previousNumber, 1);

            //calc next number
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }

        LinkedList<Integer> result = new LinkedList<>();

        //add all numbers in seq to result if the number is a fib number
        for (int i = 0; i < seq.length; i++) {

            if (fibNums.containsKey(seq[i])) {
                result.add(seq[i]);

            }
        }

        return result;

    }
}
