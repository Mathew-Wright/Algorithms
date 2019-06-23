/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 * A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * First line contains the test cases T.
 * Each test case have two lines
 * First is length of string N.
 * Second line is string S of digits from '0' to '9' of N length.
 * 
 * Example:
 * Input:
 * 2
 * 3
 * 123
 * 4
 * 2563
 * Output:
 * 3
 * 2
 * 
 * @author Mathew Wright
 */
public class DecodeCombinations {

    /**
     * Takes in console input, outputs the number of possible decoded combinations.
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while (testCases > 0) {
            int n = scan.nextInt();
            int[] nums = new int[n];

            if (n > 0) {
                String str = scan.next();

                for (int i = 0; i < n; i++) {
                    nums[i] = Character.getNumericValue(str.charAt(i));

                }

            }

            System.out.println(decodeCombinations(nums));

            testCases--;
        }
    }

    /**
     * Handler method, takes in the ints and returns the
     * number of possible decoded combinations.
     * @param nums the ints that represent the message (int values = 0-9 only)
     * @return 
     */
    private static int decodeCombinations(int[] nums) {

        if (nums.length > 0) {
            if (nums[0] == 0) {//no combination possible
                return 0;
            }

            //pre-pair 0's to previous index
            int zeroCount = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (nums[i - 1] == 1 || nums[i - 1] == 2) {// A0, can only pre-pair if A == 1 || A == 2
                        nums[i - 1] = nums[i - 1] * 10;
                        zeroCount++;
                    } else {
                        return 0;
                    }

                }
            }

            int[] prePairZeros = new int[nums.length - zeroCount];

            int j = 0;
            int l = 0;

            while (j < nums.length) {
                if (nums[j] != 0) {
                    prePairZeros[l] = nums[j];
                    l++;
                }
                j++;

            }

            return decodeCombinationsRecursive(prePairZeros, false);
        } else {//nums.length == 0
            return decodeCombinationsRecursive(nums, false);
        }

    }

    /**
     * Handler method, takes in the ints and returns the
     * number of possible decoded combinations.
     * @param nums the ints that represent the message 
     *      (int values = 1-10 only, 
     *      0 at a given index i should be paired with value at index i-1
     *      (this is done by decodeCombinations()))
     * @return 
     */
    private static int decodeCombinationsRecursive(int[] nums, boolean previousWasPaired) {

        //nums contains no zeros, they where pre-paired
        //System.out.println(Arrays.toString(nums)+","+ previousWasPaired);
        if (nums.length <= 1) {//base case
            //only less than 1 on edge case where inital array is empty
            return 1;
        }

        int result = 0;
        int[] reduced = removeFirstDigit(nums);
        int a = nums[0];

        //attempt to not pair
        result += decodeCombinationsRecursive(reduced, false);

        if (nums.length > 1 && !previousWasPaired) {//ABC, cannot pair BC if AB where paired
            int b = nums[1];

            if (b < 10 && (a * 10 + b) >= 10 && (a * 10 + b) <= 26) {//b>=10 means it was pre-paired

                //attempt to pair
                result += decodeCombinationsRecursive(reduced, true);
            }
        }

        return result;
    }

    private static int[] removeFirstDigit(int[] num) {

        int[] num2 = new int[num.length - 1];
        for (int i = 0; i < num2.length; i++) {
            num2[i] = num[i + 1];
        }
        return num2;
    }

}
