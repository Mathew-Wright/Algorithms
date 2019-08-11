/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Binary Search tree with an augmented append method, append method will return
 * number of elements greater then the newly added element currently in BST
 *
 * Used for SurpasserCount to solve in {O(n^2) Ω(nlogn)}. 
 * 
 * //TODO:: Convert to balanced BST to make best case O(nlogn) 
 * //TODO:: make another implementation using augmented merge sort for O(n^2) 
 * with less overhead than BST
 *
 * @author Mathew Wright
 */
class CountingBST {

    CountingBST root;
    CountingBST left;
    CountingBST right;
    int n;
    int size;

    CountingBST(int n) {
        this.n = n;

        size = 1;

        left = null;
        right = null;

    }

    public int append(int n) {
        size++;
        if (n >= this.n) {
            if (right == null) {
                right = new CountingBST(n);
                return 0;
            } else {
                return right.append(n);
            }

        } else {
            int Localsurpassers = (right == null ? 0 : right.size) + 1;
            if (left == null) {
                left = new CountingBST(n);
                return Localsurpassers;
            } else {
                return Localsurpassers + left.append(n);
            }
        }

    }

}


/**
 * Input:
 *
 * The first line of input contains a single integer T denoting the number of
 * test cases. Then T test cases follow. Each test case consist of two lines.
 * The first line of each test case consists of an integer N, where N is the
 * size of array. The second line of each test case contains N space separated
 * integers denoting array elements.
 *
 *
 * Output:
 *
 * Corresponding to each test case, in a new line, print the surpasser count
 * i.e. count the number of elements to the right that are greater than that
 * element.
 *
 * Example:
 *
 * Input 
 * 1 
 * 5 
 * 4 5 1 2 3
 *
 * Output 
 * 1 0 2 1 0
 *
 * https://practice.geeksforgeeks.org/problems/surpasser-count/0
 * @author Mathew Wright
 */
public class SurpasserCount {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];

            StringBuilder sb = new StringBuilder();
            String str[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            SurpasserCount g = new SurpasserCount();
            int[] result = g.surpasserCounts(arr);
            for (int i : result) {
                System.out.print(i + " ");
            }

            System.out.println();
            t--;
        }
    }

    /**
     * Given array of its, return number of surpassers for each index
     * @param arr array to search
     * @return number of surpassers for each index
     */
    private int[] surpasserCounts(int[] arr) {
        if (arr.length == 0) {
            return new int[]{};
        }
        if (arr.length == 1) {
            return new int[]{0};
        }

        int[] result = new int[arr.length];
        int resIndex = arr.length - 2;

        CountingBST root = new CountingBST(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            result[resIndex] = root.append(arr[i]);
            resIndex--;
        }
        return result;
    }
}
