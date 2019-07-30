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
 * Finds sum of the Zigzag sequence with the largest sum. 
 * A zigzag sequence starts from the top and ends at the bottom. 
 * Two consecutive elements of sequence cannot belong to same column.
 *
 * https://practice.geeksforgeeks.org/problems/largest-zigzag-sequence/0
 *
 * @author Mathew Wright
 */
public class LargestZigZagInSeq {

    /**
     * Reads formulated console input for the matrix, prints to console the 
     * largest zig zag sum in matrix.
     * 
     * Input:
     * 
     * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the matrix. Then in the next line are N*N space separated values of the matrix.
     * 
     * Output:
     * For each test case in a new line print the required max sum.
     * 
     * 
     * 
     * Example:
     * Input:
     * 2     
     * 3
     * 3  1  2  4  8  5 6  9  7
     * 3
     * 4 2 1 3 9 6 11 3 15
     * Output:
     * 18
     * 28
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {

            int n = scanner.nextInt();

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }

            }

            System.out.println("output; "+largestZigZag(arr));

            t--;
        }
    }

    /**
     * Given a matrix, find sum of the Zigzag sequence with the largest sum. 
     * A zigzag sequence starts from the top and ends at the bottom. 
     * Two consecutive elements of sequence cannot belong to same column.
     * 
     * @param arr matrix to search
     * @return largest zig zag sequence in matrix
     */
    private static int largestZigZag(int[][] arr) {
        if (arr.length == 0) {
            return 0;
        }
        //for (int[] arri : arr){
        //    System.out.println(Arrays.toString(arri));
        //}
        int[][] dp = new int[arr.length][arr[0].length];

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                int prev = -Integer.MAX_VALUE;
                //if (y-1 >= 0){//if there is a row before current row
                //
                //    int left = x-1 >= 0 ? arr[y-1][x-1] : arr[y-1][arr[0].length-1];
                //    int right = x+1 < arr.length ? arr[y-1][x+1] : arr[y-1][0];
                //    prev = Math.max(left,right);
                //}

                if (y > 0) {
                    for (int i = 0; i < arr[0].length; i++) {
                        if (i != x) {
                            prev = Math.max(prev, arr[y - 1][i]);
                        }
                    }
                } else {
                    prev = 0;
                }

                arr[y][x] += prev;//increase current location by best prev location
            }
        }

        int result = -Integer.MAX_VALUE;
        //for (int[] arri : arr){
        //    System.out.println(Arrays.toString(arri));
        //}
        for (int i = 0; i < arr[0].length; i++) {
            result = Math.max(result, arr[arr.length - 1][i]);
        }
        return result;

    }
}
