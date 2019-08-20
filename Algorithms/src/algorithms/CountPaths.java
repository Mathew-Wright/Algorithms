/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * Count all the possible paths from top left to bottom right of
 * a mXn matrix with the constraints that from each cell you can either move
 * only to right or down.
 *
 * https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right/0
 * @author Mathew Wright
 */
public class CountPaths {

    
    /**
     * Reads formulated console input for size of grid, prints to console the 
     * number of paths from top left to bottom right of
     * a mXn matrix with the constraints that from each cell you can either move
     * only to right or down.
     * *NOTE: Since output can be very large number use %10^9+7. (G4G request)
     * 
     * 
     * Input: 
     * First line consists of T test cases. First line of every test case
     * consists of N and M, denoting the number of rows and number of column
     * respectively.
     *
     * Output: 
     * Single line output i.e count of all the possible paths from top
     * left to bottom right of a mXn matrix. Since output can be very large
     * number use %10^9+7.
     *
     * Example:
     * Input:
     * 2
     * 3 3
     * 32 32
     * Output:
     * 6
     * 997262645
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            String[] str = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            System.out.println("output: "+maxPaths(n, m));

            t--;
        }
        System.out.println("Since output can be very large, output = answer %10^9+7 (G4G Request)");
    }

    /**
     * Given the grid dimensions n and m, returns the number of paths from top
     * left to bottom right of a mXn matrix with the constraints that from each
     * cell you can either move only to right or down.
     * *NOTE: Since output can be very large number use %10^9+7. (G4G request)
     * @param n grid dimension n
     * @param m grid dimension m
     * @return number of paths from top left to bottom right of a mXn matrix
     * with the constraints that from each cell you can either move only to
     * right or down. *NOTE: Since output can be very large number use %10^9+7.
     * (G4G request)
     */
    private static int maxPaths(int n, int m) {
        int[] paths = new int[m];
        paths[0] = 1;
        //paths stores the number of paths that can be taken to reach that location
        //in the grid.
        //the path cost from previous iteration is carried forward each iteration,
        //simulating going 'down', going 'right' is handled by adding the current 
        //path cost to the previous path cost in the array.
        while (n > 0) {
            for (int i = 1; i < m; i++) {
                //G4G answer format request:
                //Since output can be very large number use %10^9+7.
                paths[i] = (paths[i - 1] + paths[i]) % 1000000007;

            }
            n--;
        }
        return paths[m - 1];
    }

    
}
