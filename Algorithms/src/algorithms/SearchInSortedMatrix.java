/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.*;

/**
 * Given a matrix mat[] of size n x m, where every row and column is sorted in
 * increasing order, and a number x is given. Find whether element x is present
 * in the matrix or not.
 * https://practice.geeksforgeeks.org/problems/search-in-a-matrix/0
 *
 * @author Mathew Wright
 */
class SearchInSortedMatrix {

    /**
     * Reads formulated console input for the row-column sorted (ascending) matrix and int k,
     * prints to console 1 if k in matrix, false otherwise.
     * 
     * Input:
     * The first line of input contains a single integer T denoting the number of test cases. 
     * Then T test cases follow. Each test case consists of three lines. First line of each test case consist of two space separated integers N and M, denoting the number of element in a row and column respectively. Second line of each test case consists of N*M space separated integers denoting the elements in the matrix in row major order. Third line of each test case contains a single integer x, the element to be searched.
     * 
     * Output:
     * Corresponding to each test case, print in a new line, 1 if the element x is present in the matrix, otherwise simply print 0.
     * 
     * Example:
     * Input:
     * 3
     * 3 3
     * 3 30 38 44 52 54 57 60 69
     * 62
     * 1 6
     * 18 21 27 38 55 67
     * 55
     * 3 3
     * 1 2 3 2 3 4 3 4 5
     * 5
     * 
     * Output:
     * 0
     * 1
     * 1
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String[] s = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);

            s = br.readLine().trim().split("\\s+");
            int f = Integer.parseInt(br.readLine().trim());
            int k = 0;
            int[][] vals = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    vals[i][j] = Integer.parseInt(s[k++]);
                }
            }

            System.out.println("output: "+(binarySearch2d(vals, f) ? 1 : 0));

            t--;
        }
    }

    /**
     * Given a row-column sorted (ascending) 2d array and an int f,
     * returns true if f in array, false otherwise.
     * 
     * @param arr 2d array to search
     * @param f value to find
     * @return true if value in 2d array, false otherwise
     */
    private static boolean binarySearch2d(int[][] arr, int f) {

        if (arr.length == 0) {
            return false;
        }

        //start at 'top left'
        int y = (arr.length - 1);
        int x = 0;

        boolean finished = false;
        boolean found = false;

        while (!finished) {

            if (arr[y][x] == f) {
                found = true;
                finished = true;
            } else {

                if (arr[y][x] > f && y > 0) {//value f not in current row and there is another row not eliminated
                    y--;

                } else {//arr[y][x] < f 
                    //value f is at a x coord greater than current x, 
                    //either in current row or in a row not yet eliminated
                    x++;
                }
            }
            if (x == arr[0].length) {
                finished = true;
            }
        }

        return found;

    }
}
