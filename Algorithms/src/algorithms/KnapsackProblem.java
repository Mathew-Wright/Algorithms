/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * You are given weights and values of N items, 
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
 * Note that we have only one quantity of each item.
 * 
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0
 * @author Mathew Wright
 */
public class KnapsackProblem {

    /**
     * Reads formulated console input for the weights and values of the items and the 
     * capacity of the knapsack. Prints out the max value you can achieve by putting
     * unique items into the knapsack without exceeding the max capacity.
     *
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. 
     * Then T test cases follow. Each test case consists of four lines.
     * The first line consists of N the number of items.
     * The second line consists of W, the maximum capacity of the knapsack.
     * In the next line are N space separated positive integers denoting the values of the N items,
     * and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.
     * 
     * Output:
     * For each test case, in a new line, print the maximum possible value you can get 
     * with the given conditions that you can obtain for each test case in a new line.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 3
     * 4
     * 1 2 3
     * 4 5 1
     * 2
     * 3
     * 1 2
     * 3 4
     * Output:
     * 3
     * 1
     * 
     * NOTE, G4G input example contains a mistake, it says n = 2, but line for vals/weights contains 3 values.
     *      2
     *      3
     *      1 2 3
     *      4 5 6
     *      I changed the example input to reflect n = 2 by removing the overflow values {5,6} which computes the correct output of 1
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            int maxW = Integer.parseInt(br.readLine().trim());
            int[] vals = new int[n];
            int[] ws = new int[n];

            String str[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                vals[i] = Integer.parseInt(str[i]);
            }

            str = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                ws[i] = Integer.parseInt(str[i]);
            }
            int[][] k = new int[vals.length][maxW + 1];
            for (int i = 0; i < vals.length; i++) {
                for (int j = 0; j <= maxW; j++) {
                    k[i][j] = -1;
                }
            }
            System.out.println("output: "+knapsack(vals, ws, maxW, 0, k));

            t--;
        }
    }

    private static int knapsack(int[] vals, int[] ws, int maxW, int index, int[][] k) {
        if (index == vals.length || maxW == 0) {
            return 0;
        }
        if (k[index][maxW] == -1) {//if not yet solved
            int result1 = 0;
            int result2 = 0;
            if (ws[index] <= maxW) {//get result of using v,w at index
                result1 = knapsack(vals, ws, maxW - ws[index], index + 1, k) + vals[index];
            }
            //get result of not using v,w at index
            result2 = knapsack(vals, ws, maxW, index + 1, k);

            k[index][maxW] = Math.max(result1, result2);
        }

        return k[index][maxW];

    }
}
