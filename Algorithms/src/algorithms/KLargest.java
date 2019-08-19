/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given an array of N positive integers, 
 * print k largest elements from the array.  
 * The output elements should be printed in decreasing order.
 * https://practice.geeksforgeeks.org/problems/k-largest-elements/0
 * @author Mathew Wright
 */
public class KLargest {

    /**
     * Reads formulated console input for the array and int k,
     * prints to console the k largest element from array in decreasing order.
     * 
     * Input:
     * First line of input contains an integer T denoting the number of test cases. 
     * The first line of each test case is N and k, 
     * N is the size of array and K is the largest elements to be returned. 
     * The second line of each test case contains N input C[i].
     * 
     * Output:
     * Print the k largest element in descending order.
     * 
     * Example:
     * Input:
     * 2
     * 5 2
     * 12 5 787 1 23
     * 7 3
     * 1 23 12 9 30 2 50
     * 
     * Output:
     * 787 23
     * 50 30 23
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int arr[] = new int[n];

            int k = Integer.parseInt(str[1]);

            str = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int[] result = kLargest(arr, k);
            System.out.print("output: ");
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();

            t--;
        }
    }

    /**
     * Given an array and an int k, returns the k largest elements from array
     * in decreasing order.
     * @param arr array to get element from
     * @param k number of elements to get
     * @return k largest elements from array in decreasing order
     */
    private static int[] kLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (x, y) -> y - x);

        //build heap
        for (int i : arr) {
            maxHeap.offer(i);
        }
        int[] result = new int[k > arr.length ? arr.length : k];
        
        //build result by removing max from heap k/arr.length (the smallest) times
        for (int i = 0; i < k && i < arr.length; i++) {
            result[i] = maxHeap.poll();

        }
        return result;
    }
}
