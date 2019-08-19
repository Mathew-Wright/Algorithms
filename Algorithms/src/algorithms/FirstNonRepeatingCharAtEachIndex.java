/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;


/**
 * Given an input stream of N characters consisting only of lower case alphabets. 
 * The task is to find the first non repeating character, each time a character is inserted to the stream. 
 * If no non repeating element is found print -1.
 * 
 * https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
 * @author Mathew Wright
 */
public class FirstNonRepeatingCharAtEachIndex {

    /**
     * Reads formulated console input for a list of alphabet chars,
     * for each index in the list, print the first non repeating character, -1 if none found.
     * 
     * Input:
     * The first line of input contains an integer T denoting the no of test cases. 
     * Then T test cases follow. Each test case contains an integer N denoting the size of the stream. 
     * Then in the next line are x characters which are inserted to the stream.
     * 
     * Output:
     * For each test case in a new line print the first non repeating elements 
     * separated by spaces present in the stream at every instinct when a character is added to the stream, 
     * if no such element is present print -1.
     * 
     * Example:
     * Input:
     * 2
     * 4
     * a a b c
     * 3
     * a a c
     * 
     * Output:
     * a -1 b b
     * a -1 c
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String arr[] = new String[n];

            String str[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = str[i];
            }
            System.out.print("output: ");
            for (String i : firstNonRepeatingAtEachIndexHandler(arr)) {
                System.out.print(i + " ");

            }
            System.out.println();

            t--;
        }
    }

    /**
     * Given an array of strings, for each index in the array, 
     * return the first non repeating string (in the resulting array), -1 if none found.
     * @param arr array of strings to search
     * @return for each index i in array, value at i is the first non repeating string
     * from index 0 to i in given array, -1 if none found.
     */
    private static String[] firstNonRepeatingAtEachIndexHandler(String[] arr) {
        HashMap<String, Integer> freq = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        String[] result = new String[arr.length];
        int index = 0;

        for (String i : arr) {
            //update frequency value of string
            int count = freq.containsKey(i) ? freq.get(i) + 1 : 1;
            freq.put(i, count);
            
            //add to queue if value is non repeating
            if (count == 1) {
                queue.offer(i);

            }

            //get the first non repeating value
            String v = queue.peek();
            while (v != null && freq.get(v) != 1) {
                queue.poll();
                v = queue.peek();

            }

            if (v == null) {
                result[index] = "-1";
            } else {
                result[index] = v;
            }
            index++;

        }
        return result;
    }
}
