/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;

/**
 * Given a value k, find the number of ways to make change for k cents, if we
 * have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The
 * order of coins doesn’t matter.
 *
 * https://practice.geeksforgeeks.org/problems/coin-change/0
 * @author Mathew Wright
 */
public class CoinChange {

    
    /**
     * Reads formulated console input for change we wish to produce and range of
     * avaliable coins (each coin as infinite supply).
     * 
     * Input: 
     * The first line contains an integer 'T' denoting the total number
     * of test cases. In each test cases, the first line contains an integer 'M'
     * denoting the size of array. The second line contains M space-separated
     * integers A1, A2, ..., AN denoting the elements of the array. The third
     * line contains an integer 'N' denoting the cents.
     *
     * Output:
     * Print number of possible ways to make change for N cents.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 3
     * 1 2 3
     * 4
     * 4
     * 2 5 3 6
     * 10
     * 
     * Output:
     * 4
     * 5
     * 
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
            System.out.println("output: "+coinChangeCombinations(arr, k));

            t--;
        }
    }

    /**
     * Given int k which represents change we wish to produce and range a of
     * avaliable coins (each coin as infinite supply),
     * returns number of combinations that can produce k change using range of
     * avaliable coins.
     * @param coins range of avaliable coins
     * @param k sum of change we wish to produce.
     * @return 
     */
    private static int coinChangeCombinations(int[] coins, int k) {

        int[] dp = new int[k + 1];

        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {//increase number of coins used

            for (int j = coins[i]; j < k + 1; j++) {//increase count for achievable sums using new extra coin 
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[k];
    }
}
