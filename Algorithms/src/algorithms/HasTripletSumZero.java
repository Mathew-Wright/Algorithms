/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 * Given an array A[] of N elements. The task is to complete the function which returns true if triplets exists in array A whose sum is zero else returns false.
 * 
 * Input:
 * 2
 * 5
 * 0 -1 2 -3 1
 * 3
 * 1 2 3
 * 
 * Output:
 * 1
 * 0
 * 
 * https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
 * @author Geeks4Geeks
 */
import java.util.*;

class HasTripletSumZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Triplet g = new Triplet();
            if (g.findTriplets(a, n)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }
    }
}

/**
 * Calculates whether or not an array has 3 values in it which sum to zero
 * @author Mathew Wright
 */
class Triplet {
    /**
     * Returns true if a triplet in array has sum 0
     * @param arr input array
     * @param n size of the array
     * @return true if there is a triplet with sum 0, false otherwise
     */
    public boolean findTriplets(int arr[], int n) {
        int p1 = 0, p2 = 1, p3 = n - 1;
        Arrays.sort(arr);

        while (p2 < p3) {
            while (p2 < p3) {

                int s = arr[p1] + arr[p2] + arr[p3];
                if (s == 0) {
                    return true;
                } else if (s < 0) {
                    p2++;
                } else {
                    p3--;
                }
            }
            p1++;
            p2 = p1 + 1;
            p3 = n - 1;

        }
        return false;
    }
}
