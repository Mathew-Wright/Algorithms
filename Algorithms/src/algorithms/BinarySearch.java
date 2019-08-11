/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
/**
 * Given a sorted array A[](0 based index) and a key "k",
 * determine the position of the key if the key is present in the array (using binary search). 
 * If the key is not  present then you have to return -1.
 * https://practice.geeksforgeeks.org/problems/binary-search/1
 * @author Mathew Wright
 */
public class BinarySearch {

    /**
     * Reads formulated console input for the sorted (ascending) array and int k, 
     * prints to console the index of int k in array, -1 if not present.
     * 
     * Input:
     * The first line contains an integer 'T' denoting the number of test cases. 
     * Then 'T' test cases follow. Each test case consists of 3 lines. 
     * First line of each test case contains an integer N denoting the size of the array. 
     * Second line of each test case consists of 'N' space separated integers 
     * denoting the elements of the array A[]. The third line contains a key 'k' .
     * 
     * Output:
     * Prints the position of the key if its present in the array else print -1 if the key is not present in the array.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 1 2 3 4 5 
     * 4
     * 5
     * 11 22 33 44 55
     * 445
     * 
     * Output:
     * 3
     * -1
     * @param args 
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int key = sc.nextInt();
            System.out.println("output: "+BinarySearch.binSearch(arr, 0, n - 1, key));
            T--;
        }
    }

    /**
     * Given an (ascending order) sorted array and int k, 
     * returns index of int k in array, -1 if not present.
     * When initialised, the two state variables l and r are initialised as
     * 0 and arr.length-1 respectively.
     * 
     * @param arr array to search (sorted ascending order)
     * @param l left index of window (initialised 0)
     * @param r right index of window (initialised arr.length-1)
     * @param k int to find
     * @return index of int k in array, -1 if not present
     */
    private static int binSearch(int arr[], int l, int r, int k) {
        int mp = (l + r + 1) / 2;
        if (l > r || mp >= arr.length) {
            return -1;
        }
        if (arr[mp] == k) {
            return mp;
        }

        if (arr[mp] > k) {
            return binSearch(arr, l, mp - 1, k);
        } else {//arr[mp] < k
            return binSearch(arr, mp + 1, r, k);
        }
    }
}
