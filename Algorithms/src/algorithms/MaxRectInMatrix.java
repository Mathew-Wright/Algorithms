/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Given a grid of active (1) and non active (0) cells,
 * return the largest rectangle in the grid of active cells.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/max-rectangle/1
 * @author Mathew Wright
 */
public class MaxRectInMatrix {

    /**
     * Reads formulated console input for the matrix and state of cells.
     * Prints to console largest active rectangle in matrix.
     * 
     * Input:
     * The first line of input is an integer T denoting the no of test cases . Then T test cases follow. The first line of each test case are 2 integers n and m denoting the size of the matrix M . Then in the next line are n*m space separated values of the matrix M.
     * 
     * Output:
     * For each test case output will be the area of the maximum rectangle .
     * 
     * Example:
     * Input
     * 2
     * 4 4 
     * 0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0
     * 8 17
     * 1 0 0 1 0 0 1 0 0 1 1 0 1 0 1 0 1
       1 1 0 1 1 0 1 1 0 1 1 1 0 1 0 0 1
       1 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 0
       1 0 1 0 0 0 1 1 0 1 1 0 0 0 0 0 0
       1 0 0 1 0 1 1 0 0 0 1 1 1 1 1 0 0
       0 1 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0
       1 0 1 1 1 0 1 0 0 0 1 0 0 0 1 1 1
       1 1 1 1 1 1 1 1 0 1 0 0 0 0 0 1 0
     *  (code still works if its not separated via new lines, so i added new line chars to make the above test easier to read)
     * Output
     * 8
     * 8
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[50][50];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            MaxRectHandler g = new MaxRectHandler();

            System.out.println("output: "+g.maxArea(a, m, n));
        }
    }
}

/**
 * Handler class for MaxRectInMatrix.
 * Given a matrix, returns the max rectangle in the matrix of cells containing 1.
 * @author Mathew Wright
 */
class MaxRectHandler {

    /**
     * Given a matrix, returns the max rectangle in the matrix of cells containing 1.
     * @param a matrix
     * @param m length of dimension m of array a (a[m][n])
     * @param n length of dimension n of array a (a[m][n])
     * @return Max rectangle in the matrix of cells containing 1
     */
    public long maxArea(int a[][], int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        //convert matrix into m histograms
        int[][] barHeights = new int[m][n];
        for (int x = 0; x < n; x++) {
            int y = 0;
            int count = 0;
            while (y < m) {
                if (a[y][x] == 1) {
                    count = count + 1;
                    barHeights[y][x] = count;

                } else {
                    count = 0;
                }
                y++;
            }

        }

        long maxR = 0;

        for (int y = 0; y < m; y++) {

            long r = maxHistRect(barHeights[y]);
            maxR = Math.max(maxR, r);
        }

        return maxR;
    }

    private long maxHistRect(int[] bars) {
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> height = new Stack<>();
        long curMax = 0;

        for (int i = 0; i < bars.length; i++) {
            //add new bar to solution space

            if (pos.empty()) {//new rectangle starting
                pos.push(i);
                height.push(bars[i]);
            } else {//new rectangle may not be starting, need to check if its new or continues from previous

                int h;
                int w = -1;//w also used as flag to tell if if went into while loop atleast once
                while (!height.empty() && height.peek() > bars[i]) {//rect continues from previous

                    //rectangle with height stored in height.peek() has ended
                    h = height.pop();
                    w = pos.pop();
                    long area = Long.valueOf(h) * Long.valueOf(i - w);
                    curMax = Math.max(area, curMax);
                }
                if (w != -1) {
                    //continues from previous bar
                    //push the last index back onto the pos stack along with current bar
                    pos.push(w);
                    height.push(bars[i]);
                } else {//new rectangle 
                    pos.push(i);
                    height.push(bars[i]);
                }
            }
        }
        int n = bars.length;
        while (!height.empty()) {

            //rectangle with height stored in height.peek() has ended
            int h = height.pop();
            int w = pos.pop();

            long area = Long.valueOf(h) * Long.valueOf(n - w);
            curMax = Math.max(area, curMax);
        }

        return curMax;

    }

}
