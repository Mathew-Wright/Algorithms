/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given a sorted and rotated array A of N distinct elements which is rotated at some point, 
 * and given an element K. The task is to find the index of the given element K in the array A.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array/0
 * @author Mathew Wright
 */
public class SearchInRotatedArray {

    
    /**
     * Takes formulated console input of a sorted array which has been rotated and and integer k,
     * prints out the index of k in the array, -1 if not present
     * 
     * 
     * Input:
     * The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array. Second line of each test case contains N space separated integers denoting the elements of the array A. Third line of each test case contains an integer K denoting the element to be searched in the array.
     * 
     * Output:
     * Corresponding to each test case, output the index of the element found in the array.  If element is not present, then output -1.
     * 
     * 
     * Example:
     * Input:
     * 3
     * 9
     * 5 6 7 8 9 10 1 2 3
     * 10
     * 3
     * 3 1 2
     * 1
     * 4
     * 3 5 1 2
     * 6
     * 
     * Output:
     * 5
     * 1
     * -1
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];

            String str[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            System.out.println("output: "+search(arr, 0, n - 1, k));

            t--;
        }
    }

    /**
     * Given a sorted array which has been rotated and and integer k,
     * prints out the index of k in the array, -1 if not present
     * @param arr sorted array which was rotated
     * @param l left index of search window (initialise as 0)
     * @param r right index of search window (initialise as array max index)
     * @param k int to find
     * @return 
     */
    private static int search(int[] arr, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        int m = (l + r) / 2;
        if (arr[m] == k) {
            return m;
        }

        if (arr[m] >= arr[l]) {
            if (arr[l] <= k && k <= arr[m]) {
                return search(arr, l, m - 1, k);
            }
            return search(arr, m + 1, r, k);
        }
        if (k >= arr[m] && k <= arr[r]) {
            return search(arr, m + 1, r, k);
        }

        return search(arr, l, m - 1, k);
    }
}
