/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Given an array A of size N having distinct elements, 
 * the task is to find the next greater element for each element of the array 
 * in order of their appearance in the array. If no such element exists, output -1 
 * 
 * https://practice.geeksforgeeks.org/problems/next-larger-element/0
 * @author Mathew Wright
 */
public class NextLargestElement {

    /**
     * Takes console input for each formatted array and outputs the next largest
     * element for each index.
     * 
     * Input:
     * The first line of input contains a single integer T denoting the number of test cases.
     * Then T test cases follow. Each test case consists of two lines. 
     * The first line contains an integer N denoting the size of the array. 
     * The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.
     * 
     * Output:
     * For each test case, print in a new line, the next greater element for each array element separated by space in order.
     * 
     * 
     * Example:
     * Input
     * 2
     * 4
     * 1 3 2 4
     * 4
     * 4 3 2 1
     * Output
     * 3 4 4 -1
     * -1 -1 -1 -1
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        //uses buffered reader rather than scanner because scanner too slow
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases > 0) {
            int n = Integer.parseInt(br.readLine());
            
            if (n == 0){
                System.out.println("n must be >0");
            }
            else{
                long[] values = new long[n];

                String line = br.readLine();
                String[] strs = line.trim().split("\\s+");

                for (int i = 0; i < n; i++) {
                    values[i] = Long.parseLong(strs[i]);

                }

                NextLargestElement gfg = new NextLargestElement();
                long[] result = gfg.nextLargest(values);

                System.out.println("output: ");
                for (long i : result) {
                    System.out.print(i + " ");
                }
                System.out.println();    
            }

            

            testCases--;
        }
    }

    /**
     * For each element in the given array, output the next element that is 
     * greater than the current element
     * returnedArray[i] > givenArray[j] (where j > 1)
     * 
     * @param arr the given array to search
     * @return array containing next greater element for each element of the given array in order of their appearance in the array
     */
    private long[] nextLargest(long[] arr) {
        long[] result = new long[arr.length];

        Stack<Long> largerValues = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            //pop off any values <= arr[i]      
            while (!largerValues.empty() && largerValues.peek() <= arr[i]) {

                largerValues.pop();
            }

            //top of stack now contains first element which is
            // > arr[i]
            //empty if no value > arr[i]
            if (largerValues.empty()) {
                result[i] = -1;
            } else {
                result[i] = largerValues.peek();
            }
            //add new value to stack
            largerValues.push(arr[i]);

        }
        return result;

    }
}
