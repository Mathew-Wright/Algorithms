/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 * Given two unsorted arrays A of size N and B of size M of distinct elements,
 * the task is to find all pairs from both arrays whose sum is equal to X,
 * a pair consists of one value from each array.
 * 
 * Example:
 * Input:
 * 2
 * 5 5 9
 * 1 2 4 5 7
 * 5 6 3 4 8
 * 2 2 3
 * 0 2
 * 1 3
 * Output:
 * 1 8, 4 5, 5 4
 * 0 3, 2 1
 * 
 * https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x/0
 * @author Mathew Wright
 */

import java.util.*;


class AllPairsGivenSum {
    
    /**
     * Takes console input and prints out All the pairs with the given sum
     * from the two provided arrays
     * 
     * The first line of input contains an integer T denoting the no of test cases.
     * Then T test cases follow. Each test case contains 3 lines. 
     * The first line contains 3 space separated integers N, M, X.
     * N and M and the sizes of the first and second array respectively.
     * X is the sum you wish to find the pairs for.
     * Then in the next two lines are space separated values of the array A and B respectively.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while (testCases > 0) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int s = scan.nextInt();

            int[] nums1 = new int[n1];
            int[] nums2 = new int[n2];

            for (int i = 0; i < n1; i++) {
                nums1[i] = scan.nextInt();
            }
            for (int i = 0; i < n2; i++) {
                nums2[i] = scan.nextInt();
            }

            ArrayList<int[]> result = findAllPairsWithSum(nums1, nums2, s);
            if (result.isEmpty()) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0 && i != result.size()) {
                        System.out.print(", ");
                    }
                    System.out.print(result.get(i)[0] + " " + result.get(i)[1]);
                }

                System.out.println();
            }

            testCases--;
        }
    }

    /**
     * Handler method that returns all pairs (1 value from each array) which
     * has a sum of s
     * @param nums1 array1
     * @param nums2 array2
     * @param s sum to search for
     * @return 
     */
    private static ArrayList<int[]> findAllPairsWithSum(int[] nums1, int[] nums2, int s) {
        Arrays.sort(nums1);//solution wants results ordered by n1 ascending
        HashMap<Integer, Boolean> numSet2 = new HashMap<>();
        ArrayList<int[]> result = new ArrayList<>();

        for (int i : nums2) {
            numSet2.put(i, true);
        }
        for (int i : nums1) {
            if (numSet2.containsKey(s - i)) {
                result.add(new int[]{i, s - i});
            }
        }

        return result;

    }
}
