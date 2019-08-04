/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import java.io.*;
import java.text.DecimalFormat;


/**
 * Given an NxN chessboard and a Knight at position (x,y). 
 * The Knight has to take exactly K steps, 
 * where at each step it chooses any of the 8 directions uniformly at random. 
 * What is the probability that the Knight remains in the chessboard after taking K steps, 
 * with the condition that it can’t enter the board again once it leaves it.
 * https://practice.geeksforgeeks.org/problems/probability-of-knight/0
 * @author Mathew Wright
 */
public class ProbOfKnightNotOOB {

    private double[][][] dp;
    private int[][] jumps;

    /**
     * Constructor for ProbOfKnightNotOOB
     * @param n size of chess board
     * @param k number of moves available
     */
    ProbOfKnightNotOOB(int n, int k) {
        dp = new double[n][n][k];

        //last 4 = first 4 with internals reversed,{1,2} -> {2,1}
        jumps = new int[][]{{-1, -2,}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}};

    }

    /**
     * Reads formulated console input for N, X, Y and K. 
     * Where N * N is the size of the board and (X, Y) denotes the starting position of the chess piece.
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. 
     * Then T test cases follow. 
     * The first line of each test case contains four integers N, X, Y and K. 
     * Where N * N is the size of the board and (X, Y) denotes the starting position of the chess piece.
     * 
     * Output:
     * Output the probability that the knight remains on the board. 
     * Print the answer exactly upto 6 decimal places for each test case in a new line.
     * 
     * 
     * Example:
     * Input:
     * 1
     * 8 0 0 3
     * Output:
     * 0.125
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            //N, X, Y and K
            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            int y = Integer.parseInt(str[2]);
            int k = Integer.parseInt(str[3]);

            ProbOfKnightNotOOB g = new ProbOfKnightNotOOB(n, k);
            System.out.println(g.probKnight(x, y, k));

            t--;
        }
    }

    private String probKnight(int x, int y, int k) {
        double r = 1 - (probKnightRec(x, y, k - 1) - 1);
        DecimalFormat df = new DecimalFormat("#.######");
        return df.format(r);
    }

    private double probKnightRec(int x, int y, int k) {

        if (x < 0 || y < 0 || x >= dp.length || y >= dp.length) {
            return 2;//out of bounds
        }
        //dp stores probability + 1, 0 if uncalculated (for state x,y,k)
        if (k == -1) {//base case: no more moves left
            return 1;
        }

        double p;
        if (dp[x][y][k] == 0) {//uncalcalated
            p = 0;//p = P(x,y,k)
            for (int[] jump : jumps) {
                p += probKnightRec(x + jump[0], y + jump[1], k - 1) - 1;//-1 to remove the +1 on each result
            }
            dp[x][y][k] = (p / 8) + 1;
        }
        return dp[x][y][k];
    }
}
