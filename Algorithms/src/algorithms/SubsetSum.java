/*
 * My solution to Subarray with given sum problem
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 * code has been adapted to run outside of the websites environment
 */
package algorithms;

import java.util.Arrays;


/**
 * Given an unsorted array A of size N of non-negative integers, 
 * find a continuous sub-array which adds to a given number S.
 * @author Mathew Wright
 */
class SubsetSum {

    /**
     * Basic method that prints error message to console
     */
    public static void usage() {
        System.out.println("Incorrect use of function\n"
                + "please input only posative integers\n"
                + "the first integer should be the sum you want to find\n"
                + "the remaining intergers form the subarray");
    }

    /**
     * Gets the starting and ending index that contains the subarray which has a
     * sum of s, prints -1 if no subarray is found
     *
     * @param args array of strings which are posative integers, the first value
     * is the sum to search for and the remaining values are the array to search
     */
    public static void main(String[] args) {

        if (args.length <= 2) {
            usage();
        } else {
            try {

                int n = args.length - 1;
                int s = Integer.parseInt(args[0]);
                Integer arr[] = new Integer[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(args[i + 1]);
                }

                System.out.println("sum to find: " + s);
                System.out.println("array to search: " + Arrays.toString(arr));

                if (n == 0) {
                    System.out.println(-1);
                } else {
                    int[] result = findsum(arr, n, s, arr[0], 0, 0);

                    if (result[0] == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println("subarray start/end indices: " + (result[0]) + ", " + (result[1]));

                        int sum = 0;
                        for (int i = result[0]; i <= result[1]; i++) {
                            System.out.print(arr[i] + "+");
                            sum += arr[i];
                        }
                        System.out.println("\b=" + sum);
                    }
                }
            } catch (NumberFormatException e) {
                usage();
            }
        }

    }

    /**
     * Gets the starting and ending index that contains the subarray which has a
     * sum of s, prints -1 if no subarray is found
     *
     * @param arr the array containing values (posative integers)
     * @param n the size of the array
     * @param s the sum to be searched for
     *
     */
    private static int[] findsum(Integer[] arr, int n, int s, int currentSum, int start, int end) {
        if (currentSum == s) {//sum found
            return new int[]{start, end};
        } else if (currentSum < s) {//increase end index
            if (end + 1 < n) {

                return findsum(arr, n, s, currentSum + arr[end + 1], start, end + 1);

            }
            return new int[]{-1, -1};
        } else {//currentSum>s, increase start index
            if (start + 1 < n) {
                if (start == end) {//increase both start and end index
                    return findsum(arr, n, s, arr[start + 1], start + 1, end + 1);
                }

                return findsum(arr, n, s, currentSum - arr[start], start + 1, end);
            }
            return new int[]{-1, -1};
        }
    }

}
