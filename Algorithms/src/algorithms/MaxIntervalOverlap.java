/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;


/**
 * Given (time) intervals, calculate the maximum overlap of the intervals,
 * retrieving the max number of intervals active at once and at what time they where active.
 * https://practice.geeksforgeeks.org/problems/maximum-intervals-overlap/0
 * @author Mathew Wright
 */
public class MaxIntervalOverlap {

    /**
     * Reads formulated console input for the time intervals,
     * prints to console the max number of intervals active at once and at what time they where active
     * 
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. 
     * Then T test cases follow. 
     * Each test case contains an integer n denoting the size of the entry and exit array. 
     * Then the next two line contains the entry and exit array respectively.
     * 
     * Output:
     * Print the maximum no of guests and the time at which there are maximum guests in the party.
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 1 2 10 5 5
     * 4 5 12 9 12
     * 7
     * 13 28 29 14 40 17 3 
     * 107 95 111 105 70 127 74 
     * 
     * Output:
     * 3 5
     * 7 40
     * 
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            int in[] = new int[n];
            int out[] = new int[n];

            StringBuilder sb = new StringBuilder();
            String strIn[] = br.readLine().trim().split(" ");
            String strOut[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(strIn[i]);
                out[i] = Integer.parseInt(strOut[i]);
            }

            int[] result = maxInterval(in, out);
            System.out.println("output: "+result[0] + " " + result[1]);

            t--;
        }
    }

    
    /**
     * Given intervals in the form of two arrays, one entry and one exit array,
     * returns the max number of intervals active at once and at what time they where active.
     * 
     * @param in input times
     * @param out output times
     * @return Max number of intervals active at once and at what time they where active
     */
    private static int[] maxInterval(int[] in, int[] out) {
        if (in.length != out.length) {
            return new int[]{-1, -1};
        }
        //sort both arrays
        Arrays.sort(in);
        Arrays.sort(out);
        int count = 0;
        int maxCount = 0;
        int maxTime = 0;

        //System.out.println(Arrays.toString(in));
        //System.out.println(Arrays.toString(out));
        int i = 0;
        int o = 0;
        int time = 0;
        while (i < in.length && o < in.length) {

            //process all entires < current time
            while (i < in.length && in[i] <= time) {
                count++;
                i++;

            }

            //update max count / max time
            if (count > maxCount) {
                maxCount = count;
                maxTime = time;
            }

            //process all leavers < current time
            while (o < in.length && out[o] <= time) {
                count--;
                o++;
            }

            //increment time
            if (i < in.length) {
                time = in[i];
                //process all leavers < current time
                // < and not <= because if out[o] == time,
                //people entering have a priority over people leaving
                //so we must count entires of <= time before exit of == time
                while (o < in.length && out[o] < time) {
                    count--;
                    o++;
                }
            }
        }
                

        return new int[]{maxCount, maxTime};

    }

}
