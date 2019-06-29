/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. 
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 * 
 * 
 * @author Mathew Wright
 */
class MaxRectFromHistogram {

    /**
     * Takes formulated console input and computes the max rectangle area within the histogram.
     * 
     * Input:
     * The first line contains an integer 'T' denoting the total number of test cases.
     * T test-cases follow. 
     * In each test cases, the first line contains an integer 'N' denoting the size of array. 
     * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array. 
     * The elements of the array represents the height of the bars.
     * 
     * Output:
     * For each test-case, in a separate line, the maximum rectangular area possible from the contiguous bars.
     * 
     * Example:
     * Input: 
     * 2
     * 7
     * 6 2 5 4 5 1 6
     * 4
     * 6 3 4 2
     * Output:
     * 12
     * 9
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        while (testCases > 0) {
            int n = scan.nextInt();

            int[] bars = new int[n];

            for (int i = 0; i < n; i++) {
                bars[i] = scan.nextInt();

            }

            MaxRectFromHistogram maxHist = new MaxRectFromHistogram();
            System.out.println("output: "+maxHist.maxContiguousBars(bars));

            testCases--;
        }
    }

    /**
     * Given an array which represents the in order heights of the histogram bars,
     * returns the area of the rectangle with the largest area in the histogram.
     * 
     * @param bars the heights of the histogram bars (all width of bars = 1)
     * @return the area of the rectangle with the largest area in the histogram
     */
    private long maxContiguousBars(int[] bars) {
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
                int w = -1;
                while (!height.empty() && height.peek() > bars[i]) {
                    //rect continues from previous
                    //rectangle with height stored in height.peek() has ended
                    h = height.pop();
                    w = pos.pop();
                    long area = Long.valueOf(h) * Long.valueOf(i - w);
                    curMax = Math.max(area, curMax);


                }
                if (w != -1) {
                    //rect continued from index w 
                    //push the last index back onto the pos stack along with current bar because rect continues from previous
                    pos.push(w);
                    height.push(bars[i]);
                } 
                else if (!height.empty() && height.peek() < bars[i]) {//new rectangle, rect did not continue 
                    pos.push(i);
                    height.push(bars[i]);
                }

            }

        }
        //compute rect value for remaining elements on stack
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
