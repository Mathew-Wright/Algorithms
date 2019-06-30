/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Given an array of N positive integers, print k largest elements from the array.
 * The output elements should be printed in decreasing order.
 * https://practice.geeksforgeeks.org/problems/k-largest-elements/0
 * @author Mathew Wright
 */
class KLargestInts {

    /**
     * Takes console input and outputs k largest elements from array using the 
     * formulated input.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases.
     * The first line of each test case is N and k, 
     * N is the size of array and K is the largest number of elements to be returned. 
     * The second line of each test case contains array of size N
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
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        while (testCases > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            int[] values = new int[n];

            for (int i = 0; i < n; i++) {
                values[i] = scan.nextInt();

            }

            KLargestInts gfg = new KLargestInts();
            List<Integer> result = gfg.kLargest(values, k);

            System.out.print("output: ");
            for (Integer i : result) {
                System.out.print(i + " ");
            }
            System.out.println();

            testCases--;
        }
    }

    /**
     * Given an array of integers and an integer k,
     * returns the k largest elements from array
     * @param arr the array
     * @param k number of (largest) elements to return from array
     * @return the k largest elements from array
     */
    private List<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : arr) {
            if (minHeap.size() < k) {//keep filling heap until heap is size k
                minHeap.add(i);
            } else {

                Integer smallest = minHeap.peek();
                if (i > smallest) {//add new larger value to heap
                    minHeap.poll();
                    minHeap.add(i);
                }
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            //add smallest element in heap to front of list
            result.addFirst(minHeap.poll());
        }
        return result;

    }
}
