/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 * @author Mathew Wright
 */
public class PythagoreanTriplet {

    /**
     * Takes formulated console input and returns "Yes" if array contains a pythogrean triplet, (a, b, c) that satisfies a2 + b2 = c2
     * 
     * Input:
     * The first line contains T, denoting the number of test cases. 
     * Then follows description of test cases. 
     * Each case begins with a single positive integer N denoting the size of array. 
     * The second line contains the N space separated positive integers denoting the elements of array A.
     * 
     * Output:
     * For each test case, print "Yes" or  "No" whether it is Pythagorean Triplet or not (without quotes).
     * 
     * 
     * Example:
     * Input:
     * 1
     * 5
     * 3 2 4 6 5
     * 
     * Output:
     * Yes
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases > 0) {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int n = Integer.parseInt(strs[0]);

            int[] values = new int[n];

            line = br.readLine();
            strs = line.trim().split("\\s+");

            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(strs[i]);
                values[i] *= values[i];

            }

            PythagoreanTriplet gfg = new PythagoreanTriplet();
            String result = gfg.containsSummedTripet(values);

            System.out.println("output: "+result);

            testCases--;
        }
    }

    /**
     * Given an array of ints, return "Yes" if a[i] + a[j] == a[k], otherwise return "No"
     * @param arr the array to check
     * @return yes if contains summed triplet(a,b,c where a+b=c), false otherwise
     */
    public String containsSummedTripet(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            //if (arr[i] == 0){
            //    return "error";
            //}
            hashMap.put(arr[i], 1);

        }

        for (int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr.length; b++) {

                if (!(a == b)) {
                    if (hashMap.containsKey(arr[a] + arr[b])) {
                        return "Yes";
                    }
                }
            }
        }
        return "No";

    }
}
