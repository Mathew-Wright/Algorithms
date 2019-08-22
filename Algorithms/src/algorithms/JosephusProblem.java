/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;


/**
 * Given the total number of persons n and a number k which indicates that k-1
 * persons are skipped and kth person is killed in circle in a fixed direction.​
 * Find the original location of the last survivor.
 *
 * https://practice.geeksforgeeks.org/problems/josephus-problem/1
 * @author Mathew Wright
 */
public class JosephusProblem {

    
    /**
     * Reads formulated console for number of participants and int k denoting
     * how much people are skipped before a victim is selected,
     * prints to console the original position of the last survivor.
     * 
     * Input Format: The first line of input contains an integer T denoting the
     * number of test cases. Then T test cases follow. Each test case contains
     * 2 integers n and k.
     *
     * Output Format: For each test case, in a new line, output will be the safe
     * position of the last survivor.
     *
     *
     * Constraints:
     * k greater than 0
     * n greater than 0
     *
     * Example:
     * Input:
     * 2
     * 3 2
     * 5 3
     * Output
     * 3
     * 4
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {

            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();

            System.out.println("output: "+josephus(n, k));

        }

    }

    /**
     * Given the number of participants n and an int k, 
     * returns the original position of the last survivor for the 
     * Josephus Problem.
     * 
     * @param n number of participants
     * @param k how much people are skipped before a victim is selected
     * @return 
     */
    public static int josephus(int n, int k) {
        if (n <= 0 || k <= 0) {//illegal argument value
            return -1;
        }

        ArrayList<Integer> alive = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            alive.add(i + 1);
        }

        int currentIndex = 0;
        k--;//only k-1 are skipped
        while (alive.size() > 1) {
            //get index of next victim, 
            //wrapping around to start of list if list limit is reached
            
            currentIndex = (currentIndex + k) % alive.size();

            //'remove' the victim
            alive.remove(currentIndex);

        }
        return alive.get(0);//return original position of survivor

    }
}
