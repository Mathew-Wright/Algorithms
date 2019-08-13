/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Given an array A[] and a range [a, b]. The task is to partition the array
 * around the range such that array is divided in three parts. 
 * 1) All elements smaller than a come first. 
 * 2) All elements in range a to b come next. 
 * 3) All elements greater than b appear in the end. 
 * The individual elements of three sets can appear in any order.
 * 
 * https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
 * @author Mathew Wright
 */
public class ThreeWayPartitioning {

    /**
     * Reads formulated console input for array and two ints a,b.
     * Prints to console the array after it has been partitioned into three parts.
     * A = [A[i] < a,    A[i] > a && A[i] <= b,     A[i] > b]
     * Input Format: 
     * The first line
     * of input contains an integer T denoting the number of test cases. Then T
     * test cases follow. First line of each test case contains an integer N
     * denoting the size of the array. Then in the next line are N space
     * separated values of the array (A[]).
     *
     * Output Format: For each test case the output will be 1 if the array is
     * properly arranged else it would be 0.
     *
     *
     *
     *Example:
     *Input:
     *2
     *5
     *1 2 3 3 4
     *1 2
     *3
     *1 2 3
     *1 3
     *
     *Output:
     *1
     *1
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            ArrayList<Integer> A = new ArrayList<>();
            int[] hash = new int[1000001];
            Arrays.fill(hash, 0);

            String str[] = read.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                int val = Integer.parseInt(str[i]);
                A.add(i, val);

                hash[A.get(i)]++;
            }

            str = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 0; i < A.size(); i++) {
                B.add(i, A.get(i));
            }
            int k1 = 0, k2 = 0, k3 = 0;
            int kk1 = 0;
            int kk2 = 0;
            int kk3 = 0;
            for (int i = 0; i < B.size(); i++) {
                if (B.get(i) > m) {
                    k3++;
                } else if (B.get(i) <= m && B.get(i) >= n) {
                    k2++;
                } else if (B.get(i) < m) {
                    k1++;
                }
            }
            ThreeWayPartitioning g = new ThreeWayPartitioning();
            ArrayList<Integer> Res = g.threeWayPartition(A, n, m);
            for (int i = 0; i < k1; i++) {
                if (Res.get(i) < m) {
                    kk1++;
                }
            }
            for (int i = k1; i < k1 + k2; i++) {

                if (Res.get(i) <= m && Res.get(i) >= n) {
                    kk2++;
                }

            }
            for (int i = k1 + k2; i < k1 + k2 + k3; i++) {
                if (Res.get(i) > m) {
                    kk3++;
                }
            }
            boolean ok = false;
            if (k1 == kk1 && k2 == kk2 && k3 == kk3) {
                ok = true;
            }

            for (int i = 0; i < Res.size(); i++) {
                hash[Res.get(i)]--;
            }

            for (int i = 0; i < Res.size(); i++) {
                if (hash[Res.get(i)] != 0) {
                    ok = false;
                }
            }
            System.out.print("output: ");
            if (ok) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    /**
     * Given an arraylist and two ints a,b,
     * returns partitioned arraylist AL which contains 3 segments where
     * AL = [AL[i] < a,    AL[i] > a && AL[i] <= b,     AL[i] > b]
     * @param A ArrayList to partition
     * @param a first segment less than a
     * @param b last segment greater than b
     * @return 
     */
    public ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int a, int b) {
        ArrayList<Integer> result = new ArrayList<>(A.size());
        LinkedList<Integer> LTA = new LinkedList<>();
        LinkedList<Integer> ATOB = new LinkedList<>();
        LinkedList<Integer> GTB = new LinkedList<>();

        for (int i : A) {
            if (i < a) {
                LTA.add(i);
            } else if (i <= b) {
                ATOB.add(i);
            } else {
                GTB.add(i);
            }
        }

        for (int i : LTA) {
            result.add(i);
        }
        for (int i : ATOB) {
            result.add(i);
        }
        for (int i : GTB) {
            result.add(i);
        }
        return result;

    }
}
