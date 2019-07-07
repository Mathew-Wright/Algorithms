/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;

/**
 * Given a list of non negative integers, 
 * arrange them in such a manner that they form the largest number possible.
 * The result is going to be very large, hence return the result in the form of a string.
 * 
 * 
 * @author Mathew Wright
 */
class LargestNumberFormedFromArray {

    /**
     * Takes formulated console input and returns the largest number that can be formulated
     * from a given array of integers.
     * 
     * Input:
     * The first line of input consists number of the test cases. The description of T test cases is as follows:
     * The first line of each test case contains the size of the array, and the second line has the elements of the array.
     * 
     * Output:
     * In each separate line print the largest number formed by arranging the elements of the array in the form of a string.
     * 
     * 
     * Example:
     * Input:
     * 2
     * 5
     * 3 30 34 5 9
     * 4
     * 54 546 548 60
     * 
     * Output:
     * 9534330
     * 6054854654
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases > 0) {

            int n = Integer.parseInt(br.readLine());

            String[] values = new String[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int i = 0; i < n; i++) {
                values[i] = strs[i];

            }

            LargestNumberFormedFromArray gfg = new LargestNumberFormedFromArray();
            String result = gfg.largestNumber(values);

            System.out.println(result);

            testCases--;
        }
    }

    public String largestNumber(String[] numbers) {
        String result = "";
        PriorityQueue<String> pq = new PriorityQueue<>(new StartingDigitComparator());

        for (String s : numbers) {
            pq.add(s);
        }
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        return result;
    }

    /**
     * Custom comparator object, given two ints (a,b) in the form of two strings,
     * calculates the largest value between a append b and b append a
     * 
     * a = 11
     * b = 9
     * a append b = 119
     * b append a = 911
     * b append a is larger
     */
    private class StartingDigitComparator implements Comparator<String> {

        /**
         * Handler function for comparator of the class
         * @param a int a
         * @param b int b
         * @return 1 if a append b less than b append a, 0 if equals, else -1
         */
        @Override
        public int compare(String a, String b) {
            Integer ab = Integer.parseInt(a + b);
            Integer ba = Integer.parseInt(b + a);
            System.out.println(ab + ","+ba + "=="+ba.compareTo(ab));
            return ba.compareTo(ab);
        }
    }
}
