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
 * Finds sum of the Zigzag sequence with the largest sum. A zigzag sequence
 * starts from the top and ends at the bottom. Two consecutive elements of
 * sequence cannot belong to same column.
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
     * The first line of input contains an integer T denoting the no of test
     * cases. Then T test cases follow. Each test case contains an integer N
     * denoting the size of the matrix. Then in the next line are N*N space
     * separated values of the matrix.
     *
     * Output: For each test case in a new line print the required max sum.
     *
     *
     *
     * Example: Input: 2 3 3 1 2 4 8 5 6 9 7 3 4 2 1 3 9 6 11 3 15 Output: 18 28
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

            System.out.println("output; " + largestZigZag(arr));

            t--;
        }
    }

    /**
     * Given a matrix, find sum of the Zigzag sequence with the largest sum. A
     * zigzag sequence starts from the top and ends at the bottom. Two
     * consecutive elements of sequence cannot belong to same column.
     *
     * @param arr matrix to search
     * @return largest zig zag sequence in matrix
     */
    private static int largestZigZag(int[][] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr[0].length < 2) {
            return -Integer.MAX_VALUE;
        }
        int[][] reducedArr = new int[arr.length][4];


        //reducedArr[0] = largest value, reducedArr[1] = index of largest value
        //reducedArr[2] = 2nd largest, reducedArr[3] = index of 2nd largest
        for (int y = 0; y < arr.length; y++) {
            reducedArr[y] = twoLargest(arr[y]);//calc initial largest vals in original unchanged array row
            for (int x = 1; x <= 3; x += 2) {

                int prev;
                int index = reducedArr[y][x];

                if (y > 0) {

                    if (reducedArr[y - 1][1] == index) {
                        //largest element in row is at index, 
                        //so we must take 2nd largest 
                        prev = reducedArr[y - 1][2];
                    } else {
                        //take largest value
                        prev = reducedArr[y - 1][0];
                    }
                } else {
                    prev = 0;
                }

                arr[y][index] += prev;//increase current location by best prev location
            }
            reducedArr[y] = twoLargest(arr[y]);//update largest vals, TODO enchancement:: create func to only update the changed rows to reduce from O(n) to O(4)
        }

        //get largest element
        int result = -Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i += 2) {
            result = Math.max(result, reducedArr[reducedArr.length - 1][i]);
        }
        return result;

    }

    /**
     * Given an array, return an array containing largest 2 elements and their index.
     * result[0] = largest value, result[1] = index of largest value
     * result[2] = 2nd largest, result[3] = index of 2nd largest
     * @param values array to search
     * @return largest 2 values in arrow along with their index {largestA, indexA, largestB, indexB}.
     */
    private static int[] twoLargest(int values[]) {
        int largestA = Integer.MIN_VALUE, largestB = Integer.MIN_VALUE;

        int indexA = -1;
        int indexB = -1;
        int value;
        for (int i = 0; i < values.length; i++) {
            value = values[i];
            if (value > largestA) {
                largestB = largestA;
                largestA = value;

                indexB = indexA;
                indexA = i;
            } else if (value > largestB) {
                largestB = value;
                indexB = i;
            }
        }
        return new int[]{largestA, indexA, largestB, indexB};
    }
}
