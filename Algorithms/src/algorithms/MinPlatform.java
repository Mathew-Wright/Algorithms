/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/*package whatever //do not write package name here */
import java.util.*;
import java.lang.*;
import java.io.*;


/**
 * Given arrival and departure times of all trains that reach a railway station.
 * Your task is to find the minimum number of platforms required for the railway
 * station so that no train waits.
 *
 * https://practice.geeksforgeeks.org/problems/minimum-platforms/0
 * @author Mathew Wright
 */
public class MinPlatform {

    
    /**
     * Reads formulated console input for train arrival and departure times,
     * prints to console minimum number of platforms required so that no
     * train needs to wait to use a platform.
     * 
     * Input:
     * The first line of input contains T, the number of test cases. For
     * each test case, first line will contain an integer N, the number of
     * trains. Next two lines will consist of N space separated time intervals
     * denoting arrival and departure times respectively. Note: Time intervals
     * are in the 24-hour format(hhmm), of the for HHMM , where the first two
     * characters represent hour (between 00 to 23 ) and last two characters
     * represent minutes (between 00 to 59).
     *
     * Output:
     * For each test case, print the minimum number of platforms
     * required for the trains to arrive and depart safely.
     *
     * 
     * Example:
     * Input:
     * 2
     * 6 
     * 0900  0940 0950  1100 1500 1800
     * 0910 1200 1120 1130 1900 2000
     * 3
     * 0900 1100 1235
     * 1000 1200 1240 
     * 
     * Output:
     * 3
     * 1
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {

            int n = scanner.nextInt();
            int in[] = new int[n];
            int out[] = new int[n];

            for (int i = 0; i < n; i++) {

                in[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {

                out[i] = scanner.nextInt();
            }

            System.out.println("output: "+minPlatforms(in, out));

            t--;
        }
    }

    /**
     * Given arrival and departure times of trains, returns the number of platforms
     * required so that no train is waiting for a platform.
     * 
     * @param in arrival times of trains
     * @param out departure times of trains.
     * @return he number of platforms
     * required so that no train is waiting for a platform.
     */
    private static int minPlatforms(int[] in, int[] out) {

        //sort ascending
        Arrays.sort(in);
        Arrays.sort(out);

        int inI = 0;
        int outI = 0;

        int platforms = 0;
        int maxPlatforms = 0;

        //while platform count could increase
        while (inI < in.length && outI < out.length) {

            if (in[inI] <= out[outI]) {//next event is train arriving
                platforms++;
                inI++;

                //update possible max
                maxPlatforms = Math.max(maxPlatforms, platforms);
            } else {//next event is train leaving
                outI++;
                platforms--;

            }
        }

        return maxPlatforms;

    }
}
