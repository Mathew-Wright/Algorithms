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
 * Given a sample space S consisting of all perfect squares starting from 1, 4,
 * 9 and so on. You are given a number N, you have to print the number of
 * integers less than N in the sample space S.
 *
 * https://practice.geeksforgeeks.org/problems/count-squares/0
 * @author Mathew Wright
 */
public class CountSquares {

    /**
     * Reads formulated console input for int n, prints to console number of 
     * perfect squares less than n.
     * 
     * Input :
     * The first line contains an integer T, denoting the number of test
     * cases.Then T test cases follow. The first line of each test case contains
     * an integer N, denoting the number.
     *
     * Output :
     * Print the answer of each test case in a new line.
     * 
     * Example
     * Input :
     * 2
     * 9
     * 3
     * 
     * Output :
     * 2
     * 1
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            System.out.println("output: "+countSquares(n));

            t--;
        }
    }

    private static int countSquares(int n) {
        double reduced = Math.sqrt(n - 1);
        return (int) reduced;
    }
}
